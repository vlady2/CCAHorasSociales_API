package sv.CCA.Asistencia_API.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import sv.CCA.Asistencia_API.entity.EstudianteEncargado;

public interface EstudianteEncargadoRepository extends JpaRepository<EstudianteEncargado, String> {
}
