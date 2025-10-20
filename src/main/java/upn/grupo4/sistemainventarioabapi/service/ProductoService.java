package upn.grupo4.sistemainventarioabapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import upn.grupo4.sistemainventarioabapi.model.Producto;
import upn.grupo4.sistemainventarioabapi.repository.ProductoRepository;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository productoRepository;

    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }
}
