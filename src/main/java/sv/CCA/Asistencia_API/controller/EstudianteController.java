package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.Estudiante;
import sv.CCA.Asistencia_API.service.EstudianteService;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService servicio;

    public EstudianteController(EstudianteService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Estudiante> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Estudiante buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public Estudiante guardar(@RequestBody Estudiante registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public Estudiante actualizar(@PathVariable String id, @RequestBody Estudiante registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
