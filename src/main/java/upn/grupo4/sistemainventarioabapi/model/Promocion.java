package upn.grupo4.sistemainventarioabapi.model;

import jakarta.persistence.*;
import lombok.*;
import upn.grupo4.sistemainventarioabapi.model.enums.PromocionTipo;

import java.io.Serial;
import java.time.LocalDate;
import java.io.Serializable;

@Entity
@Table(name = "Promocion")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Promocion implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private PromocionTipo tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productoId")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoriaId")
    private TipoProducto categoria;

    private Double porcentaje;
    private Double montoFijo;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    private Integer condicionMinima;

    private Boolean activo = true;
}
