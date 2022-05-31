package org.serratec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.dto.ProdutoDTO;
import org.serratec.dto.ProdutoInserirDTO;
import org.serratec.model.Produto;
import org.serratec.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> listar(){
        List<Produto> produtos = produtoRepository.findAll();
              
        return produtos.stream().map(produto -> new ProdutoDTO(produto)).collect(Collectors.toList());
    }
    
    public ProdutoDTO inserir(ProdutoInserirDTO produtoInserirDTO){
        Produto produto = new Produto();
        produto.setNome(produtoInserirDTO.getNome());
        produto.setValorUnitario(produtoInserirDTO.getValorUnitario());
        produto.setCategoria(produtoInserirDTO.getCategoria());
        produto = produtoRepository.save(produto);

        return new ProdutoDTO(produto);
    }

    
}
