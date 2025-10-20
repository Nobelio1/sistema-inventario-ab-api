package upn.grupo4.sistemainventarioabapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import upn.grupo4.sistemainventarioabapi.model.Usuario;
import upn.grupo4.sistemainventarioabapi.repository.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con email: " + id));
    }

}
