package com.Boing.cadastro_usuario.controller;

import com.Boing.cadastro_usuario.business.ProdutoService;
import com.Boing.cadastro_usuario.infrastructure.entities.Produto;
import jdk.javadoc.doclet.Reporter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService productService;

    @PostMapping
    public ResponseEntity<Void> saveProduct(@RequestBody Produto product){
        productService.saveProduct(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Produto> getProduct(@RequestParam String nome){
        return ResponseEntity.ok(productService.findProductByNome(nome));
    }

    @PutMapping
    public ResponseEntity<Void> putProduct(@RequestParam String nome, @RequestBody Produto product){
        productService.updateProductByNome(nome, product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(@RequestParam String nome){
        productService.deleteProductByNome(nome);
        return ResponseEntity.ok().build();
    }
}
