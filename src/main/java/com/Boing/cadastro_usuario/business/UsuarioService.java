package com.Boing.cadastro_usuario.business;

import com.Boing.cadastro_usuario.infrastructure.entities.Usuario;
import com.Boing.cadastro_usuario.infrastructure.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository, UsuarioRepository repository1){
        this.repository = repository1;
    }

    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado!!")
        );
    }

    public void deletarUsuarioPorEmail(String email) {
        repository.deleteByEmail(email);
    }

    public void atualizarUsuario(/*String email*/int id, Usuario novosDadosUsuario) {
        //1° Forma - usando email para encontrar o usuario
        /*Usuario usuarioEntity = buscarUsuarioPorEmail(email);
        Usuario usuarioAtualizado = Usuario.builder()
                .email(email)
                .nome(novosDadosUsuario.getNome() != null ? novosDadosUsuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();
        */
        //2° Forma - usando o ID para encontrar o usuario
        Usuario usuarioEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuarioEntity.getEmail())
                .nome(novosDadosUsuario != null ? novosDadosUsuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        repository.saveAndFlush(usuarioAtualizado);
    }
}
