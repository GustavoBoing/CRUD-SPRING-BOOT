package com.Boing.cadastro_usuario.infrastructure.repositories;

import com.Boing.cadastro_usuario.infrastructure.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> { //interface ja cria os metodos do CRUD. JPARepository pede 2 parametros, a classe que será usada e o tipo da chave primaria
    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findById(int id);

    @Transactional // Faz com que a operação delete 100% do usuario ou não delete
    void deleteByEmail(String email);
}
