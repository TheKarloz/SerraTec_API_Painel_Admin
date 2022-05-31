package org.serratec.dto;

import java.util.List;

import org.serratec.model.Cliente;
import org.serratec.model.Pedido;

public class ClienteDTO {

    private String nome;
    private String cpf;
    private String email;
    private Long cep;
    private List<Pedido> pedidos;
    
    public ClienteDTO(){

    }

    public ClienteDTO(Cliente cliente){
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.cep = cliente.getCep();
        this.pedidos = cliente.getPedidos();
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
    public Long getCep() {
        return cep;
    }
    public void setCep(Long cep) {
        this.cep = cep;
    }
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    

    
}
