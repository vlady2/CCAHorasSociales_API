package sv.CCA.Asistencia_API.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sv.CCA.Asistencia_API.entity.BitacoraAuditoria;
import sv.CCA.Asistencia_API.repository.BitacoraAuditoriaRepository;

@Service
public class BitacoraAuditoriaService {

    private final BitacoraAuditoriaRepository repositorio;

    public BitacoraAuditoriaService(BitacoraAuditoriaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<BitacoraAuditoria> listar() {
        return repositorio.findAll();
    }

    public BitacoraAuditoria buscarPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public BitacoraAuditoria guardar(BitacoraAuditoria registro) {
        return repositorio.save(registro);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}
