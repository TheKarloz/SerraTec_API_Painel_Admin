package org.serratec.dto;

import org.serratec.enums.EStatus;
import org.serratec.model.Cliente;
import org.serratec.model.Pedido;

public class PedidoSelectDTO {

    private Long id;
    private Cliente cliente;
    private EStatus status; 

    public PedidoSelectDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.status = pedido.getStatus();
        this.cliente = pedido.getCliente();
    }

    public PedidoSelectDTO(){
        
    }
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
