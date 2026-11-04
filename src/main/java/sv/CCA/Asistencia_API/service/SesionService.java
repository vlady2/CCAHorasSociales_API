package sv.CCA.Asistencia_API.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.Sesion;
import sv.CCA.Asistencia_API.repository.SesionRepository;

@Service
public class SesionService {

    private final SesionRepository repositorio;

    public SesionService(SesionRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Sesion> listar() {
        return repositorio.findAll();
    }

    public Sesion buscarPorId(String id) {
        return repositorio.findById(UUID.fromString(id)).orElse(null);
    }

    public Sesion guardar(Sesion registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(UUID.fromString(id));
    }
}
