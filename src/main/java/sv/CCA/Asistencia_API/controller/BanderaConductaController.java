package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.BanderaConducta;
import sv.CCA.Asistencia_API.service.BanderaConductaService;

@RestController
@RequestMapping("/api/banderas-conducta")
public class BanderaConductaController {

    private final BanderaConductaService servicio;

    public BanderaConductaController(BanderaConductaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<BanderaConducta> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public BanderaConducta buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public BanderaConducta guardar(@RequestBody BanderaConducta registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public BanderaConducta actualizar(@PathVariable String id, @RequestBody BanderaConducta registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
