package sv.CCA.Asistencia_API.entity;

import java.time.LocalTime;
import jakarta.persistence.*;

@Entity
@Table(name = "jornadas")
public class Jornada {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "nivel", nullable = true)
    private String nivel;

    @Column(name = "turno", nullable = false)
    private String turno;

    @Column(name = "hora_entrada_inicio", nullable = false)
    private LocalTime horaEntradaInicio;

    @Column(name = "hora_entrada_fin", nullable = false)
    private LocalTime horaEntradaFin;

    public Jornada() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public LocalTime getHoraEntradaInicio() {
        return horaEntradaInicio;
    }

    public void setHoraEntradaInicio(LocalTime horaEntradaInicio) {
        this.horaEntradaInicio = horaEntradaInicio;
    }

    public LocalTime getHoraEntradaFin() {
        return horaEntradaFin;
    }

    public void setHoraEntradaFin(LocalTime horaEntradaFin) {
        this.horaEntradaFin = horaEntradaFin;
    }
}