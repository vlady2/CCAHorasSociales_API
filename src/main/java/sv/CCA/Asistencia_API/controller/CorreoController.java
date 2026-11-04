package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.Correo;
import sv.CCA.Asistencia_API.service.CorreoService;

@RestController
@RequestMapping("/api/correos")
public class CorreoController {

    private final CorreoService servicio;

    public CorreoController(CorreoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Correo> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Correo buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public Correo guardar(@RequestBody Correo registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public Correo actualizar(@PathVariable String id, @RequestBody Correo registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
