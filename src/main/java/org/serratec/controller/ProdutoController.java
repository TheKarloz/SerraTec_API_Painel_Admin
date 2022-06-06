package org.serratec.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.dto.ProdutoSelectDTO;
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
    public ResponseEntity<Object> listarTodos(){
        try{
            List<ProdutoSelectDTO> produtos = produtoService.listar();
            return ResponseEntity.status(HttpStatus.OK).body(produtos);
        }
        catch(ProdutoException e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> inserir(@Valid @RequestBody ProdutoInserirDTO produtoInserirDTO){
        try{
            ProdutoSelectDTO produtoDTO = produtoService.inserir(produtoInserirDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(produtoDTO);
        }catch(ProdutoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@Valid @RequestBody Produto produto, @PathVariable Long id){
        try{ 
            produto = produtoService.atualizar(produto, id);
            return ResponseEntity.status(HttpStatus.CREATED).body(produto);
        }
        catch(ProdutoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        catch(CustomNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@Valid @PathVariable Long id){
        try {
            produtoService.deletar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
        } catch (CustomNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
