package upn.grupo4.sistemainventarioabapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "TipoProducto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoProducto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @OneToMany(mappedBy = "tipoProducto", fetch = FetchType.LAZY)
    private Set<Producto> productos;
}
