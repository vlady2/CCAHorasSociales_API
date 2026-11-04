package sv.CCA.Asistencia_API.entity;

import java.time.LocalDate;
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
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "nie", nullable = false, unique = true, length = 20)
    private String nie;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "fecha_nacimiento", nullable = false, updatable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;

    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    @Column(name = "actualizado_en", nullable = false)
    private LocalDateTime actualizadoEn;

    public Estudiante() {
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

    public String getNie() {
        return nie;
    }

    public void setNie(String pNie) {
        this.nie = pNie;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String pNombres) {
        this.nombres = pNombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String pApellido) {
        this.apellidos = pApellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate pFechaNacimiento) {
        this.fechaNacimiento = pFechaNacimiento;
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