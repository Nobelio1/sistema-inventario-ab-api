package upn.grupo4.sistemainventarioabapi.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse<T> {
    private Boolean success;
    private String message;
    private T data;
}