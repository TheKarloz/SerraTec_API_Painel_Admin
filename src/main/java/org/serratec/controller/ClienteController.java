package org.serratec.controller;

import java.net.URI;
import java.util.List;

import org.serratec.dto.ClienteDTO;
import org.serratec.dto.ClienteInserirDTO;
import org.serratec.exception.CpfException;
import org.serratec.exception.EmailException;
import org.serratec.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarTodos(){
        List<ClienteDTO> clientes = clienteService.listar();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> inserir(@RequestBody ClienteInserirDTO clienteInserirDTO){
        try {
            ClienteDTO clienteDTO = clienteService.inserir(clienteInserirDTO);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cpf}")
                        .buildAndExpand(clienteDTO.getCpf())
                        .toUri();
            return ResponseEntity.created(uri).body(clienteInserirDTO);

        } catch (EmailException e){
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        } catch (CpfException e){
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
}
