package upn.grupo4.sistemainventarioabapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import upn.grupo4.sistemainventarioabapi.model.Proveedor;
import upn.grupo4.sistemainventarioabapi.repository.ProveedorRepository;

@Service
@RequiredArgsConstructor
public class ProveedorService {
    private final ProveedorRepository proveedorRepository;

    public Proveedor obtenerProveedorPorId(Long id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: " + id));
    }
}
