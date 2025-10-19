package upn.grupo4.sistemainventarioabapi.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.time.LocalDateTime;
import java.io.Serializable;

@Entity
@Table(name = "StockAlmacen", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"producto_id","almacen_id","lote"})
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockAlmacen implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "almacen_id", nullable = false)
    private Almacen almacen;

    @Column(precision = 14, scale = 4)
    private Double cantidad = 0d;

    @Column(length = 100)
    private String lote;

    private java.time.LocalDate fechaVencimiento;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
