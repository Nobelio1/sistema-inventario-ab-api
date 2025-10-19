package upn.grupo4.sistemainventarioabapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upn.grupo4.sistemainventarioabapi.model.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
}
