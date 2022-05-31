package org.serratec.dto;

import java.math.BigDecimal;

import org.serratec.model.Categoria;

public class ProdutoInserirDTO {
    
    private String nome;
    private BigDecimal valorUnitario;
    private Categoria categoria;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
