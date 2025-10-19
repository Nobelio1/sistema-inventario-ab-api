package upn.grupo4.sistemainventarioabapi.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.time.LocalDateTime;
import java.io.Serializable;

@Entity
@Table(name = "Devolucion")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Devolucion implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordenId", nullable = false)
    private Orden orden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detalleOrdenId")
    private DetalleOrden detalleOrden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productoId", nullable = false)
    private Producto producto;

    @Column(precision = 14, scale = 4, nullable = false)
    private Double cantidad;

    @Column(length = 255)
    private String motivo;

    @CreationTimestamp
    private LocalDateTime fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "procesadoPor")
    private Usuario procesadoPor;
}