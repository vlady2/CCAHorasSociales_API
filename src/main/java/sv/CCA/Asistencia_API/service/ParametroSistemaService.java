package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.ParametroSistema;
import sv.CCA.Asistencia_API.repository.ParametroSistemaRepository;

@Service
public class ParametroSistemaService {

    private final ParametroSistemaRepository repositorio;

    public ParametroSistemaService(ParametroSistemaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<ParametroSistema> listar() {
        return repositorio.findAll();
    }

    public ParametroSistema buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }

    public ParametroSistema guardar(ParametroSistema registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }
}
