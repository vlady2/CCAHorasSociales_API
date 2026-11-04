
package sv.CCA.Asistencia_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.CCA.Asistencia_API.entity.Sesion;

import java.util.Optional;
import java.util.UUID;

public interface SesionRepository
        extends JpaRepository<Sesion, UUID> {

    Optional<Sesion> findByRefreshTokenHash(
        String refreshTokenHash
    );

    boolean existsByRefreshTokenHash(
        String refreshTokenHash
    );
}