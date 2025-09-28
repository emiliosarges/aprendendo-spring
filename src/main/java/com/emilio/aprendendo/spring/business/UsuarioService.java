package com.emilio.aprendendo.spring.business;

import com.emilio.aprendendo.spring.infrastructure.entity.Usuario;
import com.emilio.aprendendo.spring.infrastructure.exceptions.ConflictException;
import com.emilio.aprendendo.spring.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario salvaUsuario(Usuario usuario) {
        try {
            emailExiste(usuario.getEmail());
            return usuarioRepository.save(usuario);
        }catch (ConflictException e) {
            throw new ConflictException("Email já cadastrado", e.getCause());
        }

    }

    public void emailExiste(String email) {
        try {
            boolean existe = vericarEmailExistente(email);
            if(existe){
                throw new ConflictException("Email já cadastrado " + email);
            }
            }catch (ConflictException e){
            throw new ConflictException("Email já cadastrado" + e.getCause());
        }
    }

    public boolean vericarEmailExistente(String email) {
        return  usuarioRepository.existsByEmail(email);
    }
}
