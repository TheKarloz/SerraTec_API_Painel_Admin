package org.serratec.dto;

import org.serratec.enums.EStatus;
import org.serratec.model.Cliente;
import org.serratec.model.Pedido;

public class PedidoDTO {

    private EStatus status;
    private Cliente cliente;
    

    public PedidoDTO(Pedido pedido) {
        this.status = pedido.getStatus();
        this.cliente = pedido.getCliente();
    }
    
    public EStatus getStatus() {
        return status;
    }
    public void setStatus(EStatus status) {
        this.status = status;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
