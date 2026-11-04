package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.Asistencia;
import sv.CCA.Asistencia_API.service.AsistenciaService;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaController {

    private final AsistenciaService servicio;

    public AsistenciaController(AsistenciaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Asistencia> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Asistencia buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public Asistencia guardar(@RequestBody Asistencia registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public Asistencia actualizar(@PathVariable String id, @RequestBody Asistencia registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
