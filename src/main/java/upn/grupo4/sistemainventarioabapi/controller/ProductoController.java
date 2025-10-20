package upn.grupo4.sistemainventarioabapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upn.grupo4.sistemainventarioabapi.dto.response.DataResponse;
import upn.grupo4.sistemainventarioabapi.dto.response.ProductoSelectResponse;
import upn.grupo4.sistemainventarioabapi.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;

    @GetMapping("/compra")
    public ResponseEntity<DataResponse<List<ProductoSelectResponse>>> obtenerProductosCompraSelect() {
        return ResponseEntity.ok(productoService.obtenerProductosCompraSelect());
    }

}
