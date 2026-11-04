package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.Notificacion;
import sv.CCA.Asistencia_API.repository.NotificacionRepository;

@Service
public class NotificacionService {

    private final NotificacionRepository repositorio;

    public NotificacionService(NotificacionRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Notificacion> listar() {
        return repositorio.findAll();
    }

    public Notificacion buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }

    public Notificacion guardar(Notificacion registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }
}
