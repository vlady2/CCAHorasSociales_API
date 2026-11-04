package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.ActaDebidoProceso;
import sv.CCA.Asistencia_API.service.ActaDebidoProcesoService;

@RestController
@RequestMapping("/api/actas-debido-proceso")
public class ActaDebidoProcesoController {

    private final ActaDebidoProcesoService servicio;

    public ActaDebidoProcesoController(ActaDebidoProcesoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<ActaDebidoProceso> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public ActaDebidoProceso buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public ActaDebidoProceso guardar(@RequestBody ActaDebidoProceso registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public ActaDebidoProceso actualizar(@PathVariable String id, @RequestBody ActaDebidoProceso registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
