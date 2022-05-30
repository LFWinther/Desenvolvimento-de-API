package org.serratec.api.borracharia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.api.borracharia.DTO.ServicoTDO;
import org.serratec.api.borracharia.exception.ServicoException;
import org.serratec.api.borracharia.model.Carro;
import org.serratec.api.borracharia.model.Servico;
import org.serratec.api.borracharia.repository.CarroRepository;
import org.serratec.api.borracharia.repository.ServicoRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

	ServicoRepository servicoRepository;
	
	CarroRepository carroRepository;
	
	public ServicoTDO toDTO(Servico servico,ServicoTDO servicoTDO) {
		
		servicoTDO.setCarro(servico.getCarro());
		servicoTDO.setData(servico.getData());
		servicoTDO.setIdServico(servico.getIdServico());
		servicoTDO.setServPrest(servico.getServPrest());
		servicoTDO.setValor(servico.getValor());
		return servicoTDO;
	}
	
	public Servico toModel(ServicoTDO servicoTDO, Servico servico) {
		
		servico.setCarro(servicoTDO.getCarro());
		servico.setData(servicoTDO.getData());
		servico.setServPrest(servicoTDO.getServPrest());
		servico.setValor(servicoTDO.getValor());
		
		if(servicoTDO.getCarro()!=null) {
			Optional<Carro> caOptional = carroRepository.findById(servicoTDO.getIdServico());
			if(caOptional.isPresent()) {
				servico.setCarro(carroRepository.findById(servicoTDO.getIdServico()).get());
			}
		}
		return servico;
	}
	
	public String salvar(ServicoTDO servicoTDO) throws ServicoException {
		Servico servico = new Servico();
		toModel(servicoTDO, servico);
		servicoRepository.save(servico);
		return " O servico" + servico.getServPrest() + " foi criado.";			
	}
	
	public ServicoTDO buscarPorId(Integer idServico) throws ServicoException{
		Optional<Servico> serOptional = servicoRepository.findById(idServico);
		Servico servico = new Servico();
		ServicoTDO servicoTDO = new ServicoTDO();
		
		if(serOptional.isPresent()) {
			servico=serOptional.get();
			toDTO(servico, servicoTDO);
			return servicoTDO;
		}
		throw new ServicoException("Servico não encontrado.");
	}
	
	public void deletar(Integer idServico) {
		servicoRepository.deleteById(idServico);
	}
	
	public String atualizar(Integer idServico, ServicoTDO servicoDTO) throws ServicoException{
		Optional<Servico> serOptional = servicoRepository.findById(idServico);
		Servico servico= new Servico();
		
		if(serOptional.isPresent()){
			servico = serOptional.get();
			if(servicoDTO.getServPrest()!=null) {
				servico.setServPrest(servicoDTO.getServPrest());
			}if(servicoDTO.getCarro()!=null) {
				servico.setCarro(servicoDTO.getCarro());
			}if(servicoDTO.getData()!=null) {
				servico.setData(servicoDTO.getData());
			}if(servicoDTO.getValor()!=null) {
				servico.setValor(servicoDTO.getValor());
			}
			servicoRepository.save(servico);
			return "O servico " + servico.getServPrest() + " foi atualizado.";
		}
		throw new ServicoException("Erro ao atualizar o serviço");
	}
	
	public List<ServicoTDO> todosServicos(){
		List<Servico> listServicos = servicoRepository.findAll();
		List<ServicoTDO> listServicoTDOs = new ArrayList<ServicoTDO>();
		for (Servico servico : listServicos) {
			ServicoTDO servicoTDO = new ServicoTDO();
			toDTO(servico, servicoTDO);
			listServicoTDOs.add(servicoTDO);
		}
		return listServicoTDOs;
	}
}
