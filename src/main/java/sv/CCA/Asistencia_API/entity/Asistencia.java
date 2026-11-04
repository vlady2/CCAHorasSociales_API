package sv.CCA.Asistencia_API.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "asistencia")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "estudiante_id", nullable = false, length = 36)
    private String estudianteId;

    @Column(name = "seccion_id", nullable = false, length = 36)
    private String seccionId;

    @Column(name = "anio_lectivo_id", nullable = false, length = 36)
    private String anioLectivoId;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "momento", nullable = false)
    private String momento;

    @Column(name = "horario_id", nullable = true, length = 36)
    private String horarioId;

    @Column(name = "hora_registro", nullable = false)
    private LocalTime horaRegistro;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "justificacion", nullable = true)
    private String justificacion;

    @Column(name = "tardanza_consumida_en", nullable = true, length = 36)
    private String tardanzaConsumidaEn;    

    @Column(name = "client_uuid", nullable = false, length = 36)
    private String clientUuid;    

    @Column(name = "registrado_por", nullable = false, length = 36)
    private String registradoPor;   

    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    @Column(name = "actualizado_en", nullable = false)
    private LocalDateTime actualizadoEn;

    @Column(name = "horario_unico_key", insertable = false, updatable = false, length = 80)
    private String horarioUnicoKey;

    public Asistencia() {
    }

    @PrePersist
    protected void alCrear() {
        LocalDateTime ahora = LocalDateTime.now();

        if (creadoEn == null) {
            creadoEn = ahora;
        }
        if (horaRegistro == null) {
            horaRegistro = ahora.toLocalTime();
        }
        actualizadoEn = ahora;
    }

    @PreUpdate
    protected void alActualizar() {
        actualizadoEn = LocalDateTime.now();
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
        return anioLectivoId;
    }

    public void setAnioLectivoId(String pAnioLectivoId) {
        this.anioLectivoId = pAnioLectivoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate pFecha) {
        this.fecha = pFecha;
    }

    public String getMomento() {
        return momento;
    }

    public void setMomento(String pMomento) {
        this.momento = pMomento;
    }
    
    public String getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(String pHorarioId) {
        this.horarioId = pHorarioId;
    }

    public LocalTime getHoraRegistro() {
        return horaRegistro;
    }

    public void setHoraRegistro(LocalTime pHoraregistro) {
        this.horaRegistro = pHoraregistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String pEstado) {
        this.estado = pEstado;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String pJustificacion) {
        this.justificacion = pJustificacion;
    }

    public String getTardanzaConsumidaEn() {
        return tardanzaConsumidaEn;
    }

    public void setTardanzaConsumidaEn(String pTardanzaConsumidaEn) {
        this.tardanzaConsumidaEn = pTardanzaConsumidaEn;
    }

    public String getClienteID() {
        return clientUuid;
    }

    public void setClienteID(String pClienteId) {
        this.clientUuid = pClienteId;
    }

    public String getRegistradoPor() {
        return registradoPor;
    }

    public void setRegistradoPor(String pRegistrado) {
        this.registradoPor = pRegistrado;
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

    public String getHorarioUnicoKey() {
        return horarioUnicoKey;
    }

    public void setHorarioUnicoKey(String horarioUnicoKey) {
        this.horarioUnicoKey = horarioUnicoKey;
    }
}