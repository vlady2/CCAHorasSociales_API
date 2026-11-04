package sv.CCA.Asistencia_API.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "asignaciones_subdireccion")
public class AsignacionSubdireccion {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "usuario_id", nullable = false, length = 36)
    private String usuarioId;

    @Column(name = "anio_lectivo_id", nullable = false, length = 36)
    private String anioLectivoId;

    @Column(name = "nivel", nullable = true)
    private String nivel;

    @Column(name = "turno", nullable = false)
    private String turno;

    public AsignacionSubdireccion() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getAnioLectivoId() {
        return anioLectivoId;
    }

    public void setAnioLectivoId(String anioLectivoId) {
        this.anioLectivoId = anioLectivoId;
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
}