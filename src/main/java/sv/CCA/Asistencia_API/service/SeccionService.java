package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.Seccion;
import sv.CCA.Asistencia_API.repository.SeccionRepository;

@Service
public class SeccionService {

    private final SeccionRepository repositorio;

    public SeccionService(SeccionRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Seccion> listar() {
        return repositorio.findAll();
    }

    public Seccion buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }

    public Seccion guardar(Seccion registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }
}
