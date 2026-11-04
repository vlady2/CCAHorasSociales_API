package sv.CCA.Asistencia_API.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import sv.CCA.Asistencia_API.entity.FirmasActa;
import sv.CCA.Asistencia_API.service.FirmaActaService;

@RestController
@RequestMapping("/api/firmas-acta")
public class FirmaActaController {

    private final FirmaActaService servicio;

    public FirmaActaController(FirmaActaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<FirmasActa> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public FirmasActa buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }

    @PostMapping
    public FirmasActa guardar(@RequestBody FirmasActa registro) {
        return servicio.guardar(registro);
    }

    @PutMapping("/{id}")
    public FirmasActa actualizar(@PathVariable String id, @RequestBody FirmasActa registro) {
        return servicio.guardar(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        servicio.eliminar(id);
    }
}
