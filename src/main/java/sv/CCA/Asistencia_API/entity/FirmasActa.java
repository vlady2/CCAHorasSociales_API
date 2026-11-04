package sv.CCA.Asistencia_API.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "firmas_acta")
public class FirmasActa {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "acta_id", nullable = false, length = 36)
    private String actaId;

    @Column(name = "rol_firmante", nullable = true)
    private String rolFirmante;

    @Column(name = "nombre_firmante", nullable = false, length = 150)
    private String nombreFirmante;

    @Column(name = "usuario_id", nullable = false, length = 36)
    private String usuarioId;

    @Column(name = "encargado_id", nullable = false, length = 36)
    private String encargadoId;

    @Column(name = "imagen_firma_key", nullable = false, length = 300)
    private String imagenFirmaKey;

    @Column(name = "hash_contenido_acta", nullable = false, length = 64)
    private String hashContenidoActa;

    @Column(name = "firmado_en", nullable = false)
    private LocalDateTime firmadoEn;

    public FirmasActa() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActaId() {
        return actaId;
    }

    public void setActaId(String actaId) {
        this.actaId = actaId;
    }

    public String getRolFirmante() {
        return rolFirmante;
    }

    public void setRolFirmante(String rolFirmante) {
        this.rolFirmante = rolFirmante;
    }

    public String getNombreFirmante() {
        return nombreFirmante;
    }

    public void setNombreFirmante(String nombreFirmante) {
        this.nombreFirmante = nombreFirmante;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getEncargadoId() {
        return encargadoId;
    }

    public void setEncargadoId(String encargadoId) {
        this.encargadoId = encargadoId;
    }

    public String getImagenFirmaKey() {
        return imagenFirmaKey;
    }

    public void setImagenFirmaKey(String imagenFirmaKey) {
        this.imagenFirmaKey = imagenFirmaKey;
    }

    public String getHashContenidoActa() {
        return hashContenidoActa;
    }

    public void setHashContenidoActa(String hashContenidoActa) {
        this.hashContenidoActa = hashContenidoActa;
    }

    public LocalDateTime getFirmadoEn() {
        return firmadoEn;
    }

    public void setFirmadoEn(LocalDateTime firmadoEn) {
        this.firmadoEn = firmadoEn;
    }
}