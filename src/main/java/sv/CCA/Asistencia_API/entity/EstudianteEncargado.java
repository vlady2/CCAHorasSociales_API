package sv.CCA.Asistencia_API.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiante_encargado")
public class EstudianteEncargado {

    @Id
    @Column(name = "estudiante_id", nullable = false, length = 36)
    private String estudianteId;

    @Column(name = "encargado_id", nullable = false, length = 36)
    private String encargadoId;

    @Column(name = "parentesco", nullable = false, length = 30)
    private String parentesco;

    @Column(name = "es_principal", nullable = false)
    private Boolean esPrincipal;

    @Column(name = "principal_key", nullable = true, length = 36)
    private String principalKey;

    public EstudianteEncargado() {
    }

    public String getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(String estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getEncargadoId() {
        return encargadoId;
    }

    public void setEncargadoId(String encargadoId) {
        this.encargadoId = encargadoId;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Boolean getEsPrincipal() {
        return esPrincipal;
    }

    public void setEsPrincipal(Boolean esPrincipal) {
        this.esPrincipal = esPrincipal;
    }

    public String getPrincipalKey() {
        return principalKey;
    }

    public void setPrincipalKey(String principalKey) {
        this.principalKey = principalKey;
    }
}