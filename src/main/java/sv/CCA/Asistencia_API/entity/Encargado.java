package sv.CCA.Asistencia_API.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "encargados")
public class Encargado {

    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "nombre_completo", nullable = false, length = 150)
    private String nombreCompleto;

    @Column(name = "correo", nullable = false, length = 120)
    private String correo;

    @Column(name = "telefono_cifrado", nullable = false)
    private String telefonoCifrado;

    public Encargado() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefonoCifrado() {
        return telefonoCifrado;
    }

    public void setTelefonoCifrado(String telefonoCifrado) {
        this.telefonoCifrado = telefonoCifrado;
    }
}