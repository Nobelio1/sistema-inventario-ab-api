package upn.grupo4.sistemainventarioabapi.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.time.LocalDateTime;
import java.io.Serializable;

@Entity
@Table(name = "Pago")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pago implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordenId", nullable = false)
    private Orden orden;

    private Double monto;

    @Column(length = 50)
    private String metodo;

    @CreationTimestamp
    private LocalDateTime fecha;

    @Column(length = 100)
    private String comprobante;
}
