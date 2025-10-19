package upn.grupo4.sistemainventarioabapi.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.time.LocalDateTime;
import java.io.Serializable;

@Entity
@Table(name = "Reporte")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reporte implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(length = 50)
    private String tipo;

    @Column(length = 255)
    private String rutaArchivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "generadoPor")
    private Usuario generadoPor;

    @CreationTimestamp
    private LocalDateTime fechaGeneracion;
}
