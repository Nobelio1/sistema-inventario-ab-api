package upn.grupo4.sistemainventarioabapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upn.grupo4.sistemainventarioabapi.dto.response.DataResponse;
import upn.grupo4.sistemainventarioabapi.dto.response.ProvedorSelectResponse;
import upn.grupo4.sistemainventarioabapi.service.ProveedorService;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
@RequiredArgsConstructor
public class ProveedorController {
    private final ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<DataResponse<List<ProvedorSelectResponse>>> obtenerProveedores() {
        DataResponse<List<ProvedorSelectResponse>> response = proveedorService.obtenerProveedores();
        return ResponseEntity.ok(response);
    }

}
