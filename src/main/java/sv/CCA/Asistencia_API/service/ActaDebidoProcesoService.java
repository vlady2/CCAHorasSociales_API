package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.ActaDebidoProceso;
import sv.CCA.Asistencia_API.repository.ActaDebidoProcesoRepository;

@Service
public class ActaDebidoProcesoService {

    private final ActaDebidoProcesoRepository repositorio;

    public ActaDebidoProcesoService(ActaDebidoProcesoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<ActaDebidoProceso> listar() {
        return repositorio.findAll();
    }

    public ActaDebidoProceso buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }

    public ActaDebidoProceso guardar(ActaDebidoProceso registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }
}
