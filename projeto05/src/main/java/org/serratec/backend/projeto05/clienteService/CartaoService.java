package org.serratec.backend.projeto05.clienteService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.serratec.backend.projeto05.DTO.CartaoDTO;
import org.serratec.backend.projeto05.exception.CartaoExcpetion;
import org.serratec.backend.projeto05.exception.EmailException;
import org.serratec.backend.projeto05.model.Cartao;
import org.serratec.backend.projeto05.model.Cliente;
import org.serratec.backend.projeto05.repository.CartaoRepository;
import org.serratec.backend.projeto05.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {

	@Autowired
	CartaoRepository cartaoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EmailService emailService;
	
	public void leitor() throws IOException{
		BufferedReader buffReader = new BufferedReader(new FileReader("C:\\Serratec\\API\\Desenvolvimento-de-API\\projeto05\\cartao.txt"));
		String linha = buffReader.readLine();
		while(linha!= null) {
			String[] dados = linha.split(";");
			Cartao cartao =  new Cartao();
			cartao.setLimiteCartao(Double.parseDouble(dados[0]));
			cartao.setNumero(dados[1]);
			cartao.setNomeTitular(dados[2]);
			cartao.setDataValidade(LocalDate.parse(dados[3]));
			cartao.setCliente(clienteRepository.findById(Integer.parseInt(dados[4])).get());
			cartaoRepository.save(cartao);
			linha = buffReader.readLine();
		}
		buffReader.close();
	}
	
	
	public CartaoDTO toDTO(Cartao cartao, CartaoDTO cartaoDTO) {
		
		cartaoDTO.setDataValidade(cartao.getDataValidade());
		cartaoDTO.setLimiteCartao(cartao.getLimiteCartao());
		cartaoDTO.setId(cartao.getId());
		cartaoDTO.setNomeTitular(cartao.getNomeTitular());
		cartaoDTO.setNumero(cartao.getNomeTitular());
		cartaoDTO.setIdCliente(cartao.getCliente().getIdCliente());
		return cartaoDTO;
	}
	
	public Cartao toModel(Cartao cartao, CartaoDTO cartaoDTO) {
		
		cartao.setDataValidade(cartaoDTO.getDataValidade());
		cartao.setLimiteCartao(cartaoDTO.getLimiteCartao());
		cartao.setNomeTitular(cartaoDTO.getNomeTitular());
		cartao.setNumero(cartaoDTO.getNomeTitular());
		
		if(cartaoDTO.getIdCliente()!= null) {
			Optional<Cliente> cliOptional = clienteRepository.findById(cartaoDTO.getIdCliente());
			if(cliOptional.isPresent()) {
				cartao.setCliente(clienteRepository.findById(cartaoDTO.getIdCliente()).get());
			}
		}
		return cartao;
	}
	
	public String salvar(CartaoDTO cartaoDTO) throws EmailException, MessagingException, CartaoExcpetion {
		Cartao cartao = new Cartao();
		toModel(cartao, cartaoDTO);
		cartaoRepository.save(cartao);
		emailService.emailTeste(cartaoDTO);
		return "O cartão  criado foi com o id: " + cartao.getId();
	}
	
	public CartaoDTO buscarPorId(Integer idCartao) throws CartaoExcpetion{
		Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
		Cartao cartaoNoBanco = new Cartao();
		CartaoDTO cartaoDTO = new CartaoDTO();
		
		if(cartao.isPresent()){
			cartaoNoBanco = cartao.get();
			toDTO(cartaoNoBanco, cartaoDTO);
		}
		return cartaoDTO;
	}
	
	public void deletar(Integer idCartao) {
		cartaoRepository.deleteById(idCartao);
	}
	
	public String atualizar (Integer idCartao, CartaoDTO cartaoDTO) throws CartaoExcpetion {
		Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
		Cartao cartaoDTOVazio = new Cartao();
		
		if(cartao.isPresent()) {
			cartaoDTOVazio = cartao.get();
			if(cartaoDTO.getDataValidade()!= null) {
				cartaoDTOVazio.setDataValidade(cartaoDTOVazio.getDataValidade());
			}if(cartaoDTO.getLimiteCartao()!= null) {
				cartaoDTOVazio.setLimiteCartao(cartaoDTOVazio.getLimiteCartao());
			}if(cartaoDTO.getNomeTitular()!= null) {
				cartaoDTOVazio.setNomeTitular(cartaoDTOVazio.getNomeTitular());
			}if(cartaoDTO.getNumero()!= null) {
				cartaoDTOVazio.setNumero(cartaoDTOVazio.getNomeTitular());
			}
			cartaoRepository.save(cartaoDTOVazio);
			return "O cartão com o Id " + cartaoDTOVazio.getId() + " foi atualizado.";
		}
		throw new CartaoExcpetion("O cartão não foi atualizado");
	}
	
	public List<CartaoDTO> buscarTodos(){
		List<Cartao> listaCartaoModel = cartaoRepository.findAll();
		List<CartaoDTO> lisCartaoDTO = new ArrayList<CartaoDTO>();
		for (Cartao cartao : listaCartaoModel) {
			CartaoDTO cartaoDTO = new CartaoDTO();
			toDTO(cartao, cartaoDTO);
			lisCartaoDTO.add(cartaoDTO);
		}
		return lisCartaoDTO;
	}
	
	public void salvarListaCartao(List<CartaoDTO> listaCartaoDTO) {
		
		for (CartaoDTO cartaoDTO : listaCartaoDTO) {
			Cartao cartao = new Cartao();
			toModel(cartao, cartaoDTO);
			cartaoRepository.save(cartao);
		}
	}
}
