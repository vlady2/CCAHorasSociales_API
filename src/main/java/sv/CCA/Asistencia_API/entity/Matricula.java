package sv.CCA.Asistencia_API.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "matriculas")
public class Matricula {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "estudiante_id", nullable = false, length = 36)
    private String estudianteId;

    @Column(name = "seccion_id", nullable = false, length = 36)
    private String seccionId;

    @Column(name = "anio_lectivo_id", nullable = false, length = 36)
    private String anioLectivoId;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "matricula_activa_key", insertable = false, updatable = false, length = 108)
    private String matriculaActivaKey;

    public Matricula() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(String estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(String seccionId) {
        this.seccionId = seccionId;
    }

    public String getAnioLectivoId() {
        return anioLectivoId;
    }

    public void setAnioLectivoId(String anioLectivoId) {
        this.anioLectivoId = anioLectivoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMatriculaActivaKey() {
        return matriculaActivaKey;
    }

    public void setMatriculaActivaKey(String matriculaActivaKey) {
        this.matriculaActivaKey = matriculaActivaKey;
    }
}