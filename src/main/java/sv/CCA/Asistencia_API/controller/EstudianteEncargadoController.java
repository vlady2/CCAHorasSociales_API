package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.EstudianteEncargado;
import sv.CCA.Asistencia_API.service.EstudianteEncargadoService;

@RestController
@RequestMapping("/api/estudiante-encargado")
public class EstudianteEncargadoController {

    private final EstudianteEncargadoService servicio;

    public EstudianteEncargadoController(EstudianteEncargadoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<EstudianteEncargado> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public EstudianteEncargado buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public EstudianteEncargado guardar(@RequestBody EstudianteEncargado registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public EstudianteEncargado actualizar(@PathVariable String id, @RequestBody EstudianteEncargado registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
