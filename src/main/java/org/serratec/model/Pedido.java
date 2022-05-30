package org.serratec.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Pedido {
    
    private Long id;
    private BigDecimal valorPedido;
    
    
    private Produto produto;



}
