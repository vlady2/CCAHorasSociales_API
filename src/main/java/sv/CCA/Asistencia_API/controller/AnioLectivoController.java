package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.AnioLectivo;
import sv.CCA.Asistencia_API.service.AnioLectivoService;

@RestController
@RequestMapping("/api/anios-lectivos")
public class AnioLectivoController {

    private final AnioLectivoService servicio;

    public AnioLectivoController(AnioLectivoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<AnioLectivo> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public AnioLectivo buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public AnioLectivo guardar(@RequestBody AnioLectivo registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public AnioLectivo actualizar(@PathVariable String id, @RequestBody AnioLectivo registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
