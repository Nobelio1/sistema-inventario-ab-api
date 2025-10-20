package upn.grupo4.sistemainventarioabapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import upn.grupo4.sistemainventarioabapi.model.Cliente;
import upn.grupo4.sistemainventarioabapi.repository.ClienteRepository;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }
}
