package org.serratec.api.borracharia.service;

import java.util.List;
import java.util.Optional;

import org.serratec.api.borracharia.DTO.ClienteDTO;
import org.serratec.api.borracharia.exception.ClienteException;
import org.serratec.api.borracharia.model.Cliente;
import org.serratec.api.borracharia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
public Cliente toModel(ClienteDTO clienteDTO, Cliente cliente) {
		
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setNome(clienteDTO.getNome());
		cliente.setTelefone(clienteDTO.getTelefone());
		return cliente;
		
	}
	
	public ClienteDTO toDTO(ClienteDTO clienteDTO, Cliente cliente) {
		
		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setTelefone(cliente.getTelefone());
		return clienteDTO;
		
	}
	
	public void salvar(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		toModel(clienteDTO, cliente);
		clienteRepository.save(cliente);
	}
	
	public ClienteDTO buscarPorId(Integer idCliente) throws ClienteException {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		ClienteDTO clienteDTO = new ClienteDTO();
		
		if(cliente.isPresent()) {
			clienteDTO = toDTO(clienteDTO, cliente.get());
			return clienteDTO;
		}
		throw new ClienteException("Cliente não encontrado");
	}
	
	public void atualizar(Integer idCliente, ClienteDTO clienteDTO) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente clienteNaApi = new Cliente();
		
		if(cliente.isPresent()) {
			clienteNaApi = cliente.get();
			if(clienteDTO.getCpf()!=null) {
				clienteNaApi.setCpf(clienteDTO.getCpf());
			}if(clienteDTO.getNome()!=null) {
				clienteNaApi.setNome(clienteDTO.getNome());
			}if(clienteDTO.getEmail()!=null) {
				clienteNaApi.setEmail(clienteDTO.getEmail());
			}if(clienteDTO.getTelefone()!=null) {
				clienteNaApi.setTelefone(clienteDTO.getTelefone());
			}
			clienteRepository.save(clienteNaApi);
		}
	}
	
	public void delete(Integer idCliente) {
		clienteRepository.deleteById(idCliente);
	}
	
	public List<Cliente> listaCliente(){
		return clienteRepository.findAll();
	}
}
