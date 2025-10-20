package upn.grupo4.sistemainventarioabapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upn.grupo4.sistemainventarioabapi.dto.request.OrdenRequest;
import upn.grupo4.sistemainventarioabapi.dto.response.DataResponse;
import upn.grupo4.sistemainventarioabapi.dto.response.OrdenResponse;
import upn.grupo4.sistemainventarioabapi.service.OrdenService;

import java.util.List;

@RestController
@RequestMapping("/orden")
@RequiredArgsConstructor
public class OrdenController {
    private final OrdenService ordenService;

    @PostMapping("/compra")
    public ResponseEntity<DataResponse<Object>> registrarCompra(@RequestBody OrdenRequest ordenRequest) {
        return ResponseEntity.ok(ordenService.registrarOrdenCompra(ordenRequest));
    }

    @GetMapping
    public ResponseEntity<DataResponse<List<OrdenResponse>>> obtenerOrdenes(){
        return ResponseEntity.ok(ordenService.obtenerOrdenes());
    }

}
