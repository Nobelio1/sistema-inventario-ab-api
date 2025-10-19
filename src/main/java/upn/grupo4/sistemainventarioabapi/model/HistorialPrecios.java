package upn.grupo4.sistemainventarioabapi.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import upn.grupo4.sistemainventarioabapi.model.enums.TipoPrecio;

import java.io.Serial;
import java.time.LocalDateTime;
import java.io.Serializable;

@Entity
@Table(name = "HistorialPrecios",
        indexes = {@Index(name = "idx_histprod_fecha", columnList = "producto_id, fechaInicio")})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistorialPrecios implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productoId", nullable = false)
    private Producto producto;

    private Double precioUnitario;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TipoPrecio tipoPrecio;

    @CreationTimestamp
    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creadoPor")
    private Usuario creadoPor;
}
