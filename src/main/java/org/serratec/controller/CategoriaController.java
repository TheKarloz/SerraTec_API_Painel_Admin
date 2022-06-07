package org.serratec.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.exception.CategoriaException;
import org.serratec.exception.CustomNoContentException;
import org.serratec.exception.CustomNotFoundException;
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
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public ResponseEntity<Object> listar() throws CustomNoContentException{
        List<Categoria> categorias = categoriaService.listar();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id) throws CustomNotFoundException{
        Categoria categoria = categoriaService.buscarPorId(id);
        return ResponseEntity.ok(categoria);

    }

    @GetMapping("/{nomeCategoria}")
    public ResponseEntity<Object> buscarPorNome(@PathVariable String nomeCategoria)throws CustomNotFoundException{
        Categoria categoria = categoriaService.buscarPorNome(nomeCategoria.toUpperCase());
        return ResponseEntity.ok(categoria);

    }

    @PostMapping
    public ResponseEntity<Object> inserir(@Valid @RequestBody Categoria categoria)throws CategoriaException{
        categoria = categoriaService.inserir(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@Valid @RequestBody Categoria categoria, @PathVariable Long id)
    throws CustomNotFoundException{
        
        categoria = categoriaService.atualizar(categoria, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deletar(@PathVariable Long id) throws CustomNotFoundException{
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
