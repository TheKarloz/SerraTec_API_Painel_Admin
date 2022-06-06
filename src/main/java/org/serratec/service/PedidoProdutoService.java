package org.serratec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.dto.PedidoProdutoInserirDTO;
import org.serratec.dto.PedidoProdutoSelectDTO;
import org.serratec.exception.CustomNotFoundException;
//import org.serratec.exception.PedidoProdutoException;
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

    public PedidoProdutoInserirDTO inserir(PedidoProdutoInserirDTO pedidoProdutoDTO){
        PedidoProduto pedidoProduto = new PedidoProduto();
        
        pedidoProduto.setPedido(pedidoProdutoDTO.getPedido());
        pedidoProduto.setProduto(pedidoProdutoDTO.getProduto());
        pedidoProduto.setQuantidadeProduto(pedidoProdutoDTO.getQuantidadeProduto());
        pedidoProduto.setPercDesconto(pedidoProdutoDTO.getPercDesconto());
        pedidoProduto = pedidoProdutoRepository.save(pedidoProduto);
        
        return new PedidoProdutoInserirDTO(pedidoProduto);
    }

    public PedidoProduto atualizar(PedidoProduto pedidoProduto, Long id){
        if(pedidoProdutoRepository.existsById(id)){
            pedidoProduto.setId(id);
            return pedidoProdutoRepository.save(pedidoProduto);
        }   
		throw new CustomNotFoundException("Pedido com id '" + id + "' não foi encontrado");
    }

    public void deletar(Long id){
        if(pedidoProdutoRepository.existsById(id)){
            pedidoProdutoRepository.deleteById(id);
        }else{
            throw new CustomNotFoundException("Pedido com id '"+id+"' não encontrado");
        }
    }

}
