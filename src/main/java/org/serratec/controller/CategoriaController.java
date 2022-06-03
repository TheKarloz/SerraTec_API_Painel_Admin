package org.serratec.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.serratec.model.Categoria;
import org.serratec.repository.CategoriaRepository;
import org.serratec.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> listar(){
        List<Categoria> categorias = categoriaService.listar();
        return ResponseEntity.ok(categorias);
    }

    @PostMapping
    public ResponseEntity<Categoria> inserir(@RequestBody Categoria categoria){
        categoria = categoriaService.inserir(categoria);
        return ResponseEntity.ok().body(categoria);
    }

    
}
