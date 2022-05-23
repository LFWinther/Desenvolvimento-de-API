package org.serratec.backend.banckProject.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.banckProject.enums.Operation;
import org.serratec.backend.banckProject.exception.InsufficientFunds;
import org.serratec.backend.banckProject.exception.OperationInvalid;
import org.serratec.backend.banckProject.model.Conta;
import org.serratec.backend.banckProject.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

	@Autowired
	ContaRepository contaRepository;

	public void adicionar(Conta conta) {
		contaRepository.save(conta);
	}

	public Conta buscarPorNum(String numero) {
		Conta contaApi = new Conta();
		Optional<Conta> conta = contaRepository.findByNumero(numero);

		if (conta.isPresent()) {
			contaApi = conta.get();
		}
		return contaApi;
	}

	public void atualizar(String numero, Conta conta) {
		Conta contaApi = buscarPorNum(numero);

		if (conta.getTitular() != null) {
			contaApi.setTitular(conta.getTitular());
		}
		if (conta.getNumero() != null) {
			contaApi.setNumero(conta.getNumero());
		}
		contaRepository.save(contaApi);
	}

	public void delete(String numero) {
		Conta contaApi = buscarPorNum(numero);
		contaRepository.deleteById(contaApi.getId());
	}

	public List<Conta> listaContas() {
		return contaRepository.findAll();
	}

	public void operacao(Operation operacao, String numero, Double valor) throws InsufficientFunds, OperationInvalid {
		Conta contaApi = buscarPorNum(numero);
		if (operacao.equals(Operation.DEBITO)) {
			if (contaApi.getSaldo() < valor) {
				throw new InsufficientFunds("Saldo insuficiente");
			} else {
				double novoSaldo = contaApi.getSaldo() - valor;
				contaApi.setSaldo(novoSaldo);
			}
		} else if (operacao.equals(Operation.CREDITO)) {
			if (contaApi.getLimite() < valor) {
				throw new InsufficientFunds("Sem limite disponivel");
			} else {
				double novoLimite = contaApi.getLimite() - valor;
				double novoFatura = contaApi.getFatura() + valor;
				contaApi.setLimite(novoLimite);
				contaApi.setFatura(novoFatura);
			}

		}
		contaRepository.save(contaApi);
	}
}
