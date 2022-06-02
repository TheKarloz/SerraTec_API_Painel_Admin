package org.serratec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.serratec.enums.EStatus;

@Entity
public class Pedido{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long numeroPedido;
   
    private EStatus status;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    // @ManyToMany
    // @JoinTable(name = "pedido_produto",
    // inverseJoinColumns = @JoinColumn(name = "id_produto"),
    // joinColumns = @JoinColumn(name = "id_pedido"))
    // private List<Pedido> pedidos;

    @OneToMany(mappedBy = "pedido")
    private List<PedidoProduto> pedidoProduto;

    
    public Long getId() {
        return numeroPedido;
    }

    public void setId(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

}
