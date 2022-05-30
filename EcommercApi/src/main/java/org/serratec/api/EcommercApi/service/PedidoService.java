package org.serratec.api.EcommercApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.api.EcommercApi.DTO.PedidoDTO;
import org.serratec.api.EcommercApi.exception.PedidoException;
import org.serratec.api.EcommercApi.model.Cliente;
import org.serratec.api.EcommercApi.model.Pedido;
import org.serratec.api.EcommercApi.model.Produto;
import org.serratec.api.EcommercApi.repository.ClienteRepository;
import org.serratec.api.EcommercApi.repository.PedidoRepository;
import org.serratec.api.EcommercApi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	
	public Pedido toModel(Pedido pedido, PedidoDTO pedidoDTO) {
		pedido.setValorTotal(pedidoDTO.getValorTotal());

		if(pedidoDTO.getIdCliente()!=null) {
			Optional<Cliente> cliente = clienteRepository.findById(pedidoDTO.getIdCliente());
			if(cliente.isPresent()) {
				pedido.setCliente(clienteRepository.findById(pedidoDTO.getIdCliente()).get());
			}
		}
		
		if(pedidoDTO.getIdProduto()!=null) {
			Optional<Produto> produto= produtoRepository.findById(pedidoDTO.getIdProduto());
			if(produto.isPresent()) {
				pedido.setProduto(produtoRepository.findById(pedidoDTO.getIdProduto()).get());
			}
		}
		return pedido;
	}
	public PedidoDTO toDTO(PedidoDTO pedidoDTO, Pedido pedido) {
		pedidoDTO.setIdPedido(pedido.getIdPedido());
		pedidoDTO.setIdCliente(pedido.getCliente().getIdCliente());
		pedidoDTO.setIdProduto(pedido.getProduto().getIdProduto());
		pedidoDTO.setValorTotal(pedido.getValorTotal());
		return pedidoDTO;
	}
	
	public String salvar(PedidoDTO pedidoDTO) {
		Pedido pedido = new Pedido();
		toModel(pedido, pedidoDTO);
		pedidoRepository.save(pedido);
		return "Novo pedido cadastrado."
		+ "\nID pedido: " + pedido.getIdPedido();
	}
	
	public PedidoDTO buscarPorId(Integer idPedido) throws PedidoException {
		Optional<Pedido> funOptional = pedidoRepository.findById(idPedido);
		Pedido pedido = new Pedido();
		PedidoDTO pedidoDTO = new PedidoDTO();
		
		if(funOptional.isPresent()) {
			pedido = funOptional.get();
			toDTO(pedidoDTO, pedido);
			return pedidoDTO;
		}
		throw new PedidoException("Pedido não encontrado.");
		
	}
	
	public void delete(Integer idPedido) {
		pedidoRepository.deleteById(idPedido);
	}
	
	public String atualizar(Integer idPedido, PedidoDTO pedidoDTO) throws PedidoException {
		Optional<Pedido> funOptional = pedidoRepository.findById(idPedido);
		Pedido pedido = new Pedido();
		
		if(funOptional.isPresent()) {
			pedido = funOptional.get();
			if(pedidoDTO.getValorTotal()!= null) {
				pedido.setValorTotal(pedido.getValorTotal());
			}
			pedidoRepository.save(pedido);
			return "Pedido " + pedido.getIdPedido() + " foi atualizado.";
		}
		throw new PedidoException("O pedido não foi atualizado");
	}
	
	public List<PedidoDTO> todosPedidos(){
		List<Pedido> lisPedidos = pedidoRepository.findAll();
		List<PedidoDTO> pedidoDTOs = new ArrayList<PedidoDTO>();
		
		for (Pedido pedido : lisPedidos) {
			PedidoDTO pedidoDTO = new PedidoDTO();
			toDTO(pedidoDTO, pedido);
			pedidoRepository.save(pedido);
		}
		return pedidoDTOs;
	}
}
