package org.serratec.controller;

import java.net.URI;
import java.util.List;

import org.serratec.dto.PedidoSelectDTO;
import org.serratec.model.Pedido;
import org.serratec.service.PedidoService;
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
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoSelectDTO>> listar(){
        List<PedidoSelectDTO> pedidoDTOs = pedidoService.listar();
        return ResponseEntity.ok(pedidoDTOs);
    }

    @PostMapping
    public ResponseEntity<Object> inserir(@RequestBody PedidoSelectDTO pedidoDTO){
        PedidoSelectDTO pedDTO = pedidoService.inserir(pedidoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(pedDTO.getCliente())
                    .toUri();
        return ResponseEntity.created(uri).body(pedidoDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> atualizar(@RequestBody Pedido PedidoProduto, @PathVariable Long id){
            PedidoProduto = pedidoService.atualizar(PedidoProduto, id);
            return ResponseEntity.ok().body(PedidoProduto);
    }
}
