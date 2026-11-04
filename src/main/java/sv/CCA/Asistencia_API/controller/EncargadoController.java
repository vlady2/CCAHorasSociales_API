package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.Encargado;
import sv.CCA.Asistencia_API.service.EncargadoService;

@RestController
@RequestMapping("/api/encargados")
public class EncargadoController {

    private final EncargadoService servicio;

    public EncargadoController(EncargadoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Encargado> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Encargado buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public Encargado guardar(@RequestBody Encargado registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public Encargado actualizar(@PathVariable String id, @RequestBody Encargado registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
