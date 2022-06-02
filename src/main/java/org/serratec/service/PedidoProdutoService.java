package org.serratec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.dto.PedidoProdutoDTO;
import org.serratec.model.PedidoProduto;
import org.serratec.repository.PedidoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoProdutoService {
    
    @Autowired
    private PedidoProdutoRepository pedidoProdutoRepository;

    public List<PedidoProdutoDTO> listar(){
        List<PedidoProduto> pedidoProdutos = pedidoProdutoRepository.findAll();
        return pedidoProdutos.stream().map(pedProd -> new PedidoProdutoDTO(pedProd)).collect(Collectors.toList());
    }

    public PedidoProdutoDTO inserir(PedidoProdutoDTO pedidoProdutoDTO){
        PedidoProduto pedidoProduto = new PedidoProduto();
        pedidoProduto.setPedido(pedidoProdutoDTO.getPedido());
        pedidoProduto.setProduto(pedidoProdutoDTO.getProduto());
        pedidoProduto.setQuantidadeProduto(pedidoProdutoDTO.getQuantidadeProduto());
        pedidoProduto.setValorTotal(pedidoProdutoDTO.getValorTotal());
        pedidoProduto = pedidoProdutoRepository.save(pedidoProduto);
        
        return new PedidoProdutoDTO(pedidoProduto);

    }

}
