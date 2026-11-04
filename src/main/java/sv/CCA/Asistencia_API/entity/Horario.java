package sv.CCA.Asistencia_API.entity;

import java.time.LocalTime;
import jakarta.persistence.*;

@Entity
@Table(name = "horarios")
public class Horario {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "seccion_id", nullable = false, length = 36)
    private String seccionId;

    @Column(name = "docente_id", nullable = false, length = 36)
    private String docenteId;

    @Column(name = "dia_semana", nullable = false)
    private Integer diaSemana;

    @Column(name = "numero_periodo", nullable = false)
    private Integer numeroPeriodo;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    @Column(name = "asignatura", nullable = false, length = 100)
    private String asignatura;

    public Horario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(String seccionId) {
        this.seccionId = seccionId;
    }

    public String getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(String docenteId) {
        this.docenteId = docenteId;
    }

    public Integer getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Integer diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Integer getNumeroPeriodo() {
        return numeroPeriodo;
    }

    public void setNumeroPeriodo(Integer numeroPeriodo) {
        this.numeroPeriodo = numeroPeriodo;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
}
