package org.serratec.controller;

import java.net.URI;
import java.util.List;

import org.serratec.dto.ProdutoSelectDTO;
import org.serratec.model.Produto;
import org.serratec.dto.ProdutoInserirDTO;
import org.serratec.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoSelectDTO>> listarTodos(){
        List<ProdutoSelectDTO> produtos = produtoService.listar();
        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> inserir(@RequestBody ProdutoInserirDTO produtoInserirDTO){
        ProdutoSelectDTO produtoDTO = produtoService.inserir(produtoInserirDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cpf}")
                    .buildAndExpand(produtoDTO.getNome())
                    .toUri();
        return ResponseEntity.created(uri).body(produtoInserirDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> atualizar(@RequestBody Produto produto, @PathVariable Long id){
            produto = produtoService.atualizar(produto, id);
            return ResponseEntity.ok().body(produto);
    }
}
