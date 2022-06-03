package org.serratec.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.serratec.config.MailConfig;
import org.serratec.dto.PedidoProdutoInsertDTO;
import org.serratec.dto.PedidoProdutoSelectDTO;
import org.serratec.model.PedidoProduto;
import org.serratec.repository.PedidoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoProdutoService {
    
    @Autowired
    private PedidoProdutoRepository pedidoProdutoRepository;

    public List<PedidoProdutoSelectDTO> listar(){
        List<PedidoProduto> pedidoProdutos = pedidoProdutoRepository.findAll();
        return pedidoProdutos.stream().map(pedProd -> new PedidoProdutoSelectDTO(pedProd))
        .collect(Collectors.toList());
    }

    public PedidoProdutoInsertDTO inserir(PedidoProdutoInsertDTO pedidoProdutoDTO){
        PedidoProduto pedidoProduto = new PedidoProduto();
        
        pedidoProduto.setPedido(pedidoProdutoDTO.getPedido());
        pedidoProduto.setProduto(pedidoProdutoDTO.getProduto());
        pedidoProduto.setQuantidadeProduto(pedidoProdutoDTO.getQuantidadeProduto());
        pedidoProduto.setPercDesconto(pedidoProdutoDTO.getPercDesconto());
        pedidoProduto = pedidoProdutoRepository.save(pedidoProduto);
        
        return new PedidoProdutoInsertDTO(pedidoProduto);
    }

    public PedidoProduto atualizar(PedidoProduto pedidoProduto, Long id){
        if(pedidoProdutoRepository.existsById(id)){
            pedidoProduto.setId(id);
            return pedidoProdutoRepository.save(pedidoProduto);
        }   
		return null;
    }

}
