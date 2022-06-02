package org.serratec.controller;

import java.net.URI;
import java.util.List;

import org.serratec.dto.PedidoProdutoDTO;
import org.serratec.service.PedidoProdutoService;
import org.serratec.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoProdutoService pedidoProdutoService;

    @GetMapping
    public ResponseEntity<List<PedidoProdutoDTO>> listar(){
        List<PedidoProdutoDTO> pedidoProdutosDTO = pedidoProdutoService.listar();
        return ResponseEntity.ok(pedidoProdutosDTO);
    }

    @PostMapping
    public ResponseEntity<Object> inserir(@RequestBody PedidoProdutoDTO pedidoProdutoDTO){
        return ResponseEntity.ok(pedidoProdutoDTO);
    }



        
}
