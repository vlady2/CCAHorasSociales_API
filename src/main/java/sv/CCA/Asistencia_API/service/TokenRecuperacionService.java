package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.TokenRecuperacion;
import sv.CCA.Asistencia_API.repository.TokenRecuperacionRepository;

@Service
public class TokenRecuperacionService {

    private final TokenRecuperacionRepository repositorio;

    public TokenRecuperacionService(TokenRecuperacionRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<TokenRecuperacion> listar() {
        return repositorio.findAll();
    }

    public TokenRecuperacion buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }

    public TokenRecuperacion guardar(TokenRecuperacion registro) {
        return repositorio.save(registro);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }
}
