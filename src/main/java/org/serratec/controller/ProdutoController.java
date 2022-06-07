package org.serratec.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.dto.ProdutoSelectDTO;
import org.serratec.exception.CustomNoContentException;
import org.serratec.exception.CustomNotFoundException;
import org.serratec.exception.ProdutoException;
import org.serratec.model.Produto;
import org.serratec.dto.ProdutoInserirDTO;
import org.serratec.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Object> listarTodos() throws CustomNoContentException{
        
        List<ProdutoSelectDTO> produtos = produtoService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @PostMapping
    public ResponseEntity<Object> inserir(@Valid @RequestBody ProdutoInserirDTO produtoInserirDTO)
    throws ProdutoException{
        
        ProdutoSelectDTO produtoDTO = produtoService.inserir(produtoInserirDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoDTO);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@Valid @RequestBody Produto produto, @PathVariable Long id)
    throws ProdutoException, CustomNotFoundException{
        
        produto = produtoService.atualizar(produto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@Valid @PathVariable Long id) throws CustomNotFoundException{
        
        produtoService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
    }

}
