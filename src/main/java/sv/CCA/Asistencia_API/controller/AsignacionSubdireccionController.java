package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.AsignacionSubdireccion;
import sv.CCA.Asistencia_API.service.AsignacionSubdireccionService;

@RestController
@RequestMapping("/api/asignaciones-subdireccion")
public class AsignacionSubdireccionController {

    private final AsignacionSubdireccionService servicio;

    public AsignacionSubdireccionController(AsignacionSubdireccionService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<AsignacionSubdireccion> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public AsignacionSubdireccion buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public AsignacionSubdireccion guardar(@RequestBody AsignacionSubdireccion registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public AsignacionSubdireccion actualizar(@PathVariable String id, @RequestBody AsignacionSubdireccion registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
