package upn.grupo4.sistemainventarioabapi.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Almacen")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Almacen implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 50)
    private String codigo;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(length = 255)
    private String direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsableUsuarioId")
    private Usuario responsableUsuario;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "almacen", fetch = FetchType.LAZY)
    private Set<StockAlmacen> stockAlmacenes;
}
