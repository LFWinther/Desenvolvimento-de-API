package org.serratec.api.borracharia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.serratec.api.borracharia.DTO.CarroDTO;
import org.serratec.api.borracharia.exception.CarroException;
import org.serratec.api.borracharia.model.Carro;
import org.serratec.api.borracharia.model.Cliente;
import org.serratec.api.borracharia.repository.CarroRepository;
import org.serratec.api.borracharia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {
	
	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public CarroDTO toDTO(Carro carro, CarroDTO carroDTO) {
		
		carroDTO.setIdCarro(carro.getIdCarro());
		carroDTO.setAno(carro.getAno());
		carroDTO.setMarca(carro.getMarca());
		carroDTO.setModelo(carro.getModelo());
		carroDTO.setIdCliente(carro.getCliente().getIdCliente());
		return carroDTO;
	}
	
	public Carro toModel(Carro carro, CarroDTO carroDTO) {
		
		carro.setIdCarro(carroDTO.getIdCarro());
		carro.setAno(carroDTO.getAno());
		carro.setMarca(carroDTO.getMarca());
		carro.setModelo(carroDTO.getModelo());
		
		if(carroDTO.getIdCliente()!= null) {
			Optional<Cliente> cliOptional = clienteRepository.findById(carroDTO.getIdCarro());
			if(cliOptional.isPresent()) {
				carro.setCliente(clienteRepository.findById(carroDTO.getIdCliente()).get());
			}
		}
		return carro;
	}
	
	public String salvar(CarroDTO carroDTO) throws MessagingException, CarroException {
		Carro carro = new Carro();
		toModel(carro, carroDTO);
		carroRepository.save(carro);
		return "O cartão foi criado com o id: " + carro.getIdCarro();
	}
	
	public CarroDTO buscarPorId(Integer idCarro) throws CarroException{
		Optional<Carro> cartao = carroRepository.findById(idCarro);
		Carro carroNoBanco = new Carro();
		CarroDTO carroDTO = new CarroDTO();
		
		if(cartao.isPresent()){
			carroNoBanco = cartao.get();
			toDTO(carroNoBanco, carroDTO);
			return carroDTO;
		}
		throw new CarroException("Carro não encontrado.");
	}
	
	public void deletar(Integer idCarro) {
		carroRepository.deleteById(idCarro);
	}
	
	public String atualizar (Integer idCartao, CarroDTO carroDTO) throws CarroException {
		Optional<Carro> carro = carroRepository.findById(idCartao);
		Carro carroDTOVazio = new Carro();
		
		if(carro.isPresent()) {
			carroDTOVazio = carro.get();
			if(carroDTO.getAno()!= null) {
				carroDTOVazio.setAno(carroDTO.getAno());
			}if(carroDTO.getIdCliente()!= null) {
				carroDTOVazio.setMarca(carroDTO.getMarca());
			}if(carroDTO.getModelo()!= null) {
				carroDTOVazio.setModelo(carroDTO.getModelo());
			}
			carroRepository.save(carroDTOVazio);
			return "O cartão com o Id " + carroDTOVazio.getIdCarro() + " foi atualizado.";
		}
		throw new CarroException("O cartão não foi atualizado");
	}
	
	public List<CarroDTO> todosCarros(){
		List<Carro> listaCarroModel = carroRepository.findAll();
		List<CarroDTO> lisCarroDTO = new ArrayList<CarroDTO>();
		for (Carro carro : listaCarroModel) {
			CarroDTO carroDTO = new CarroDTO();
			toDTO(carro, carroDTO);
			lisCarroDTO.add(carroDTO);
		}
		return lisCarroDTO;
	}
}
