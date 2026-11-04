package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.ParametroSistema;
import sv.CCA.Asistencia_API.service.ParametroSistemaService;

@RestController
@RequestMapping("/api/parametros-sistema")
public class ParametroSistemaController {

    private final ParametroSistemaService servicio;

    public ParametroSistemaController(ParametroSistemaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<ParametroSistema> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public ParametroSistema buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public ParametroSistema guardar(@RequestBody ParametroSistema registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public ParametroSistema actualizar(@PathVariable String id, @RequestBody ParametroSistema registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
