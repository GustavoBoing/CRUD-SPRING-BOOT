package com.Boing.cadastro_usuario.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Produto")
@Entity

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="nome",length = 500)
    private String nome;

    @Column(name = "valor")
    private double valor;

    @Column(name = "quantidade")
    private int quantidade;
}
