package org.serratec.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.exception.CategoriaException;
import org.serratec.model.Categoria;
import org.serratec.service.CategoriaService;
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

// import io.swagger.annotations.ApiOperation;
// import io.swagger.annotations.ApiResponse;
// import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<Object> listar(){
        try {
            List<Categoria> categorias = categoriaService.listar();
            return ResponseEntity.ok(categorias);
        } catch (CategoriaException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id){
        try{
            Categoria categoria = categoriaService.buscarPorId(id);
            return ResponseEntity.ok(categoria);
        }catch(CategoriaException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{nomeCategoria}")
    public ResponseEntity<Object> buscarPorNome(@PathVariable String nomeCategoria){
        try{
            Categoria categoria = categoriaService.buscarPorNome(nomeCategoria.toUpperCase());
            return ResponseEntity.ok(categoria);
        }catch(CategoriaException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> inserir(@Valid @RequestBody Categoria categoria){
        try{
            categoria = categoriaService.inserir(categoria);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
        } catch(CategoriaException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@Valid @RequestBody Categoria categoria, @PathVariable Long id){
        try{
            categoria = categoriaService.atualizar(categoria, id);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
        }
        catch(CategoriaException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id){
        try {
            categoriaService.deletar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
        } catch (CategoriaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
