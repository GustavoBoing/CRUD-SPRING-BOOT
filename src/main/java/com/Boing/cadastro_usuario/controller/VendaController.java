package com.Boing.cadastro_usuario.controller;

import com.Boing.cadastro_usuario.business.VendaService;
import com.Boing.cadastro_usuario.infrastructure.entities.Produto;
import com.Boing.cadastro_usuario.infrastructure.entities.Usuario;
import com.Boing.cadastro_usuario.infrastructure.entities.Venda;
import com.Boing.cadastro_usuario.infrastructure.repositories.ProdutoRepository;
import com.Boing.cadastro_usuario.infrastructure.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // controlador de metodos REST
@RequestMapping ("/venda")
@RequiredArgsConstructor

public class VendaController {

    private final VendaService vendaService;
    private final UsuarioRepository usuarioRepository;
    private final ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<Venda> buscarVenda(@RequestParam Integer id){
        return ResponseEntity.ok(vendaService.findVendaById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveVenda(@RequestBody Venda venda){
        vendaService.insertVenda(venda);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteVenda(@RequestParam Integer id){
        vendaService.deleteVendaById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarVenda(@RequestParam Integer id, @RequestBody Venda venda) {
        vendaService.updateVendaById(id, venda);
        return ResponseEntity.ok().build();
    }
}
