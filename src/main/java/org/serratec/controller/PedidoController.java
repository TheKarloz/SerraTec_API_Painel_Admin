package org.serratec.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.dto.PedidoDTO;
import org.serratec.exception.CustomNoContentException;
import org.serratec.exception.CustomNotFoundException;
import org.serratec.exception.EnumValidationException;
import org.serratec.exception.PedidoException;
import org.serratec.exception.ProdutoException;
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
    public ResponseEntity<List<PedidoDTO>> listar() throws CustomNoContentException{
        List<PedidoDTO> pedidoDTOs = pedidoService.listar();
        return ResponseEntity.ok(pedidoDTOs);
    }

    @PostMapping
    public ResponseEntity<Object> inserir(@Valid @RequestBody PedidoDTO pedidoDTO)
    throws EnumValidationException, PedidoException{
        
        PedidoDTO pedDTO = pedidoService.inserir(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@Valid @RequestBody Pedido PedidoProduto, @PathVariable Long id)
    throws ProdutoException, CustomNotFoundException{
        
        PedidoProduto = pedidoService.atualizar(PedidoProduto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(PedidoProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@Valid @PathVariable Long id) throws CustomNotFoundException{
        pedidoService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
    }


}
