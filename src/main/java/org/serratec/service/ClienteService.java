package org.serratec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.dto.ClienteDTO;
import org.serratec.dto.ClienteInserirDTO;
import org.serratec.exception.CpfException;
import org.serratec.exception.EmailException;
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

    public ClienteDTO inserir(ClienteInserirDTO clienteInserirDTO) throws EmailException, CpfException{
        if(clienteRepository.findByEmail(clienteInserirDTO.getEmail()) != null){
            throw new EmailException("Email já cadastrado!");
        }
        else if(clienteRepository.findByCpf(clienteInserirDTO.getCpf()) != null){
            throw new CpfException("Cpf já cadastrado!");
        }
        Cliente cliente = new Cliente();

        cliente.setNome(clienteInserirDTO.getNome());
        cliente.setCpf(clienteInserirDTO.getCpf());
        cliente.setEmail(clienteInserirDTO.getEmail());
        cliente.setCep(clienteInserirDTO.getCep());
        cliente = clienteRepository.save(cliente);

        return new ClienteDTO(cliente);
    }
    
}
