package org.serratec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.dto.ClienteSelectDTO;
import org.serratec.config.MailConfig;
import org.serratec.dto.ClienteInserirDTO;
import org.serratec.exception.ClienteException;
import org.serratec.exception.CpfException;
import org.serratec.exception.CustomNotFoundException;
import org.serratec.exception.EmailException;
import org.serratec.model.Cliente;
import org.serratec.repository.ClienteRepository;
import org.serratec.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private MailConfig mailConfig;


    public List<ClienteSelectDTO> listar(){
        if(clienteRepository.findAll().isEmpty()){
            throw new ClienteException("");
        }     
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(cliente -> new ClienteSelectDTO(cliente)).collect(Collectors.toList());
    }

    public ClienteSelectDTO inserir(ClienteInserirDTO clienteInserirDTO) throws EmailException, CpfException{
        if(clienteRepository.findByEmail(clienteInserirDTO.getEmail()) != null){
            throw new EmailException("Email já cadastrado!");
        }
        else if(clienteRepository.findByCpf(clienteInserirDTO.getCpf()) != null){
            throw new CpfException("Cpf já cadastrado!");
        }
        else if(clienteInserirDTO.getEndereco().getId() == null){
            throw new ClienteException("Campo endereço deve ser preenchido");
        }
        enderecoRepository.findById(clienteInserirDTO.getEndereco().getId())
            .orElseThrow(() -> new ClienteException("Endereco com id '" + clienteInserirDTO.getEndereco().getId() 
            + "' não foi encontrado"));

        Cliente cliente = new Cliente();

        cliente.setNome(clienteInserirDTO.getNome());
        cliente.setCpf(clienteInserirDTO.getCpf());
        cliente.setEmail(clienteInserirDTO.getEmail());
        cliente.setEndereco(clienteInserirDTO.getEndereco());
        cliente = clienteRepository.save(cliente);
        mailConfig.enviarEmail(cliente.getEmail(), "Cadastro de cliente!", cliente.getNome(), cliente.toString());

        return new ClienteSelectDTO(cliente);
    }

    public Cliente atualizar(Cliente cliente, Long id) throws EmailException, CpfException{
        if(clienteRepository.existsById(id)){         
            cliente.setId(id);
            clienteRepository.save(cliente);
        }       
        if(clienteRepository.findByEmail(cliente.getEmail()) != null){
            throw new EmailException("Email já cadastrado!");
        }
        else if(clienteRepository.findByCpf(cliente.getCpf()) != null){
            throw new CpfException("Cpf já cadastrado!");
        }
        else if(cliente.getEndereco().getId() == null){
            throw new ClienteException("Campo endereço deve ser preenchido");
        }
        enderecoRepository.findById(cliente.getEndereco().getId())
            .orElseThrow(() -> new ClienteException("Endereco com id '" + cliente.getEndereco().getId() 
            + "' não existe"));       
       
	 	throw new CustomNotFoundException("Cliente com id '" + id + "' não foi encontrada");
    }

    public void deletar(Long id){
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        }else{
        throw new CustomNotFoundException("Cliente com id '"+id+"' não encontrado");
        }
    }

    
}
