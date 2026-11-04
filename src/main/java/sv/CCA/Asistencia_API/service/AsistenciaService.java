package sv.CCA.Asistencia_API.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.Asistencia;
import sv.CCA.Asistencia_API.repository.AsistenciaRepository;

@Service
public class AsistenciaService {

    private final AsistenciaRepository repositorio;

    public AsistenciaService(AsistenciaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Asistencia> listar() {
        return repositorio.findAll();
    }

    public Asistencia buscarPorId(String id) {
        return repositorio.findById(UUID.fromString(id)).orElse(null);
    }

    public Asistencia guardar(Asistencia registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(UUID.fromString(id));
    }
}
