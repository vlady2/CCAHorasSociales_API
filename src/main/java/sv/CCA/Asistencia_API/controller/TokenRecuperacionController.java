package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.TokenRecuperacion;
import sv.CCA.Asistencia_API.service.TokenRecuperacionService;

@RestController
@RequestMapping("/api/tokens-recuperacion")
public class TokenRecuperacionController {

    private final TokenRecuperacionService servicio;

    public TokenRecuperacionController(TokenRecuperacionService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<TokenRecuperacion> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public TokenRecuperacion buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public TokenRecuperacion guardar(@RequestBody TokenRecuperacion registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public TokenRecuperacion actualizar(@PathVariable String id, @RequestBody TokenRecuperacion registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
