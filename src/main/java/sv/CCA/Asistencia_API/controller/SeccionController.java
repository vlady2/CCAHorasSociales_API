package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.Seccion;
import sv.CCA.Asistencia_API.service.SeccionService;

@RestController
@RequestMapping("/api/secciones")
public class SeccionController {

    private final SeccionService servicio;

    public SeccionController(SeccionService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Seccion> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Seccion buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public Seccion guardar(@RequestBody Seccion registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public Seccion actualizar(@PathVariable String id, @RequestBody Seccion registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
