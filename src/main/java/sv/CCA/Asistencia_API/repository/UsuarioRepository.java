package sv.CCA.Asistencia_API.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.CCA.Asistencia_API.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    // Buscar un usuario por su correo institucional
    Optional<Usuario> findByCorreoInstitucional(String correoInstitucional);

    // Verificar si ya existe un correo institucional
    boolean existsByCorreoInstitucional(String correoInstitucional);
}
