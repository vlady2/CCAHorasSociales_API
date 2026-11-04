package sv.CCA.Asistencia_API.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "correos")
public class Correo {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "destinatario", nullable = false, length = 120)
    private String destinatario;

    @Column(name = "plantilla", nullable = true)
    private String plantilla;

    @Column(name = "variables", nullable = false)
    private String variables;

    @Column(name = "referencia_tipo", nullable = false, length = 20)
    private String referenciaTipo;

    @Column(name = "referencia_id", nullable = false, length = 36)
    private String referenciaId;

    @Column(name = "estado", nullable = true)
    private String estado;

    @Column(name = "intentos", nullable = false)
    private Integer intentos;

    @Column(name = "ultimo_error", nullable = false)
    private String ultimoError;

    @Column(name = "enviado_en", nullable = false)
    private LocalDateTime enviadoEn;

    @Column(name = "creado_en", nullable = false)
    private LocalDateTime creadoEn;

    public Correo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(String plantilla) {
        this.plantilla = plantilla;
    }

    public String getVariables() {
        return variables;
    }

    public void setVariables(String variables) {
        this.variables = variables;
    }

    public String getReferenciaTipo() {
        return referenciaTipo;
    }

    public void setReferenciaTipo(String referenciaTipo) {
        this.referenciaTipo = referenciaTipo;
    }

    public String getReferenciaId() {
        return referenciaId;
    }

    public void setReferenciaId(String referenciaId) {
        this.referenciaId = referenciaId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIntentos() {
        return intentos;
    }

    public void setIntentos(Integer intentos) {
        this.intentos = intentos;
    }

    public String getUltimoError() {
        return ultimoError;
    }

    public void setUltimoError(String ultimoError) {
        this.ultimoError = ultimoError;
    }

    public LocalDateTime getEnviadoEn() {
        return enviadoEn;
    }

    public void setEnviadoEn(LocalDateTime enviadoEn) {
        this.enviadoEn = enviadoEn;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }
}