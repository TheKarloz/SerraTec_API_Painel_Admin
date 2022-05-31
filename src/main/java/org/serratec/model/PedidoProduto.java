package org.serratec.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

public class PedidoProduto {

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

}
