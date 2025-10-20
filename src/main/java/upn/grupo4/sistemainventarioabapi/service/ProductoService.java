package upn.grupo4.sistemainventarioabapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import upn.grupo4.sistemainventarioabapi.dto.response.DataResponse;
import upn.grupo4.sistemainventarioabapi.dto.response.ProductoSelectResponse;
import upn.grupo4.sistemainventarioabapi.model.Producto;
import upn.grupo4.sistemainventarioabapi.repository.ProductoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository productoRepository;

    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public DataResponse<List<ProductoSelectResponse>> obtenerProductosCompraSelect (){
        List<ProductoSelectResponse> productos = productoRepository.findAll()
                .stream()
                .map(producto -> ProductoSelectResponse.builder()
                        .id(producto.getId())
                        .nombre(producto.getNombre())
                        .precio(producto.getPrecioCosto())
                        .build())
                .toList();

        return DataResponse.<List<ProductoSelectResponse>>builder()
                .success(true)
                .message("Lista de productos compra obtenida correctamente")
                .data(productos)
                .build();
    }

}
