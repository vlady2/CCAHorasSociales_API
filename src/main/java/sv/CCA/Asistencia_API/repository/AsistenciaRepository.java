package sv.CCA.Asistencia_API.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import sv.CCA.Asistencia_API.entity.Asistencia;

public interface AsistenciaRepository extends JpaRepository<Asistencia, UUID> {
    Optional<Asistencia> findByClientUuid(String clientUuid);
    boolean existsByEstudianteIdAndFechaAndMomentoAndHorarioId(String estudianteId, java.time.LocalDate fecha, String momento, String horarioId);
    boolean existsByEstudianteIdAndFechaAndMomentoAndEstadoIn(String estudianteId, java.time.LocalDate fecha, String momento, java.util.Collection<String> estados);
}
