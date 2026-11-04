package sv.CCA.Asistencia_API.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import sv.CCA.Asistencia_API.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, String> {
    List<Matricula> findBySeccionIdAndEstado(String seccionId, String estado);
}
