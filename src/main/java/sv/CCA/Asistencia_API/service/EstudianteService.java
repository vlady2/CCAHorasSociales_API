package sv.CCA.Asistencia_API.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.Estudiante;
import sv.CCA.Asistencia_API.repository.EstudianteRepository;

@Service
public class EstudianteService {

    private final EstudianteRepository repositorio;

    public EstudianteService(EstudianteRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Estudiante> listar() {
        return repositorio.findAll();
    }

    public Estudiante buscarPorId(String id) {
        return repositorio.findById(UUID.fromString(id)).orElse(null);
    }

    public Estudiante guardar(Estudiante registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(UUID.fromString(id));
    }
}
