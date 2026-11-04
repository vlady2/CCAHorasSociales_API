package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.DispositivoPush;
import sv.CCA.Asistencia_API.service.DispositivoPushService;

@RestController
@RequestMapping("/api/dispositivos-push")
public class DispositivoPushController {

    private final DispositivoPushService servicio;

    public DispositivoPushController(DispositivoPushService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<DispositivoPush> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public DispositivoPush buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public DispositivoPush guardar(@RequestBody DispositivoPush registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public DispositivoPush actualizar(@PathVariable String id, @RequestBody DispositivoPush registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
