package com.Boing.cadastro_usuario.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter // gera o getter pra todos os atributos da classe
@Setter // gera o setter para todos  os atributos da classe
@AllArgsConstructor // gera os construtores de cada atributo da classe
@NoArgsConstructor // cria um construtor vazio
@Builder // Cria um padrão de construção de objetos fluente (Builder Pattern)
@Table(name = "venda") // definir nome da tabela

@Entity // Define que a classe é uma Entidade gerenciada pelo JPA
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produto idProduto;

    @Column(name = "quantidadeProd")
    private Integer quantidadeProd;
}
