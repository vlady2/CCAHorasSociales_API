
package sv.CCA.Asistencia_API.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
    name = "sesiones",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_sesiones_refresh_hash",
            columnNames = "refresh_token_hash"
        )
    },
    indexes = {
        @Index(
            name = "idx_sesiones_usuario",
            columnList = "usuario_id"
        )
    }
)
public class Sesion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "refresh_token_hash",
            nullable = false, length = 64)
    private String refreshTokenHash;

    @Column(name = "dispositivo", length = 120)
    private String dispositivo;

    @Column(name = "expira_en", nullable = false)
    private LocalDateTime expiraEn;

    @Column(name = "revocada_en")
    private LocalDateTime revocadaEn;

    public Sesion() {
    }

    public UUID getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getRefreshTokenHash() {
        return refreshTokenHash;
    }

    public void setRefreshTokenHash(String refreshTokenHash) {
        this.refreshTokenHash = refreshTokenHash;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public LocalDateTime getExpiraEn() {
        return expiraEn;
    }

    public void setExpiraEn(LocalDateTime expiraEn) {
        this.expiraEn = expiraEn;
    }

    public LocalDateTime getRevocadaEn() {
        return revocadaEn;
    }

    public void setRevocadaEn(LocalDateTime revocadaEn) {
        this.revocadaEn = revocadaEn;
    }
}