package upn.grupo4.sistemainventarioabapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdenResponse {
    private Long id;
    private String tipo;
    private String fecha;
    private Double total;
    private String estado;
    private String creador;
}
