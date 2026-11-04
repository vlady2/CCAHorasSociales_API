package sv.CCA.Asistencia_API.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "parametros_sistema")
public class ParametroSistema {

    @Id
    @Column(name = "clave", nullable = false, length = 255)
    private String clave;

    @Column(name = "valor", nullable = false)
    private String valor;

    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;

    @Column(name = "actualizado_por", nullable = false, length = 36)
    private String actualizadoPor;

    @Column(name = "actualizado_en", nullable = false)
    private LocalDateTime actualizadoEn;

    public ParametroSistema() {
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getActualizadoPor() {
        return actualizadoPor;
    }

    public void setActualizadoPor(String actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }

    public LocalDateTime getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(LocalDateTime actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }
}