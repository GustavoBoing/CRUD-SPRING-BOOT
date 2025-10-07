package com.Boing.cadastro_usuario.business;

import com.Boing.cadastro_usuario.infrastructure.entities.Produto;
import com.Boing.cadastro_usuario.infrastructure.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void saveProduct(Produto produto){
        repository.saveAndFlush(produto);
    }

    public Produto findProductByNome(String nome){
        return repository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Nome do produto invalido!!")
        );
    }

    public void deleteProductByNome(String nome){
        repository.deleteByNome(nome);
    }

    public void updateProductByNome(String nome, Produto product){
            Produto productEntity = repository.findByNome(nome).orElseThrow(
                    () -> new RuntimeException("Nome do produto invalido!!!")
            );
            Produto updateProduct = Produto.builder()
                    .nome(productEntity.getNome())
                    .valor(product != null ? product.getValor() : productEntity.getValor())
                    .quantidade(product != null ? product.getQuantidade() : productEntity.getQuantidade())
                    .id(productEntity.getId())
                    .build();
            repository.saveAndFlush(updateProduct);
            /*
            Produto productEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("nome do produto invalido")
            );
            */
    }
}
