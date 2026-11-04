package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.Sesion;
import sv.CCA.Asistencia_API.service.SesionService;

@RestController
@RequestMapping("/api/sesiones")
public class SesionController {

    private final SesionService servicio;

    public SesionController(SesionService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Sesion> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Sesion buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public Sesion guardar(@RequestBody Sesion registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public Sesion actualizar(@PathVariable String id, @RequestBody Sesion registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
