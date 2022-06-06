package org.serratec.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.dto.ClienteSelectDTO;
import org.serratec.dto.ClienteInserirDTO;
import org.serratec.exception.ClienteException;
import org.serratec.exception.CpfException;
import org.serratec.exception.CustomNotFoundException;
import org.serratec.exception.EmailException;
import org.serratec.model.Cliente;
import org.serratec.service.ClienteService;
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
    public ResponseEntity<Object> inserir(@Valid @RequestBody ClienteInserirDTO clienteInserirDTO){
        try {
            ClienteSelectDTO clienteDTO = clienteService.inserir(clienteInserirDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);
        } catch (EmailException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (CpfException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch(ClienteException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> atualizar(@Valid @RequestBody Cliente cliente, @PathVariable Long id) {
        try{
            cliente = clienteService.atualizar(cliente, id);
            return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
        }catch (EmailException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (CpfException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch(ClienteException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch(CustomNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id){
        try {
            clienteService.deletar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
        } catch (CustomNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
