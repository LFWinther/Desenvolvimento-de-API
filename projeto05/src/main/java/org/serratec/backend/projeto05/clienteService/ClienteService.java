package org.serratec.backend.projeto05.clienteService;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto05.model.Cliente;
import org.serratec.backend.projeto05.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public void salvar(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public Cliente buscarPorId(Integer idCliente) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente clienteNaApi = new Cliente();
		if(cliente.isPresent()) {
			clienteNaApi = cliente.get();
		}
		return clienteNaApi;
	}
	
	public void atualizar(Integer idCliente, Cliente cliente) {
		Cliente clienteNaApi = buscarPorId(idCliente);
		
		if(cliente.getCpf()!=null)
		clienteNaApi.setCpf(cliente.getCpf());
		if(cliente.getNome()!=null)
		clienteNaApi.setNome(cliente.getNome());
		if(cliente.getEmail()!=null)
		clienteNaApi.setEmail(cliente.getEmail());
		if(cliente.getNumeroTelefone()!=null)
		clienteNaApi.setNumeroTelefone(cliente.getNumeroTelefone());
		if(cliente.getData()!=null) {
			clienteNaApi.setData(cliente.getData());
		}
		clienteRepository.save(clienteNaApi);
	}
	
	public void delete(Integer idCliente) {
		clienteRepository.deleteById(idCliente);
	}
	
	public List<Cliente> listaCliente(){
		return clienteRepository.findAll();
	}
}
