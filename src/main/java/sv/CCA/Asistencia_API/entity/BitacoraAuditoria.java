package sv.CCA.Asistencia_API.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "bitacora_auditoria")
public class BitacoraAuditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "usuario_id", nullable = false, length = 36)
    private String usuarioId;

    @Column(name = "accion", nullable = true)
    private String accion;

    @Column(name = "entidad", nullable = false, length = 40)
    private String entidad;

    @Column(name = "entidad_id", nullable = false, length = 36)
    private String entidadId;

    @Column(name = "datos_antes", nullable = false)
    private String datosAntes;

    @Column(name = "datos_despues", nullable = false)
    private String datosDespues;

    @Column(name = "ip", nullable = false, length = 45)
    private String ip;

    @Column(name = "dispositivo", nullable = false, length = 255)
    private String dispositivo;

    @Column(name = "creado_en", nullable = false)
    private LocalDateTime creadoEn;

    public BitacoraAuditoria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getEntidadId() {
        return entidadId;
    }

    public void setEntidadId(String entidadId) {
        this.entidadId = entidadId;
    }

    public String getDatosAntes() {
        return datosAntes;
    }

    public void setDatosAntes(String datosAntes) {
        this.datosAntes = datosAntes;
    }

    public String getDatosDespues() {
        return datosDespues;
    }

    public void setDatosDespues(String datosDespues) {
        this.datosDespues = datosDespues;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }
}