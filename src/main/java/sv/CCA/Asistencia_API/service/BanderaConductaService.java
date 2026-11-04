package sv.CCA.Asistencia_API.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.BanderaConducta;
import sv.CCA.Asistencia_API.repository.BanderaConductaRepository;

@Service
public class BanderaConductaService {

    private final BanderaConductaRepository repositorio;

    public BanderaConductaService(BanderaConductaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<BanderaConducta> listar() {
        return repositorio.findAll();
    }

    public BanderaConducta buscarPorId(String id) {
        return repositorio.findById(UUID.fromString(id)).orElse(null);
    }

    public BanderaConducta guardar(BanderaConducta registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(UUID.fromString(id));
    }
}
