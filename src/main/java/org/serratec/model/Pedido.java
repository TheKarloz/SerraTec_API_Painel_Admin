package org.serratec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.serratec.enums.EStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pedido{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id;
   
    private EStatus status;
    
    //@JsonManagedReference
    //@ManyToOne
    //@JoinColumn(name = "id_cliente")
    @OneToOne
    private Cliente cliente;

    // @ManyToMany
    // @JoinTable(name = "pedido_produto",
    // inverseJoinColumns = @JoinColumn(name = "id_produto"),
    // joinColumns = @JoinColumn(name = "id_pedido"))
    // private List<Pedido> pedidos;

    @JsonIgnore
    @OneToMany(mappedBy = "pedido")
    private List<PedidoProduto> pedidoProduto;

    
    public Long getId() {
        return id;
    }

    public void setId(Long numeroPedido) {
        this.id = numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getNumeroPedido() {
        return id;
    }

    public void setNumeroPedido(Long numeroPedido) {
        this.id = numeroPedido;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

}
