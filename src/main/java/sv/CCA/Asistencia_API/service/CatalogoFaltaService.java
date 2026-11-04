package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.CatalogoFalta;
import sv.CCA.Asistencia_API.repository.CatalogoFaltaRepository;

@Service
public class CatalogoFaltaService {

    private final CatalogoFaltaRepository repositorio;

    public CatalogoFaltaService(CatalogoFaltaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<CatalogoFalta> listar() {
        return repositorio.findAll();
    }

    public CatalogoFalta buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }

    public CatalogoFalta guardar(CatalogoFalta registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }
}
