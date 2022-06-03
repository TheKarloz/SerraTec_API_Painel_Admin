package org.serratec.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.serratec.dto.ClienteSelectDTO;
import org.serratec.dto.ClienteInserirDTO;
import org.serratec.exception.CpfException;
import org.serratec.exception.EmailException;
import org.serratec.model.Cliente;
import org.serratec.service.ClienteService;
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
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteSelectDTO>> listarTodos(){
        List<ClienteSelectDTO> clientes = clienteService.listar();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> inserir(@Valid @RequestBody ClienteInserirDTO clienteInserirDTO){
        try {
            ClienteSelectDTO clienteDTO = clienteService.inserir(clienteInserirDTO);
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

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> atualizar(@RequestBody Cliente cliente, @PathVariable Long id){
        try{
            cliente = clienteService.atualizar(cliente, id);
            return ResponseEntity.ok().body(cliente);
        }catch (EmailException e){
             return ResponseEntity.unprocessableEntity().body(e.getMessage());
        } catch (CpfException e){
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

}
