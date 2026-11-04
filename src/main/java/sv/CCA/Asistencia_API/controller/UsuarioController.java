package sv.CCA.Asistencia_API.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import sv.CCA.Asistencia_API.entity.Usuario;
import sv.CCA.Asistencia_API.service.UsuarioService;
import sv.CCA.Asistencia_API.dto.RegistroUsuarioRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // DTO: datos recibidos para registrar un usuario
    //public record RegistroUsuarioRequest(
    //        String nombreCompleto,
    //        String correoInstitucional,
    //        String password,
    //        String rol
    //) {}

    // DTO: respuesta segura, sin contraseña ni secreto MFA
    public record UsuarioResponse(
            UUID id,
            String nombreCompleto,
            String correoInstitucional,
            boolean debeCambiarPassword,
            String rol,
            boolean mfaHabilitado,
            boolean activo
    ) {}

    // POST: registrar usuario
    @PostMapping
    public ResponseEntity<UsuarioResponse> registrarUsuario(
        @Valid @RequestBody RegistroUsuarioRequest solicitud) {

        Usuario usuario = usuarioService.registrarUsuario(
            solicitud.nombreCompleto(),
            solicitud.correoInstitucional(),
            solicitud.password(),
            solicitud.rol()
        );

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(convertirRespuesta(usuario));
    }

    // GET: consultar usuario por UUID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(
            @PathVariable UUID id) {

        Usuario usuario = usuarioService.buscarPorId(id);

        return ResponseEntity.ok(convertirRespuesta(usuario));
    }

    @GetMapping
    public ResponseEntity<?> listarUsuarios() {
        return ResponseEntity.ok(
            usuarioService.listarUsuarios()
                .stream()
                .map(this::convertirRespuesta)
                .toList()
        );
    }

    // Convierte la entidad a una respuesta que no expone datos sensibles
    private UsuarioResponse convertirRespuesta(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNombreCompleto(),
                usuario.getCorreoInstitucional(),
                Boolean.TRUE.equals(usuario.getDebeCambiarPassword()),
                usuario.getRol(),
                Boolean.TRUE.equals(usuario.getMfaHabilitado()),
                Boolean.TRUE.equals(usuario.getActivo())
        );
    }
}
