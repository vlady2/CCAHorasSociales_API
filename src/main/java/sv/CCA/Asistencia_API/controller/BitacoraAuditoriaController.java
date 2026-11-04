package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.BitacoraAuditoria;
import sv.CCA.Asistencia_API.service.BitacoraAuditoriaService;

@RestController
@RequestMapping("/api/bitacora-auditoria")
public class BitacoraAuditoriaController {

    private final BitacoraAuditoriaService servicio;

    public BitacoraAuditoriaController(BitacoraAuditoriaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<BitacoraAuditoria> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public BitacoraAuditoria buscarPorId(@PathVariable Long id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public BitacoraAuditoria guardar(@RequestBody BitacoraAuditoria registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public BitacoraAuditoria actualizar(@PathVariable Long id, @RequestBody BitacoraAuditoria registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}
