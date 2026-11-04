package sv.CCA.Asistencia_API.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegistroUsuarioRequest(

    @NotBlank(message = "El nombre completo es obligatorio")
    @Size(max = 150, message = "El nombre no puede superar 150 caracteres")
    String nombreCompleto,

    @NotBlank(message = "El correo institucional es obligatorio")
    @Email(message = "El correo institucional no tiene un formato válido")
    @Size(max = 120, message = "El correo no puede superar 120 caracteres")
    String correoInstitucional,

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 12, max = 128,
          message = "La contraseña debe tener entre 12 y 128 caracteres")
    String password,

    @NotBlank(message = "El rol es obligatorio")
    String rol

) {
}
