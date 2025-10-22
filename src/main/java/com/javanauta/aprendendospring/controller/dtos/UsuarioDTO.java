package com.javanauta.aprendendospring.controller.dtos;

import com.javanauta.aprendendospring.infrastructure.entity.Usuario;
import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private String email;
    private String senha;

}
