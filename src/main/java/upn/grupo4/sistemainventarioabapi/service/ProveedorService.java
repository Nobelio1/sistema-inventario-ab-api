package upn.grupo4.sistemainventarioabapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import upn.grupo4.sistemainventarioabapi.dto.response.DataResponse;
import upn.grupo4.sistemainventarioabapi.dto.response.ProvedorSelectResponse;
import upn.grupo4.sistemainventarioabapi.model.Proveedor;
import upn.grupo4.sistemainventarioabapi.repository.ProveedorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorService {
    private final ProveedorRepository proveedorRepository;

    public Proveedor obtenerProveedorPorId(Long id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: " + id));
    }

    public DataResponse<List<ProvedorSelectResponse>> obtenerProveedores() {
        List<ProvedorSelectResponse> proveedores = proveedorRepository.findAll()
                .stream()
                .map(proveedor -> ProvedorSelectResponse.builder()
                        .id(proveedor.getId())
                        .nombre(proveedor.getRazonSocial())
                        .build())
                .toList();

        return DataResponse.<List<ProvedorSelectResponse>>builder()
                .success(true)
                .message("Lista de proveedores obtenida correctamente")
                .data(proveedores)
                .build();
    }
}
