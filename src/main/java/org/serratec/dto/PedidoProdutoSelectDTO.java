package org.serratec.dto;

import java.math.BigDecimal;

import org.serratec.model.Pedido;
import org.serratec.model.PedidoProduto;
import org.serratec.model.Produto;

public class PedidoProdutoSelectDTO{

    private Pedido pedido;
    private Produto produto;
    private BigDecimal valorTotal;
    private int quantidadeProduto;

    public PedidoProdutoSelectDTO(PedidoProduto pedidoProduto) {
        this.pedido = pedidoProduto.getPedido();
        this.produto = pedidoProduto.getProduto();
        this.valorTotal = pedidoProduto.getValorVenda();
        this.quantidadeProduto = pedidoProduto.getQuantidadeProduto();
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

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

}
