package com.Boing.cadastro_usuario.infrastructure.repositories;

import com.Boing.cadastro_usuario.infrastructure.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Optional<Produto> findByNome(String nome);

    Optional<Produto> findById(int id);

    @Transactional
    void deleteByNome(String nome);
}
