package org.serratec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.serratec.dto.ClienteDTO;
import org.serratec.dto.ClienteInserirDTO;
import org.serratec.model.Cliente;
import org.serratec.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<ClienteDTO> listar(){
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
    }

    public ClienteDTO inserir(ClienteInserirDTO ClienteInserirDTO){

    }
    
}
