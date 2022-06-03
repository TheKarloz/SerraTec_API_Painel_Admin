package org.serratec.controller;

import java.net.URI;
import java.util.List;

import org.serratec.dto.PedidoProdutoInsertDTO;
import org.serratec.dto.PedidoProdutoSelectDTO;
import org.serratec.service.PedidoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/pedidos_itens")
public class PedidoProdutoController {

    @Autowired
    private PedidoProdutoService pedidoProdutoService;

    @GetMapping
    public ResponseEntity<List<PedidoProdutoSelectDTO>> listar(){
        List<PedidoProdutoSelectDTO> pedidoProdutosDTO = pedidoProdutoService.listar();
        return ResponseEntity.ok(pedidoProdutosDTO);
    }

    @PostMapping
    public ResponseEntity<Object> inserir(@RequestBody PedidoProdutoInsertDTO pedidoProdutoDTO){
        PedidoProdutoInsertDTO pedProdDTO = pedidoProdutoService.inserir(pedidoProdutoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{pedido}")
                    .buildAndExpand(pedProdDTO.getPedido())
                    .toUri();
        
        return ResponseEntity.created(uri).body(pedidoProdutoDTO);
    }



        
}
