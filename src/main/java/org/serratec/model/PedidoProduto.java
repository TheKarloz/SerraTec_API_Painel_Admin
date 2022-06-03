package org.serratec.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pedido_produto")
public class PedidoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido_produto")
    @JsonIgnore
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column(name = "quantidade_produto")
    private Long quantidadeProduto;
    
    @Column(name = "perc_desconto")
    private double percDesconto;
 
    // @Override
    // public String toString() {
        
    // }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public double getPercDesconto() {
        return percDesconto;
    }
    public void setPercDesconto(double percDesconto) {
        this.percDesconto = percDesconto;
    }
    public Long getQuantidadeProduto() {
        return quantidadeProduto;
    }
    public void setQuantidadeProduto(Long quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

         
}
