package org.serratec.backend.projeto05.clienteService;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto05.DTO.ClienteDTO;
import org.serratec.backend.projeto05.exception.ClienteException;
import org.serratec.backend.projeto05.model.Cliente;
import org.serratec.backend.projeto05.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
public Cliente transormarClienteDTOEmCliente(ClienteDTO clienteDTO, Cliente cliente) {
		
		cliente.setCpf(clienteDTO.getCpf().replace(".", "").replace("-", ""));
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setNumeroTelefone(clienteDTO.getNumeroTelefone());
		cliente.setDataNasc(clienteDTO.getDataNasc());
		cliente.setNome(clienteDTO.getNome());
		return cliente;
		
	}
	
	public ClienteDTO transormarClienteEmClienteDTO(ClienteDTO clienteDTO, Cliente cliente) {
		
		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setNumeroTelefone(cliente.getNumeroTelefone());
		clienteDTO.setDataNasc(cliente.getDataNasc());
		clienteDTO.setNome(cliente.getNome());
		return clienteDTO;
		
	}
	
	public void salvar(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		transormarClienteDTOEmCliente(clienteDTO, cliente);
		clienteRepository.save(cliente);
	}
	
	public ClienteDTO buscarPorId(Integer idCliente) throws ClienteException {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		ClienteDTO clienteDTO = new ClienteDTO();
		
		if(cliente.isPresent()) {
			clienteDTO = transormarClienteEmClienteDTO(clienteDTO, cliente.get());
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
			}if(clienteDTO.getNumeroTelefone()!=null) {
				clienteNaApi.setNumeroTelefone(clienteDTO.getNumeroTelefone());
			}if(clienteDTO.getDataNasc()!=null) {
				clienteNaApi.setDataNasc(clienteDTO.getDataNasc());
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
