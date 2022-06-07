package org.serratec.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.dto.ClienteSelectDTO;
import org.serratec.dto.ClienteInserirDTO;
import org.serratec.exception.CpfException;
import org.serratec.exception.CustomNoContentException;
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
    public ResponseEntity<Object> listarTodos() throws CustomNoContentException{
        List<ClienteSelectDTO> clientes = clienteService.listar();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Object> buscarPorCpf(@PathVariable String cpf)throws CustomNotFoundException{
        
        Cliente cliente = clienteService.buscarPorCpf(cpf);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Object> inserir(@Valid @RequestBody ClienteInserirDTO clienteInserirDTO)
    throws EmailException, CpfException, CustomNotFoundException{
        
        ClienteSelectDTO clienteDTO = clienteService.inserir(clienteInserirDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Object> atualizar(@Valid @RequestBody ClienteInserirDTO clienteInserirDTO, 
    @PathVariable String cpf) throws CustomNotFoundException{
        
        ClienteSelectDTO clienteDTO = clienteService.atualizar(clienteInserirDTO, cpf);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Object> deletar(@PathVariable String cpf) throws CustomNotFoundException{
        clienteService.deletar(cpf);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(cpf);
    }

}
