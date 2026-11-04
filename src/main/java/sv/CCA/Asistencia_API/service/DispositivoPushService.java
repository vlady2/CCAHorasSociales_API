package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.DispositivoPush;
import sv.CCA.Asistencia_API.repository.DispositivoPushRepository;

@Service
public class DispositivoPushService {

    private final DispositivoPushRepository repositorio;

    public DispositivoPushService(DispositivoPushRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<DispositivoPush> listar() {
        return repositorio.findAll();
    }

    public DispositivoPush buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }

    public DispositivoPush guardar(DispositivoPush registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }
}
