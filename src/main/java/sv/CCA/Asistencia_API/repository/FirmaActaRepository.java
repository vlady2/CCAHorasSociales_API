package sv.CCA.Asistencia_API.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import sv.CCA.Asistencia_API.entity.FirmasActa;

public interface FirmaActaRepository extends JpaRepository<FirmasActa, String> {
}
