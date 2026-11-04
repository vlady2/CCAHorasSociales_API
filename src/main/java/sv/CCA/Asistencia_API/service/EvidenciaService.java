package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.Evidencia;
import sv.CCA.Asistencia_API.repository.EvidenciaRepository;

@Service
public class EvidenciaService {

    private final EvidenciaRepository repositorio;

    public EvidenciaService(EvidenciaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Evidencia> listar() {
        return repositorio.findAll();
    }

    public Evidencia buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }

    public Evidencia guardar(Evidencia registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }
}
