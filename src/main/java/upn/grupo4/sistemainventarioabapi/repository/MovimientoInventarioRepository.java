package upn.grupo4.sistemainventarioabapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upn.grupo4.sistemainventarioabapi.model.DetalleOrden;

@Repository
public interface MovimientoInventarioRepository extends JpaRepository<DetalleOrden, Long> {
}
