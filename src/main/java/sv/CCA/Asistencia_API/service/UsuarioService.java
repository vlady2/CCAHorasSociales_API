package sv.CCA.Asistencia_API.service;

import java.util.Locale;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.CCA.Asistencia_API.entity.Usuario;
import sv.CCA.Asistencia_API.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional(readOnly = true)
           public java.util.List<Usuario> listarUsuarios() {
                return usuarioRepository.findAll();
        }
    // Registrar un usuario nuevo
    @Transactional
    public Usuario registrarUsuario(
            String nombreCompleto,
            String correoInstitucional,
            String password,
            String rol) {

        if (nombreCompleto == null || nombreCompleto.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre completo es obligatorio.");
        }

        if (correoInstitucional == null
                || correoInstitucional.isBlank()) {
            throw new IllegalArgumentException(
                    "El correo institucional es obligatorio.");
        }

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException(
                    "La contraseña es obligatoria.");
        }

        if (rol == null || rol.isBlank()) {
            throw new IllegalArgumentException(
                    "El rol es obligatorio.");
        }

        String correo = correoInstitucional.trim()
                .toLowerCase(Locale.ROOT);

        if (usuarioRepository.existsByCorreoInstitucional(correo)) {
            throw new IllegalArgumentException(
                    "El correo institucional ya está registrado.");
        }

        Usuario usuario = new Usuario();

        usuario.setNombreCompleto(nombreCompleto.trim());
        usuario.setCorreoInstitucional(correo);

        // Guarda el hash, nunca la contraseña original.
        usuario.setPasswordHash(passwordEncoder.encode(password));

        // La cuenta nueva debe cambiar su contraseña.
        usuario.setDebeCambiarPassword(true);

        usuario.setRol(rol.trim());

        // Valores iniciales de seguridad.
        usuario.setMfaHabilitado(false);
        usuario.setIntentosFallidos((short) 0);
        usuario.setActivo(true);

        return usuarioRepository.save(usuario);
    }

    // Consultar usuario por correo institucional
    @Transactional(readOnly = true)
    public Usuario buscarPorCorreo(String correoInstitucional) {
        if (correoInstitucional == null
                || correoInstitucional.isBlank()) {
            throw new IllegalArgumentException(
                    "El correo institucional es obligatorio.");
        }

        String correo = correoInstitucional.trim()
                .toLowerCase(Locale.ROOT);

        return usuarioRepository
                .findByCorreoInstitucional(correo)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No se encontró el usuario."));
    }

    // Consultar usuario por UUID
    @Transactional(readOnly = true)
    public Usuario buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException(
                    "El ID del usuario es obligatorio.");
        }

        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No se encontró el usuario."));
    }

    // Verificar si un correo ya existe
    @Transactional(readOnly = true)
    public boolean existeCorreo(String correoInstitucional) {
        if (correoInstitucional == null
                || correoInstitucional.isBlank()) {
            return false;
        }

        String correo = correoInstitucional.trim()
                .toLowerCase(Locale.ROOT);

        return usuarioRepository
                .existsByCorreoInstitucional(correo);
    }
}
