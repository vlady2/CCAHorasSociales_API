package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.Jornada;
import sv.CCA.Asistencia_API.repository.JornadaRepository;

@Service
public class JornadaService {

    private final JornadaRepository repositorio;

    public JornadaService(JornadaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Jornada> listar() {
        return repositorio.findAll();
    }

    public Jornada buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }

    public Jornada guardar(Jornada registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }
}
