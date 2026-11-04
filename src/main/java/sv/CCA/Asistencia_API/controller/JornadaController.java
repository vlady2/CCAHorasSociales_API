package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.Jornada;
import sv.CCA.Asistencia_API.service.JornadaService;

@RestController
@RequestMapping("/api/jornadas")
public class JornadaController {

    private final JornadaService servicio;

    public JornadaController(JornadaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Jornada> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Jornada buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public Jornada guardar(@RequestBody Jornada registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public Jornada actualizar(@PathVariable String id, @RequestBody Jornada registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
