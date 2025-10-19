package upn.grupo4.sistemainventarioabapi.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Producto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 50)
    private String sku;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoProductoId")
    private TipoProducto tipoProducto;

    @Column(length = 20)
    private String unidadMedida;

    @Column(length = 100)
    private String barcode;

    private Double stockMin = 0d;
    private Double stockMax = 0d;

    private Double precioVenta;
    private Double precioCosto;

    private Boolean activo = true;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private Long createdBy;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private Long updatedBy;

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private Set<StockAlmacen> stocks;
}
