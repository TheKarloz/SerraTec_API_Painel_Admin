package org.serratec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;



@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nome_cliente", nullable = false)
    private String nome;
    
    @CPF(message = "CPF Inválido")
    @Column(name = "cpf", nullable = false)
    private String cpf;
    
    @Email(message = "E-mail inválido")
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "cep", nullable = false, length = 8)
    private Long cep;


    @Override
    public String toString() {
        return
        "\nemail: " + email + 
        "\nnome: " + nome ;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    // public Pedido getPedidos() {
    //     return pedidos;
    // }
    // public void setPedidos(Pedido pedidos) {
    //     this.pedidos = pedidos;
    // }
    

}
