package sv.CCA.Asistencia_API.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import sv.CCA.Asistencia_API.entity.BanderaConducta;

public interface BanderaConductaRepository extends JpaRepository<BanderaConducta, UUID> {
}
