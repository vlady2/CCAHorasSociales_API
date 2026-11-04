package sv.CCA.Asistencia_API.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "banderas_conducta")
public class BanderaConducta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "estudiante_id", nullable = false, length = 36)
    private String estudianteId;

    @Column(name = "seccion_id", nullable = false, length = 36)
    private String seccionId;

    @Column(name = "anio_lectivo_id", nullable = false, length = 36)
    private String aniolectivoId;

    @Column(name = "catalogo_falta_id", nullable = false, length = 36)
    private String catalogofaltaid;

    @Column(name = "tipo_original", nullable = false)
    private String tipoOriginal;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "origen", nullable = false)
    private String origen;

    @Column(name = "numero_amarilla", nullable = false)
    private int numeroAmarilla;

    @Column(name = "medida_aplicada", nullable = false)
    private String medidaAplicada;

    @Column(name = "horario_id", nullable = false, length = 36)
    private String horarioId;

    @Column(name = "lugar", nullable = false, length = 100)
    private String lugar;

    @Column(name = "fecha_hecho", nullable = false, updatable = false)
    private LocalDateTime fechaHecho;

    @Column(name = "descripcion_hechos", nullable = false)
    private String descripcionHechos;

    @Column(name = "version_estudiante", nullable = false)
    private String versionEstudiante;
    
    @Column(name = "estado_version", nullable = false)
    private String estadoVersion;

    @Column(name = "anulada", nullable = false)
    private Boolean anulada = true;

    @Column(name = "motivo_anulacion", nullable = false)
    private String motivoAnulacion;

    @Column(name = "anulada_por", nullable = false, length = 36)
    private String anuladaPor;

    @Column(name = "reportado_por", nullable = false, length = 36)
    private String reportadoPor;

    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    public BanderaConducta() {
    }

    @PrePersist
    protected void alCrear() {
        LocalDateTime ahora = LocalDateTime.now();

        if (creadoEn == null) {
            creadoEn = ahora;
        }

    }

    // Getters y setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(String pEstudianteId) {
        this.estudianteId = pEstudianteId;
    }

    public String getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(String pSeccionId) {
        this.seccionId = pSeccionId;
    }

    public String getAnioLectivoId() {
        return aniolectivoId;
    }

    public void setAnioLectivoId(String pAnioLectivoId) {
        this.aniolectivoId = pAnioLectivoId;
    }

    public String getCatalogoFaltaId() {
        return catalogofaltaid;
    }

    public void setCatalogoFaltaId(String pCatalogoFaltaId) {
        this.catalogofaltaid = pCatalogoFaltaId;
    }

    public String getTipoOriginal() {
        return tipoOriginal;
    }

    public void setTipoOriginal(String pTipoOriginal) {
        this.tipoOriginal = pTipoOriginal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String pTipo) {
        this.tipo = pTipo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String pOrigen) {
        this.origen = pOrigen;
    }

    public int getNumeroAmarilla() {
        return numeroAmarilla;
    }

    public void setNumeroAmarilla(int pNumeroAmarilla) {
        this.numeroAmarilla = pNumeroAmarilla;
    }

    public String getMedidaAplicada() {
        return medidaAplicada;
    }

    public void setMedidaAplicada(String pMedidaAplicada) {
        this.medidaAplicada = pMedidaAplicada;
    }

    public String getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(String pHorarioId) {
        this.horarioId = pHorarioId;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String pLugar) {
        this.lugar = pLugar;
    }

    public LocalDateTime getFechaHecho() {
        return fechaHecho;
    }

    public void setFechaHecho(LocalDateTime pFechaHecho) {
        this.fechaHecho = pFechaHecho;
    }

    public String getDescripcionHechos() {
        return descripcionHechos;
    }

    public void setDescripcionHechos(String pDescripcionHechos) {
        this.descripcionHechos = pDescripcionHechos;
    }

    public String getVersionEstudiante() {
        return versionEstudiante;
    }

    public void setVersionEstudiante(String pVersionEstudiante) {
        this.versionEstudiante = pVersionEstudiante;
    }

    public String getEstadoVersion() {
        return estadoVersion;
    }

    public void setEstadoVersion(String pEstadoVersion) {
        this.estadoVersion = pEstadoVersion;
    }

    public Boolean getAnulado() {
        return anulada;
    }

    public void setAnulado(Boolean pAnulado) {
        this.anulada = pAnulado;
    }

    public String getMotivoAnulacion() {
        return motivoAnulacion;
    }

    public void setMotivoAnulacion(String pMotivoAnulacion) {
        this.motivoAnulacion = pMotivoAnulacion;
    }

    public String getAnuladaPor() {
        return anuladaPor;
    }

    public void setAnuladaPor(String pAnuladaPor) {
        this.anuladaPor = pAnuladaPor;
    }

    public String getReportadoPor() {
        return reportadoPor;
    }

    public void setReportadoPor(String pReportadoPor) {
        this.reportadoPor = pReportadoPor;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }
}