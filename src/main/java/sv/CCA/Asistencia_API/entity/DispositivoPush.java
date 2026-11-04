package sv.CCA.Asistencia_API.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "dispositivos_push")
public class DispositivoPush {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "usuario_id", nullable = false, length = 36)
    private String usuarioId;

    @Column(name = "token_push", nullable = false, length = 255)
    private String tokenPush;

    @Column(name = "plataforma", nullable = false)
    private String plataforma;

    @Column(name = "actualizado_en", nullable = false)
    private LocalDateTime actualizadoEn;

    public DispositivoPush() {
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

    public String getTokenPush() {
        return tokenPush;
    }

    public void setTokenPush(String tokenPush) {
        this.tokenPush = tokenPush;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public LocalDateTime getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(LocalDateTime actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }
}