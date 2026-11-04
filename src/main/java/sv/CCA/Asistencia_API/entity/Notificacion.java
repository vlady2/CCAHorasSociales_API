package sv.CCA.Asistencia_API.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "notificaciones")
public class Notificacion {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "destinatario_id", nullable = false, length = 36)
    private String destinatarioId;

    @Column(name = "tipo", nullable = true)
    private String tipo;

    @Column(name = "referencia_id", nullable = false, length = 36)
    private String referenciaId;

    @Column(name = "payload", nullable = false)
    private String payload;

    @Column(name = "leida_en", nullable = false)
    private LocalDateTime leidaEn;

    @Column(name = "creado_en", nullable = false)
    private LocalDateTime creadoEn;

    public Notificacion() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(String destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getReferenciaId() {
        return referenciaId;
    }

    public void setReferenciaId(String referenciaId) {
        this.referenciaId = referenciaId;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public LocalDateTime getLeidaEn() {
        return leidaEn;
    }

    public void setLeidaEn(LocalDateTime leidaEn) {
        this.leidaEn = leidaEn;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }
}