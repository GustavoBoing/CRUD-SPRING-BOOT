package com.Boing.cadastro_usuario.business;

import com.Boing.cadastro_usuario.infrastructure.entities.Produto;
import com.Boing.cadastro_usuario.infrastructure.entities.Usuario;
import com.Boing.cadastro_usuario.infrastructure.entities.Venda;
import com.Boing.cadastro_usuario.infrastructure.repositories.ProdutoRepository;
import com.Boing.cadastro_usuario.infrastructure.repositories.UsuarioRepository;
import com.Boing.cadastro_usuario.infrastructure.repositories.VendaRepository;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final ProdutoRepository produtoRepository;
    private final UsuarioRepository usuarioRepository;

    public VendaService(VendaRepository vendaRepository, ProdutoRepository produtoRepository, UsuarioRepository usuarioRepository) {
        this.vendaRepository = vendaRepository;
        this.produtoRepository = produtoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Venda findVendaById(Integer id){
        return vendaRepository.findVendaById(id).orElseThrow(
                () -> new RuntimeException("Id invalido")
        );
    }

    //metodo deletar
    public void deleteVendaById(Integer id){
        vendaRepository.deleteVendaById(id);
    }

    //metodo inserir
    public void insertVenda(Venda venda){
        Usuario usuario = usuarioRepository.getReferenceById(venda.getIdUsuario().getId());
        Produto produto = produtoRepository.getReferenceById(venda.getIdProduto().getId());
        venda.setIdUsuario(usuario);
        venda.setIdProduto(produto);
        vendaRepository.saveAndFlush(venda);
    }

    //metodo update
    public void updateVendaById(Integer id, Venda dataVenda){
        Venda dadosAtuais = vendaRepository.findVendaById(id).orElseThrow(
                () -> new RuntimeException("id insert is invalided")
        );
        Venda dadosAtualizados = Venda.builder()//O builder cria um "construtor" para que eu possa inserir os parametros do tipo Venda(ou qualquer outro tipo de clase)
                .id(dadosAtuais.getId())
                .idProduto(dataVenda != null && dataVenda.getIdProduto() != null ? dataVenda.getIdProduto() : dadosAtuais.getIdProduto())
                .idUsuario(dataVenda != null && dataVenda.getIdUsuario() != null ? dataVenda.getIdUsuario() : dadosAtuais.getIdUsuario())
                .quantidadeProd(dataVenda != null && dataVenda.getQuantidadeProd() != null ? dataVenda.getQuantidadeProd() : dadosAtuais.getQuantidadeProd())
                .build();
        vendaRepository.saveAndFlush(dadosAtualizados);
    }
}
