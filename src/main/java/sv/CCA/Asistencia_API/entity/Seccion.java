package sv.CCA.Asistencia_API.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "secciones")
public class Seccion {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "anio_lectivo_id", nullable = false, length = 36)
    private String anioLectivoId;

    @Column(name = "grado", nullable = false, length = 30)
    private String grado;

    @Column(name = "letra", nullable = false, length = 1)
    private String letra;

    @Column(name = "nivel", nullable = true)
    private String nivel;

    @Column(name = "turno", nullable = false)
    private String turno;

    @Column(name = "especialidad", nullable = false, length = 80)
    private String especialidad;

    @Column(name = "orientador_id", nullable = false, length = 36)
    private String orientadorId;

    @Column(name = "especialidad_unica", nullable = true, length = 80)
    private String especialidadUnica;

    public Seccion() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnioLectivoId() {
        return anioLectivoId;
    }

    public void setAnioLectivoId(String anioLectivoId) {
        this.anioLectivoId = anioLectivoId;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getOrientadorId() {
        return orientadorId;
    }

    public void setOrientadorId(String orientadorId) {
        this.orientadorId = orientadorId;
    }

    public String getEspecialidadUnica() {
        return especialidadUnica;
    }

    public void setEspecialidadUnica(String especialidadUnica) {
        this.especialidadUnica = especialidadUnica;
    }
}