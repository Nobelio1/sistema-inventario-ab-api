package upn.grupo4.sistemainventarioabapi.dto.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProvedorSelectResponse {
    private Long id;
    private String nombre;
}
