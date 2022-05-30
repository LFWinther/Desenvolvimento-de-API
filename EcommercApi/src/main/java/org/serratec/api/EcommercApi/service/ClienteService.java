package org.serratec.api.EcommercApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.api.EcommercApi.DTO.ClienteDTO;
import org.serratec.api.EcommercApi.exception.ClienteException;
import org.serratec.api.EcommercApi.model.Cliente;
import org.serratec.api.EcommercApi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente toModel(Cliente cliente, ClienteDTO clienteDTO) {
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setNomeCompleto(clienteDTO.getNomeCompleto());
		cliente.setDataNasc(clienteDTO.getDataNasc());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setEndereco(clienteDTO.getEndereco());
		cliente.setNomeUsuario(clienteDTO.getNomeUsuario());
		cliente.setTelefone(clienteDTO.getTelefone());
		
		return cliente;
	}
	
	public ClienteDTO toDTO(ClienteDTO clienteDTO, Cliente cliente) {
		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setNomeCompleto(cliente.getNomeCompleto());
		clienteDTO.setDataNasc(cliente.getDataNasc());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setEndereco(cliente.getEndereco());
		clienteDTO.setNomeUsuario(cliente.getNomeUsuario());
		clienteDTO.setTelefone(cliente.getTelefone());
		return clienteDTO;
	}
	
	public String salvar(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		toModel(cliente, clienteDTO);
		clienteRepository.save(cliente);
		return "Cliente " + cliente.getNomeCompleto() + " cadastrado."
		+ "\nID cliente: " + cliente.getIdCliente();
	}
	
	public ClienteDTO buscarPorId(Integer idCliente) throws ClienteException {
		Optional<Cliente> funOptional = clienteRepository.findById(idCliente);
		Cliente cliente = new Cliente();
		ClienteDTO clienteDTO = new ClienteDTO();
		
		if(funOptional.isPresent()) {
			cliente = funOptional.get();
			toDTO(clienteDTO, cliente);
			return clienteDTO;
		}
		throw new ClienteException("Cliente não encontrado");
	}
	
	public void delete(Integer idCliente) {
		clienteRepository.deleteById(idCliente);
	}
	
	public String atualizar(Integer idCliente, ClienteDTO clienteDTO) throws ClienteException {
		Optional<Cliente> funOptional = clienteRepository.findById(idCliente);
		Cliente cliente = new Cliente();
		
		if(funOptional.isPresent()) {
			cliente = funOptional.get();
			if(clienteDTO.getCpf()!= null) {
				cliente.setCpf(cliente.getCpf());
			}if(clienteDTO.getNomeCompleto()!= null) {
				cliente.setNomeCompleto(cliente.getNomeCompleto());
			}if(clienteDTO.getDataNasc()!= null) {
				cliente.setDataNasc(cliente.getDataNasc());
			}if(clienteDTO.getEmail()!= null) {
				cliente.setEmail(cliente.getEmail());
			}if(clienteDTO.getEndereco()!= null) {
				cliente.setEndereco(cliente.getEndereco());
			}if(clienteDTO.getNomeUsuario()!= null) {
				cliente.setNomeUsuario(cliente.getNomeUsuario());
			}if(clienteDTO.getTelefone()!= null) {
				cliente.setTelefone(cliente.getTelefone());
			}
			clienteRepository.save(cliente);
			return "Cliente " + cliente.getNomeCompleto() + " foi atualizado.";
		}
		throw new ClienteException("O cliente não foi atualizado");
	}
	
	public List<ClienteDTO> todosClientes(){
		List<Cliente> lisClientes = clienteRepository.findAll();
		List<ClienteDTO> clienteDTOs = new ArrayList<ClienteDTO>();
		
		for (Cliente cliente : lisClientes) {
			ClienteDTO clienteDTO = new ClienteDTO();
			toDTO(clienteDTO, cliente);
			clienteRepository.save(cliente);
		}
		return clienteDTOs;
	}
	

}
