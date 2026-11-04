package sv.CCA.Asistencia_API.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import sv.CCA.Asistencia_API.entity.Encargado;

public interface EncargadoRepository extends JpaRepository<Encargado, String> {
}
