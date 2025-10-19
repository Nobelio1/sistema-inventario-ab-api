package upn.grupo4.sistemainventarioabapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "DetalleOrden")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleOrden implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordenId", nullable = false)
    private Orden orden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productoId", nullable = false)
    private Producto producto;

    @Column(precision = 14, scale = 4, nullable = false)
    private Double cantidad;

    @Column(precision = 14, scale = 2, nullable = false)
    private Double precioUnitario;

    @Column(precision = 10, scale = 2)
    private Double descuento = 0d;

    @Column(precision = 10, scale = 2)
    private Double impuesto = 0d;
}