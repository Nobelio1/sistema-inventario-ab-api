package upn.grupo4.sistemainventarioabapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upn.grupo4.sistemainventarioabapi.model.StockAlmacen;

@Repository
public interface StockAlmacenRepository extends JpaRepository<StockAlmacen, Long> {
}
