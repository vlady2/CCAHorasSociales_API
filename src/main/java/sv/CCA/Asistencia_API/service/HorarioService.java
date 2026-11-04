package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.Horario;
import sv.CCA.Asistencia_API.repository.HorarioRepository;

@Service
public class HorarioService {

    private final HorarioRepository repositorio;

    public HorarioService(HorarioRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Horario> listar() {
        return repositorio.findAll();
    }

    public Horario buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }

    public Horario guardar(Horario registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }
}
