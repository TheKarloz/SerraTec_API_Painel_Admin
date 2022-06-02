package org.serratec.service;

import org.serratec.dto.PedidoDTO;
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

    public List<PedidoDTO> listar(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(ped -> new PedidoDTO(ped)).collect(Collectors.toList());
    }

    public PedidoDTO inserir(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();
        pedido.setCliente(pedidoDTO.getCliente());
        pedido.setStatus(pedidoDTO.getStatus());
        pedido = pedidoRepository.save(pedido);

        return new PedidoDTO(pedido);
    }
}