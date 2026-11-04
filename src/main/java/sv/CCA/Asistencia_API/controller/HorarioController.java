package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.Horario;
import sv.CCA.Asistencia_API.service.HorarioService;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    private final HorarioService servicio;

    public HorarioController(HorarioService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Horario> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Horario buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public Horario guardar(@RequestBody Horario registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public Horario actualizar(@PathVariable String id, @RequestBody Horario registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
