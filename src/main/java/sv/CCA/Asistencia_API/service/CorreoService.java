package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.Correo;
import sv.CCA.Asistencia_API.repository.CorreoRepository;

@Service
public class CorreoService {

    private final CorreoRepository repositorio;

    public CorreoService(CorreoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Correo> listar() {
        return repositorio.findAll();
    }

    public Correo buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }

    public Correo guardar(Correo registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }
}
