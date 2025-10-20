package upn.grupo4.sistemainventarioabapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upn.grupo4.sistemainventarioabapi.dto.request.DetalleOrdenRequest;
import upn.grupo4.sistemainventarioabapi.dto.request.OrdenRequest;
import upn.grupo4.sistemainventarioabapi.dto.response.DataResponse;
import upn.grupo4.sistemainventarioabapi.dto.response.OrdenResponse;
import upn.grupo4.sistemainventarioabapi.model.*;
import upn.grupo4.sistemainventarioabapi.model.enums.EstadoOrden;
import upn.grupo4.sistemainventarioabapi.model.enums.OrdenTipo;
import upn.grupo4.sistemainventarioabapi.repository.DetalleOrdenRepository;
import upn.grupo4.sistemainventarioabapi.repository.OrdenRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdenService {
    private final OrdenRepository ordenRepository;
    private final DetalleOrdenRepository detalleOrdenRepository;
    private final UsuarioService usuarioService;
    private final ProveedorService proveedorService;
    private final ClienteService clienteService;
    private final ProductoService productoService;

    public DataResponse<Object> registrarOrdenCompra(OrdenRequest ordenRequest) {
        System.out.println(ordenRequest);
        registrarOrden(ordenRequest, OrdenTipo.COMPRA);
        return DataResponse.builder()
                .success(true)
                .message("Orden de compra registrada exitosamente")
                .build();
    }

    public DataResponse<Object> registrarOrdenVenta(OrdenRequest ordenRequest) {
        registrarOrden(ordenRequest, OrdenTipo.VENTA);
        return DataResponse.builder()
                .success(true)
                .message("Orden de venta registrada exitosamente")
                .build();
    }

    private void registrarOrden(OrdenRequest ordenRequest, OrdenTipo tipo) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(ordenRequest.getIdUsuario());
        Proveedor proveedor = proveedorService.obtenerProveedorPorId(ordenRequest.getIdProveedor());
        Cliente cliente;

        if(tipo == OrdenTipo.VENTA){
            cliente = clienteService.obtenerClientePorId(ordenRequest.getIdCliente());
        }else{
            cliente = null;
        }

        List<DetalleOrdenRequest> detalles = ordenRequest.getDetalleOrden();
        double total;
        double subtotal = 0.0;
        double impuesto = 0.18;

        for(DetalleOrdenRequest detalle : detalles){
            Producto producto = productoService.obtenerProductoPorId(detalle.getIdProducto());

            Double precioProducto;
            if(tipo == OrdenTipo.VENTA){
                precioProducto = producto.getPrecioVenta();
            }else{
                precioProducto = producto.getPrecioCosto();
            }

            double precioTotal = precioProducto * detalle.getCantidad();
            subtotal += precioTotal;
        }
        total = subtotal + (subtotal * impuesto);

        Orden ordenEntity = Orden.builder()
                .tipo(tipo)
                .proveedor(proveedor)
                .cliente(cliente)
                .fecha(ordenRequest.getFechaOrden())
                .estado(EstadoOrden.PENDIENTE)
                .subtotal(subtotal)
                .impuesto(impuesto * subtotal)
                .total(total)
                .createdBy(usuario)
                .build();

        Orden ordenGuardada = ordenRepository.save(ordenEntity);

        for(DetalleOrdenRequest detalle : detalles){
            Producto producto = productoService.obtenerProductoPorId(detalle.getIdProducto());

            Double precioProducto;
            if(tipo == OrdenTipo.VENTA){
                precioProducto = producto.getPrecioVenta();
            }else{
                precioProducto = producto.getPrecioCosto();
            }

            var detalleOrdenEntity = DetalleOrden.builder()
                    .orden(ordenGuardada)
                    .producto(producto)
                    .cantidad(detalle.getCantidad())
                    .precioUnitario(precioProducto)
                    .descuento(0d)
                    .impuesto(0d)
                    .build();

            detalleOrdenRepository.save(detalleOrdenEntity);
        }
    }

    @Transactional(readOnly = true)
    public DataResponse<List<OrdenResponse>> obtenerOrdenes(){
        List<OrdenResponse> ordenes = ordenRepository.findAll()
                .stream()
                .map(orden -> OrdenResponse.builder()
                        .id(orden.getId())
                        .tipo(orden.getTipo().name())
                        .fecha(orden.getFecha().toString())
                        .total(orden.getTotal())
                        .estado(orden.getEstado().name())
                        .creador(orden.getCreatedBy().getNombre())
                        .build())
                .toList();

        return DataResponse.<List<OrdenResponse>>builder()
                .success(true)
                .message("Lista de ordenes obtenida correctamente")
                .data(ordenes)
                .build();
    }


}
