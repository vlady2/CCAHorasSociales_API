package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.CatalogoFalta;
import sv.CCA.Asistencia_API.service.CatalogoFaltaService;

@RestController
@RequestMapping("/api/catalogo-faltas")
public class CatalogoFaltaController {

    private final CatalogoFaltaService servicio;

    public CatalogoFaltaController(CatalogoFaltaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<CatalogoFalta> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public CatalogoFalta buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public CatalogoFalta guardar(@RequestBody CatalogoFalta registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public CatalogoFalta actualizar(@PathVariable String id, @RequestBody CatalogoFalta registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
