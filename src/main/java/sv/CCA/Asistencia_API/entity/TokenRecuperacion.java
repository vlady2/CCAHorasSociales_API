package sv.CCA.Asistencia_API.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "tokens_recuperacion")
public class TokenRecuperacion {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "usuario_id", nullable = false, length = 36)
    private String usuarioId;

    @Column(name = "token_hash", nullable = false, length = 64)
    private String tokenHash;

    @Column(name = "expira_en", nullable = false)
    private LocalDateTime expiraEn;

    @Column(name = "usado_en", nullable = false)
    private LocalDateTime usadoEn;

    public TokenRecuperacion() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getTokenHash() {
        return tokenHash;
    }

    public void setTokenHash(String tokenHash) {
        this.tokenHash = tokenHash;
    }

    public LocalDateTime getExpiraEn() {
        return expiraEn;
    }

    public void setExpiraEn(LocalDateTime expiraEn) {
        this.expiraEn = expiraEn;
    }

    public LocalDateTime getUsadoEn() {
        return usadoEn;
    }

    public void setUsadoEn(LocalDateTime usadoEn) {
        this.usadoEn = usadoEn;
    }
}