package sv.CCA.Asistencia_API.controller;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import sv.CCA.Asistencia_API.dto.*;
import sv.CCA.Asistencia_API.entity.*;
import sv.CCA.Asistencia_API.repository.*;

@RestController
@RequestMapping("/api/movil")
public class MovilController {
    private final HorarioRepository horarios;
    private final MatriculaRepository matriculas;
    private final EstudianteRepository estudiantes;
    private final AsistenciaRepository asistencias;

    public MovilController(HorarioRepository horarios, MatriculaRepository matriculas, EstudianteRepository estudiantes, AsistenciaRepository asistencias) {
        this.horarios = horarios; this.matriculas = matriculas; this.estudiantes = estudiantes; this.asistencias = asistencias;
    }

    @GetMapping("/docentes/{docenteId}/horarios")
    public List<HorarioMovilResponse> horariosDocente(@PathVariable String docenteId, @RequestParam(required=false) Integer diaSemana) {
        List<Horario> lista = diaSemana == null ? horarios.findByDocenteId(docenteId) : horarios.findByDocenteIdAndDiaSemana(docenteId, diaSemana);
        return lista.stream().map(h -> new HorarioMovilResponse(h.getId(), h.getSeccionId(), h.getDiaSemana(), h.getNumeroPeriodo(), h.getHoraInicio(), h.getHoraFin(), h.getAsignatura())).toList();
    }

    @GetMapping("/secciones/{seccionId}/estudiantes")
    public List<EstudianteMovilResponse> estudiantesSeccion(@PathVariable String seccionId) {
        return matriculas.findBySeccionIdAndEstado(seccionId, "ACTIVA").stream()
            .map(m -> {
                try {
                    return estudiantes.findById(UUID.fromString(m.getEstudianteId())).map(e -> new EstudianteMovilResponse(e.getId().toString(), e.getNie(), e.getNombres(), e.getApellidos())).orElse(null);
                } catch (IllegalArgumentException ex) { return null; }
            }).filter(e -> e != null).toList();
    }

    @PostMapping("/asistencia/lote")
    @Transactional
    public ResponseEntity<?> registrarAsistenciaLote(@Valid @RequestBody RegistroAsistenciaLoteRequest solicitud) {
        String momento = solicitud.momento().toUpperCase();
        if (!momento.equals("ENTRADA") && !momento.equals("CLASE")) return ResponseEntity.badRequest().body(error("momento debe ser ENTRADA o CLASE"));
        if (momento.equals("ENTRADA") && solicitud.horarioId() != null) return ResponseEntity.badRequest().body(error("ENTRADA no debe incluir horarioId"));
        if (momento.equals("CLASE") && (solicitud.horarioId() == null || !horarios.existsByIdAndDocenteId(solicitud.horarioId(), solicitud.docenteId()))) return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error("El horario no pertenece al docente"));
        if (momento.equals("CLASE") && !horarios.findById(solicitud.horarioId()).map(h -> h.getSeccionId().equals(solicitud.seccionId())).orElse(false)) return ResponseEntity.badRequest().body(error("El horario no corresponde a la sección"));

        int diaSemana = solicitud.fecha().getDayOfWeek().getValue();
        List<Horario> horariosSeccion = horarios.findByDocenteIdAndDiaSemana(solicitud.docenteId(), diaSemana).stream()
            .filter(h -> h.getSeccionId().equals(solicitud.seccionId())).toList();
        if (horariosSeccion.isEmpty()) return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error("El docente no tiene horario asignado en esta sección para ese día"));
        if (momento.equals("ENTRADA")) {
            int primerPeriodo = horarios.findBySeccionIdAndDiaSemana(solicitud.seccionId(), diaSemana).stream().mapToInt(Horario::getNumeroPeriodo).min().orElse(Integer.MAX_VALUE);
            if (horariosSeccion.stream().noneMatch(h -> h.getNumeroPeriodo() == primerPeriodo)) return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error("Solo el docente del primer periodo puede registrar la ENTRADA"));
        }
        List<String> permitidos = List.of("PRESENTE", "AUSENTE_INJUSTIFICADO", "PERMISO_JUSTIFICADO", "LLEGADA_TARDIA", "EVASION");
        for (var r : solicitud.registros()) {
            boolean matriculado = matriculas.findBySeccionIdAndEstado(solicitud.seccionId(), "ACTIVA").stream()
                .anyMatch(m -> m.getEstudianteId().equals(r.estudianteId()));
            if (!matriculado) return ResponseEntity.badRequest().body(error("El estudiante " + r.estudianteId() + " no tiene matrícula activa en esta sección"));
            String estado = r.estado().toUpperCase();
            if (!permitidos.contains(estado)) return ResponseEntity.badRequest().body(error("Estado de asistencia no válido: " + estado));
            if (estado.equals("LLEGADA_TARDIA") && !momento.equals("ENTRADA")) return ResponseEntity.unprocessableEntity().body(error("LLEGADA_TARDIA solo se permite en ENTRADA"));
            if (estado.equals("EVASION")) {
                if (!momento.equals("CLASE")) return ResponseEntity.unprocessableEntity().body(error("EVASION solo se permite en CLASE"));
                boolean tieneEntrada = asistencias.existsByEstudianteIdAndFechaAndMomentoAndEstadoIn(r.estudianteId(), solicitud.fecha(), "ENTRADA", List.of("PRESENTE", "LLEGADA_TARDIA"));
                if (!tieneEntrada) return ResponseEntity.unprocessableEntity().body(error("No se puede registrar EVASION sin ENTRADA presente o tardía"));
            }
            if (estado.equals("PERMISO_JUSTIFICADO") && (r.justificacion() == null || r.justificacion().isBlank())) return ResponseEntity.badRequest().body(error("La justificación es obligatoria para PERMISO_JUSTIFICADO"));
        }

        int guardados = 0, duplicados = 0;
        for (var r : solicitud.registros()) {
            if (asistencias.findByClientUuid(r.clientUuid()).isPresent() ||
                asistencias.existsByEstudianteIdAndFechaAndMomentoAndHorarioId(r.estudianteId(), solicitud.fecha(), momento, solicitud.horarioId())) { duplicados++; continue; }
            Asistencia a = new Asistencia();
            a.setEstudianteId(r.estudianteId()); a.setSeccionId(solicitud.seccionId()); a.setAnioLectivoId(solicitud.anioLectivoId());
            a.setFecha(solicitud.fecha()); a.setMomento(momento); a.setHorarioId(solicitud.horarioId()); a.setHoraRegistro(LocalTime.now());
            a.setEstado(r.estado().toUpperCase()); a.setJustificacion(r.justificacion()); a.setTardanzaConsumidaEn(null); a.setClienteID(r.clientUuid()); a.setRegistradoPor(solicitud.docenteId());
            asistencias.save(a); guardados++;
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new LoteResponse(guardados, duplicados, "Registros procesados"));
    }

    private ErrorResponse error(String mensaje) { return new ErrorResponse(mensaje); }
    public record ErrorResponse(String error) {}
    public record LoteResponse(int guardados, int duplicadosIgnorados, String mensaje) {}
}
