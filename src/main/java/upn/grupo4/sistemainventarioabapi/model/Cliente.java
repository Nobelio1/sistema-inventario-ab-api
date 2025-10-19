package upn.grupo4.sistemainventarioabapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "Cliente")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String nombre;

    @Column(length = 20)
    private String documento;

    @Column(length = 255)
    private String direccion;

    @Column(length = 50)
    private String telefono;

    @Column(length = 150)
    private String email;

    @Column(length = 50)
    private String tipoCliente;

    private Boolean activo = true;
}
