package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.EstudianteEncargado;
import sv.CCA.Asistencia_API.repository.EstudianteEncargadoRepository;

@Service
public class EstudianteEncargadoService {

    private final EstudianteEncargadoRepository repositorio;

    public EstudianteEncargadoService(EstudianteEncargadoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<EstudianteEncargado> listar() {
        return repositorio.findAll();
    }

    public EstudianteEncargado buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }

    public EstudianteEncargado guardar(EstudianteEncargado registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }
}
