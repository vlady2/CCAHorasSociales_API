package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.Matricula;
import sv.CCA.Asistencia_API.service.MatriculaService;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaService servicio;

    public MatriculaController(MatriculaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Matricula> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Matricula buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public Matricula guardar(@RequestBody Matricula registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public Matricula actualizar(@PathVariable String id, @RequestBody Matricula registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
