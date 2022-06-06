package org.serratec.service;

import org.serratec.dto.PedidoDTO;
import org.serratec.exception.ClienteException;
import org.serratec.exception.CustomNotFoundException;
import org.serratec.exception.PedidoException;
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
        if(pedidoRepository.findAll().isEmpty()){
            throw new ClienteException("");
        }else{
            List<Pedido> pedidos = pedidoRepository.findAll();
            return pedidos.stream().map(ped -> new PedidoDTO(ped)).collect(Collectors.toList());
        }
    }

    public PedidoDTO inserir(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();
        pedido.setCliente(pedidoDTO.getCliente());
        pedido.setStatus(pedidoDTO.getStatus());
        if(pedidoDTO.getCliente().getId() == null){
            throw new PedidoException("Você deve informar o id do cliente"
            + " o qual deseja relacionar com o pedido");
        }

        pedido = pedidoRepository.save(pedido);

        return new PedidoDTO(pedido);
    }

    public Pedido atualizar(Pedido pedido, Long id){
        if(pedidoRepository.existsById(id)){
            pedido.setId(id);
            if(pedido.getCliente().getId() == null){
                throw new PedidoException("Você deve informar o id do cliente"
            + " o qual deseja relacionar com o pedido");
            }
            return pedidoRepository.save(pedido);
        }   
		throw new CustomNotFoundException("Pedido com id '" + id + "' não foi encontrado");
    }

    public void deletar(Long id){
        if(pedidoRepository.existsById(id)){
            pedidoRepository.deleteById(id);
        }else{
            throw new CustomNotFoundException("Pedido com id '"+id+"' não encontrado");
        }
    }

}