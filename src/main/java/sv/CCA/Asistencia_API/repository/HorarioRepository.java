package sv.CCA.Asistencia_API.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import sv.CCA.Asistencia_API.entity.Horario;

public interface HorarioRepository extends JpaRepository<Horario, String> {
    List<Horario> findByDocenteId(String docenteId);
    List<Horario> findByDocenteIdAndDiaSemana(String docenteId, Integer diaSemana);
    List<Horario> findBySeccionIdAndDiaSemana(String seccionId, Integer diaSemana);
    boolean existsByIdAndDocenteId(String id, String docenteId);
}
