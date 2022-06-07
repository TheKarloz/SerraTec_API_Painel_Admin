package org.serratec.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.dto.PedidoDTO;
import org.serratec.exception.CustomNotFoundException;
import org.serratec.exception.EnumValidationException;
import org.serratec.exception.PedidoException;
import org.serratec.model.Pedido;
import org.serratec.service.PedidoService;
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
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listar(){
        List<PedidoDTO> pedidoDTOs = pedidoService.listar();
        return ResponseEntity.ok(pedidoDTOs);
    }

    @PostMapping
    public ResponseEntity<Object> inserir(@Valid @RequestBody PedidoDTO pedidoDTO){
        try{
            PedidoDTO pedDTO = pedidoService.inserir(pedidoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(pedDTO);
        }catch(EnumValidationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch(PedidoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@Valid @RequestBody Pedido PedidoProduto, @PathVariable Long id){
        try{
            PedidoProduto = pedidoService.atualizar(PedidoProduto, id);
            return ResponseEntity.status(HttpStatus.CREATED).body(PedidoProduto);
        }catch(PedidoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        catch(CustomNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@Valid @PathVariable Long id){
        try {
            pedidoService.deletar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
        }
        catch (CustomNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
