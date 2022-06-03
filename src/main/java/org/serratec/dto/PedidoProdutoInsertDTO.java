package org.serratec.dto;

import org.serratec.model.Pedido;
import org.serratec.model.PedidoProduto;
import org.serratec.model.Produto;


public class PedidoProdutoInsertDTO {
    
    private Pedido pedido;
    private Produto produto;
    private Long quantidadeProduto;
    private double percDesconto;

    public PedidoProdutoInsertDTO(PedidoProduto pedidoProduto) {
        this.pedido = pedidoProduto.getPedido();
        this.produto = pedidoProduto.getProduto();
        this.quantidadeProduto = pedidoProduto.getQuantidadeProduto();
        this.percDesconto = pedidoProduto.getPercDesconto();
    }

    public PedidoProdutoInsertDTO(){
        
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

    public Long getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Long quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getPercDesconto() {
        return percDesconto;
    }

    public void setPercDesconto(double percDesconto) {
        this.percDesconto = percDesconto;
    }
}
