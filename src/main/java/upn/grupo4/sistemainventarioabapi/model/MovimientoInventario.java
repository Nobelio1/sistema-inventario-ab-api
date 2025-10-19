package upn.grupo4.sistemainventarioabapi.model;

import upn.grupo4.sistemainventarioabapi.model.enums.TipoMov;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.time.LocalDateTime;
import java.io.Serializable;

@Entity
@Table(name = "MovimientoInventario",
        indexes = {@Index(name = "idx_mov_producto_fecha", columnList = "producto_id, fecha")})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoInventario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private TipoMov tipoMov;

    @Column(length = 50)
    private String referenciaTipo;

    private Long referenciaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(precision = 14, scale = 4, nullable = false)
    private Double cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "almacenOrigenId")
    private Almacen almacenOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "almacenDestinoId")
    private Almacen almacenDestino;

    @Column(length = 100)
    private String lote;

    @CreationTimestamp
    private LocalDateTime fecha;

    @Column(length = 255)
    private String motivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performedBy")
    private Usuario performedBy;
}
