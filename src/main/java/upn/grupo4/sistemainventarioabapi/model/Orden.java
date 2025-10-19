package upn.grupo4.sistemainventarioabapi.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import upn.grupo4.sistemainventarioabapi.model.enums.OrdenTipo;

import java.io.Serial;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Orden")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orden implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private OrdenTipo tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedorId")
    private Proveedor proveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clienteId")
    private Cliente cliente;

    @CreationTimestamp
    private LocalDateTime fecha;

    @Column(length = 30)
    private String estado = "BORRADOR";

    private Double subtotal;
    private Double impuesto;
    private Double total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createdBy")
    private Usuario createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approvedBy")
    private Usuario approvedBy;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DetalleOrden> detalles;
}
