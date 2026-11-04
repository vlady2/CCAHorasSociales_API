package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.FirmasActa;
import sv.CCA.Asistencia_API.repository.FirmaActaRepository;

@Service
public class FirmaActaService {

    private final FirmaActaRepository repositorio;

    public FirmaActaService(FirmaActaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<FirmasActa> listar() {
        return repositorio.findAll();
    }

    public FirmasActa buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }

    public FirmasActa guardar(FirmasActa registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }
}
