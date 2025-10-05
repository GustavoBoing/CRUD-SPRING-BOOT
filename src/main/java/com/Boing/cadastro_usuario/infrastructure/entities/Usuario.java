package com.Boing.cadastro_usuario.infrastructure.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="usuario")
@Entity

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "email", unique = true, length = 200)
    private String email;

    @Column(name = "nome")
    private String nome;
}
