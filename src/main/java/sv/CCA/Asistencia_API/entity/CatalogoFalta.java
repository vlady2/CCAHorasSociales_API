package sv.CCA.Asistencia_API.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "catalogo_faltas")
public class CatalogoFalta {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "codigo", nullable = false, length = 20)
    private String codigo;

    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;

    @Column(name = "tipo_bandera", nullable = false)
    private String tipoBandera;

    @Column(name = "referencia_manual", nullable = false, length = 60)
    private String referenciaManual;

    @Column(name = "sancion_sugerida", nullable = true)
    private String sancionSugerida;

    @Column(name = "dias_min", nullable = false)
    private Integer diasMin;

    @Column(name = "dias_max", nullable = false)
    private Integer diasMax;

    @Column(name = "dias_sugeridos", nullable = false)
    private Integer diasSugeridos;

    @Column(name = "regla_automatica", nullable = false)
    private String reglaAutomatica;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @Column(name = "actualizado_por", nullable = false, length = 36)
    private String actualizadoPor;

    @Column(name = "actualizado_en", nullable = false)
    private LocalDateTime actualizadoEn;

    public CatalogoFalta() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoBandera() {
        return tipoBandera;
    }

    public void setTipoBandera(String tipoBandera) {
        this.tipoBandera = tipoBandera;
    }

    public String getReferenciaManual() {
        return referenciaManual;
    }

    public void setReferenciaManual(String referenciaManual) {
        this.referenciaManual = referenciaManual;
    }

    public String getSancionSugerida() {
        return sancionSugerida;
    }

    public void setSancionSugerida(String sancionSugerida) {
        this.sancionSugerida = sancionSugerida;
    }

    public Integer getDiasMin() {
        return diasMin;
    }

    public void setDiasMin(Integer diasMin) {
        this.diasMin = diasMin;
    }

    public Integer getDiasMax() {
        return diasMax;
    }

    public void setDiasMax(Integer diasMax) {
        this.diasMax = diasMax;
    }

    public Integer getDiasSugeridos() {
        return diasSugeridos;
    }

    public void setDiasSugeridos(Integer diasSugeridos) {
        this.diasSugeridos = diasSugeridos;
    }

    public String getReglaAutomatica() {
        return reglaAutomatica;
    }

    public void setReglaAutomatica(String reglaAutomatica) {
        this.reglaAutomatica = reglaAutomatica;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getActualizadoPor() {
        return actualizadoPor;
    }

    public void setActualizadoPor(String actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }

    public LocalDateTime getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(LocalDateTime actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }
}