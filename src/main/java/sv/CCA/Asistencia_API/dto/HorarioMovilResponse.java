package sv.CCA.Asistencia_API.dto;

import java.time.LocalTime;
public record HorarioMovilResponse(String id, String seccionId, Integer diaSemana, Integer numeroPeriodo, LocalTime horaInicio, LocalTime horaFin, String asignatura) {}
