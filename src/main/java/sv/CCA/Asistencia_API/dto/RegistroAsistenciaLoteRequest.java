package sv.CCA.Asistencia_API.dto;

import java.time.LocalDate;
import java.util.List;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RegistroAsistenciaLoteRequest(
    @NotBlank String seccionId,
    @NotBlank String anioLectivoId,
    @NotNull LocalDate fecha,
    @NotBlank String momento,
    String horarioId,
    @NotBlank String docenteId,
    @NotEmpty List<@Valid Registro> registros
) {
    public record Registro(
        @NotBlank String estudianteId,
        @NotBlank String estado,
        @NotBlank String clientUuid,
        String justificacion
    ) {}
}
