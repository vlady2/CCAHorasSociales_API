package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.Notificacion;
import sv.CCA.Asistencia_API.service.NotificacionService;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    private final NotificacionService servicio;

    public NotificacionController(NotificacionService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Notificacion> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Notificacion buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public Notificacion guardar(@RequestBody Notificacion registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public Notificacion actualizar(@PathVariable String id, @RequestBody Notificacion registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
