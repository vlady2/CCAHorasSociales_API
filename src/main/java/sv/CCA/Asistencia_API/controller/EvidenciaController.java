package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.Evidencia;
import sv.CCA.Asistencia_API.service.EvidenciaService;

@RestController
@RequestMapping("/api/evidencias")
public class EvidenciaController {

    private final EvidenciaService servicio;

    public EvidenciaController(EvidenciaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Evidencia> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Evidencia buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public Evidencia guardar(@RequestBody Evidencia registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public Evidencia actualizar(@PathVariable String id, @RequestBody Evidencia registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
