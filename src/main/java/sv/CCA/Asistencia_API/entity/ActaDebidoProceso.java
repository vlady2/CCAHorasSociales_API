package sv.CCA.Asistencia_API.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "actas_debido_proceso")
public class ActaDebidoProceso {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "bandera_id", nullable = false, length = 36)
    private String banderaId;

    @Column(name = "estudiante_id", nullable = false, length = 36)
    private String estudianteId;

    @Column(name = "subdirector_id", nullable = false, length = 36)
    private String subdirectorId;

    @Column(name = "estado", nullable = true)
    private String estado;

    @Column(name = "sancion_sugerida", nullable = true)
    private String sancionSugerida;

    @Column(name = "dias_sugeridos", nullable = false)
    private Integer diasSugeridos;

    @Column(name = "dias_min_permitidos", nullable = false)
    private Integer diasMinPermitidos;

    @Column(name = "dias_max_permitidos", nullable = false)
    private Integer diasMaxPermitidos;

    @Column(name = "fecha_citatorio", nullable = false)
    private LocalDateTime fechaCitatorio;

    @Column(name = "lugar_citatorio", nullable = false, length = 150)
    private String lugarCitatorio;

    @Column(name = "fecha_audiencia", nullable = false)
    private LocalDateTime fechaAudiencia;

    @Column(name = "relato_audiencia", nullable = false)
    private String relatoAudiencia;

    @Column(name = "sancion_final", nullable = true)
    private String sancionFinal;

    @Column(name = "dias_final", nullable = false)
    private Integer diasFinal;

    @Column(name = "justificacion_fuera_rango", nullable = false)
    private String justificacionFueraRango;

    @Column(name = "fecha_inicio_sancion", nullable = false)
    private LocalDate fechaInicioSancion;

    @Column(name = "acuerdos_compromisos", nullable = false)
    private String acuerdosCompromisos;

    @Column(name = "resuelto_por", nullable = false, length = 36)
    private String resueltoPor;

    @Column(name = "resuelto_en", nullable = false)
    private LocalDateTime resueltoEn;

    @Column(name = "pdf_key", nullable = false, length = 300)
    private String pdfKey;

    @Column(name = "pdf_hash", nullable = false, length = 64)
    private String pdfHash;

    @Column(name = "creado_en", nullable = false)
    private LocalDateTime creadoEn;

    @Column(name = "actualizado_en", nullable = false)
    private LocalDateTime actualizadoEn;

    public ActaDebidoProceso() {
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

    public String getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(String estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getSubdirectorId() {
        return subdirectorId;
    }

    public void setSubdirectorId(String subdirectorId) {
        this.subdirectorId = subdirectorId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSancionSugerida() {
        return sancionSugerida;
    }

    public void setSancionSugerida(String sancionSugerida) {
        this.sancionSugerida = sancionSugerida;
    }

    public Integer getDiasSugeridos() {
        return diasSugeridos;
    }

    public void setDiasSugeridos(Integer diasSugeridos) {
        this.diasSugeridos = diasSugeridos;
    }

    public Integer getDiasMinPermitidos() {
        return diasMinPermitidos;
    }

    public void setDiasMinPermitidos(Integer diasMinPermitidos) {
        this.diasMinPermitidos = diasMinPermitidos;
    }

    public Integer getDiasMaxPermitidos() {
        return diasMaxPermitidos;
    }

    public void setDiasMaxPermitidos(Integer diasMaxPermitidos) {
        this.diasMaxPermitidos = diasMaxPermitidos;
    }

    public LocalDateTime getFechaCitatorio() {
        return fechaCitatorio;
    }

    public void setFechaCitatorio(LocalDateTime fechaCitatorio) {
        this.fechaCitatorio = fechaCitatorio;
    }

    public String getLugarCitatorio() {
        return lugarCitatorio;
    }

    public void setLugarCitatorio(String lugarCitatorio) {
        this.lugarCitatorio = lugarCitatorio;
    }

    public LocalDateTime getFechaAudiencia() {
        return fechaAudiencia;
    }

    public void setFechaAudiencia(LocalDateTime fechaAudiencia) {
        this.fechaAudiencia = fechaAudiencia;
    }

    public String getRelatoAudiencia() {
        return relatoAudiencia;
    }

    public void setRelatoAudiencia(String relatoAudiencia) {
        this.relatoAudiencia = relatoAudiencia;
    }

    public String getSancionFinal() {
        return sancionFinal;
    }

    public void setSancionFinal(String sancionFinal) {
        this.sancionFinal = sancionFinal;
    }

    public Integer getDiasFinal() {
        return diasFinal;
    }

    public void setDiasFinal(Integer diasFinal) {
        this.diasFinal = diasFinal;
    }

    public String getJustificacionFueraRango() {
        return justificacionFueraRango;
    }

    public void setJustificacionFueraRango(String justificacionFueraRango) {
        this.justificacionFueraRango = justificacionFueraRango;
    }

    public LocalDate getFechaInicioSancion() {
        return fechaInicioSancion;
    }

    public void setFechaInicioSancion(LocalDate fechaInicioSancion) {
        this.fechaInicioSancion = fechaInicioSancion;
    }

    public String getAcuerdosCompromisos() {
        return acuerdosCompromisos;
    }

    public void setAcuerdosCompromisos(String acuerdosCompromisos) {
        this.acuerdosCompromisos = acuerdosCompromisos;
    }

    public String getResueltoPor() {
        return resueltoPor;
    }

    public void setResueltoPor(String resueltoPor) {
        this.resueltoPor = resueltoPor;
    }

    public LocalDateTime getResueltoEn() {
        return resueltoEn;
    }

    public void setResueltoEn(LocalDateTime resueltoEn) {
        this.resueltoEn = resueltoEn;
    }

    public String getPdfKey() {
        return pdfKey;
    }

    public void setPdfKey(String pdfKey) {
        this.pdfKey = pdfKey;
    }

    public String getPdfHash() {
        return pdfHash;
    }

    public void setPdfHash(String pdfHash) {
        this.pdfHash = pdfHash;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public LocalDateTime getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(LocalDateTime actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }
}