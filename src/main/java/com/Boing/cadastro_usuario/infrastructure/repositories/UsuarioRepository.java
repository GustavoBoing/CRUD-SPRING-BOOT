package com.Boing.cadastro_usuario.infrastructure.repositories;

import com.Boing.cadastro_usuario.infrastructure.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findById(int id);

    @Transactional
    void deleteByEmail(String email);
}
