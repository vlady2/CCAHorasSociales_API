package sv.CCA.Asistencia_API.entity;

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
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "nombre_completo", nullable = false, length = 150)
    private String nombreCompleto;

    @Column(name = "correo_institucional", nullable = false, unique = true, length = 120)
    private String correoInstitucional;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @Column(name = "debe_cambiar_password", nullable = false)
    private Boolean debeCambiarPassword = true;

    @Column(name = "rol", nullable = false)
    private String rol;

    @Column(name = "mfa_secreto_cifrado", columnDefinition = "TEXT")
    private String mfaSecretoCifrado;

    @Column(name = "mfa_habilitado", nullable = false)
    private Boolean mfaHabilitado = false;

    @Column(name = "intentos_fallidos")
    private Short intentosFallidos = 0;

    @Column(name = "bloqueado_hasta")
    private LocalDateTime bloqueadoHasta;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;

    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    @Column(name = "actualizado_en", nullable = false)
    private LocalDateTime actualizadoEn;

    public Usuario() {
    }

    @PrePersist
    protected void alCrear() {
        LocalDateTime ahora = LocalDateTime.now();

        if (creadoEn == null) {
            creadoEn = ahora;
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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Boolean getDebeCambiarPassword() {
        return debeCambiarPassword;
    }

    public void setDebeCambiarPassword(Boolean debeCambiarPassword) {
        this.debeCambiarPassword = debeCambiarPassword;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getMfaSecretoCifrado() {
        return mfaSecretoCifrado;
    }

    public void setMfaSecretoCifrado(String mfaSecretoCifrado) {
        this.mfaSecretoCifrado = mfaSecretoCifrado;
    }

    public Boolean getMfaHabilitado() {
        return mfaHabilitado;
    }

    public void setMfaHabilitado(Boolean mfaHabilitado) {
        this.mfaHabilitado = mfaHabilitado;
    }

    public Short getIntentosFallidos() {
        return intentosFallidos;
    }

    public void setIntentosFallidos(Short intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }

    public LocalDateTime getBloqueadoHasta() {
        return bloqueadoHasta;
    }

    public void setBloqueadoHasta(LocalDateTime bloqueadoHasta) {
        this.bloqueadoHasta = bloqueadoHasta;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
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
