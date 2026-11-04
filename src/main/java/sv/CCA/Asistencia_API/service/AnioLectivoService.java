package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.AnioLectivo;
import sv.CCA.Asistencia_API.repository.AnioLectivoRepository;

@Service
public class AnioLectivoService {

    private final AnioLectivoRepository repositorio;

    public AnioLectivoService(AnioLectivoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<AnioLectivo> listar() {
        return repositorio.findAll();
    }

    public AnioLectivo buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }

    public AnioLectivo guardar(AnioLectivo registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }
}
