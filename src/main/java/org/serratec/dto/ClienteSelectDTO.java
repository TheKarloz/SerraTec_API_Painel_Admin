package org.serratec.dto;

import org.serratec.model.Cliente;

public class ClienteSelectDTO {

    private String nome;
    private String cpf;
    private String email;
    private Long cep;
    
    //private List<Pedido> pedidos;
    
    public ClienteSelectDTO(){

    }

    public ClienteSelectDTO(Cliente cliente){
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.cep = cliente.getCep();
        //this.pedidos = cliente.getPedidos();
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
    // public List<Pedido> getPedidos() {
    //     return pedidos;
    // }
    // public void setPedidos(List<Pedido> pedidos) {
    //     this.pedidos = pedidos;
    // }

    

    
}
