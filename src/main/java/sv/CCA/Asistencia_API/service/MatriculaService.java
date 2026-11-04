package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.Matricula;
import sv.CCA.Asistencia_API.repository.MatriculaRepository;

@Service
public class MatriculaService {

    private final MatriculaRepository repositorio;

    public MatriculaService(MatriculaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Matricula> listar() {
        return repositorio.findAll();
    }

    public Matricula buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }

    public Matricula guardar(Matricula registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }
}
