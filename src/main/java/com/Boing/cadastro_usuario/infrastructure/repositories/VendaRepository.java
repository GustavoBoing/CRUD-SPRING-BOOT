package com.Boing.cadastro_usuario.infrastructure.repositories;

import com.Boing.cadastro_usuario.infrastructure.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
    Optional<Venda> findVendaById(Integer id);


    @Transactional
    void deleteVendaById(Integer id) ;
}