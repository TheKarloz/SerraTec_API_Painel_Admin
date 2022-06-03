package org.serratec.service;

import org.serratec.dto.PedidoSelectDTO;
import org.serratec.model.Pedido;
import org.serratec.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoSelectDTO> listar(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(ped -> new PedidoSelectDTO(ped)).collect(Collectors.toList());
    }

    public PedidoSelectDTO inserir(PedidoSelectDTO pedidoDTO){
        Pedido pedido = new Pedido();
        pedido.setCliente(pedidoDTO.getCliente());
        pedido.setStatus(pedidoDTO.getStatus());
        pedido = pedidoRepository.save(pedido);

        return new PedidoSelectDTO(pedido);
    }
}