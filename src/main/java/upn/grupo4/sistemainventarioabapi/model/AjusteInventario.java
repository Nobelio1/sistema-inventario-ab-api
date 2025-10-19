package upn.grupo4.sistemainventarioabapi.model;

import upn.grupo4.sistemainventarioabapi.model.enums.TipoAjuste;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.time.LocalDateTime;
import java.io.Serializable;

@Entity
@Table(name = "AjusteInventario")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AjusteInventario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movimientoId")
    private MovimientoInventario movimiento;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private TipoAjuste tipoAjuste;

    @Column(length = 255)
    private String motivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aprobadoPor")
    private Usuario aprobadoPor;

    private LocalDateTime fechaAprobacion;
}