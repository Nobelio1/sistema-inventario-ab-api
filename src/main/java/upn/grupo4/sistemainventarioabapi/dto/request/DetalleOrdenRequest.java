package upn.grupo4.sistemainventarioabapi.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleOrdenRequest {

    @NotBlank(message = "El idProducto no puede estar vacío")
    private Long idProducto;

    @NotBlank(message = "La cantidad no puede estar vacía")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer cantidad;
}
