package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.AsignacionSubdireccion;
import sv.CCA.Asistencia_API.repository.AsignacionSubdireccionRepository;

@Service
public class AsignacionSubdireccionService {

    private final AsignacionSubdireccionRepository repositorio;

    public AsignacionSubdireccionService(AsignacionSubdireccionRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<AsignacionSubdireccion> listar() {
        return repositorio.findAll();
    }

    public AsignacionSubdireccion buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }

    public AsignacionSubdireccion guardar(AsignacionSubdireccion registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }
}
