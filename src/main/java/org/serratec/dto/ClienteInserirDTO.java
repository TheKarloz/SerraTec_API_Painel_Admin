package org.serratec.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.serratec.model.Cliente;
import org.serratec.model.Endereco;

public class ClienteInserirDTO {
    
    @NotBlank
    private String nome;
   
    @NotBlank
    @CPF(message = "CPF Inválido")
    private String cpf;

    @NotBlank
    @Email(message = "E-mail inválido")
    private String email;
    
    @NotNull
    private Endereco endereco;
    
    public ClienteInserirDTO(){

    }

    public ClienteInserirDTO(Cliente cliente){
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.endereco = cliente.getEndereco();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
}
