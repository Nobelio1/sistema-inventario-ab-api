package upn.grupo4.sistemainventarioabapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenRequest {

    private Long idCliente;

    @NotBlank(message = "El idUsuario no puede estar vacío")
    private Long idUsuario;

    @NotBlank(message = "El idProveedor no puede estar vacío")
    private Long idProveedor;

    @NotBlank(message = "La fechaOrden no puede estar vacía")
    private LocalDateTime fechaOrden;

    @NotBlank(message = "El estadoOrden no puede estar vacío")
    private List<DetalleOrdenRequest> detalleOrden;
}
