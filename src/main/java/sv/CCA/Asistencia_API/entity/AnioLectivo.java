package sv.CCA.Asistencia_API.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "anios_lectivos")
public class AnioLectivo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "anio", nullable = false, updatable = false)
    private int anio;

    @Column(name = "fecha_inicio", nullable = false, updatable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin", nullable = false, updatable = false)
    private LocalDateTime fechaFin;

    @Column(name = "estado", nullable = false)
    private String estado;

    public AnioLectivo() {
    }

    // Getters y setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getAnio() {
        return anio;
    }

    public void setNie(int pAnio) {
        this.anio = pAnio;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime pfechaInicio) {
        this.fechaInicio = pfechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime pFechaFin) {
        this.fechaFin = pFechaFin;
    }

    public String getestado() {
        return estado;
    }

    public void setEstado(String pEstado) {
        this.estado = pEstado;
    }
}