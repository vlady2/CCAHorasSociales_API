package sv.CCA.Asistencia_API.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "evidencias")
public class Evidencia {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "bandera_id", nullable = false, length = 36)
    private String banderaId;

    @Column(name = "storage_key", nullable = false, length = 300)
    private String storageKey;

    @Column(name = "tipo_mime", nullable = false, length = 60)
    private String tipoMime;

    @Column(name = "tamano_bytes", nullable = false)
    private Integer tamanoBytes;

    @Column(name = "hash_sha256", nullable = false, length = 64)
    private String hashSha256;

    @Column(name = "subido_por", nullable = false, length = 36)
    private String subidoPor;

    @Column(name = "creado_en", nullable = false)
    private LocalDateTime creadoEn;

    public Evidencia() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBanderaId() {
        return banderaId;
    }

    public void setBanderaId(String banderaId) {
        this.banderaId = banderaId;
    }

    public String getStorageKey() {
        return storageKey;
    }

    public void setStorageKey(String storageKey) {
        this.storageKey = storageKey;
    }

    public String getTipoMime() {
        return tipoMime;
    }

    public void setTipoMime(String tipoMime) {
        this.tipoMime = tipoMime;
    }

    public Integer getTamanoBytes() {
        return tamanoBytes;
    }

    public void setTamanoBytes(Integer tamanoBytes) {
        this.tamanoBytes = tamanoBytes;
    }

    public String getHashSha256() {
        return hashSha256;
    }

    public void setHashSha256(String hashSha256) {
        this.hashSha256 = hashSha256;
    }

    public String getSubidoPor() {
        return subidoPor;
    }

    public void setSubidoPor(String subidoPor) {
        this.subidoPor = subidoPor;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }
}