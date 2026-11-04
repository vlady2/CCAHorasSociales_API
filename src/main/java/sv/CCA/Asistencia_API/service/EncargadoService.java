package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.Encargado;
import sv.CCA.Asistencia_API.repository.EncargadoRepository;

@Service
public class EncargadoService {

    private final EncargadoRepository repositorio;

    public EncargadoService(EncargadoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Encargado> listar() {
        return repositorio.findAll();
    }

    public Encargado buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }

    public Encargado guardar(Encargado registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }
}
