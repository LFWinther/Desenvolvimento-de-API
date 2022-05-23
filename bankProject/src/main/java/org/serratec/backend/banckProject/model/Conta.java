package org.serratec.backend.banckProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.serratec.backend.banckProject.exception.InsufficientFunds;
import org.serratec.backend.banckProject.exception.OperationInvalid;

@Entity
@Table(name= "conta")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cd_conta")
	private Integer id;
	@Column(name="numero_tx_conta")
	private String numero;
	@Column(name="titular_tx_conta")
	private String titular;
	@Column(name="saldo_db_conta")
	private Double saldo;
	@Column(name="fatura_db_conta")
	private Double fatura;
	@Column(name="limite_db_conta")
	private Double limite;
	
	
	
	public Conta() {}

	public Conta(Integer id, String numero, String titular, Double saldo, Double fatura, Double limite) {
		super();
		this.id = id;
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.fatura = fatura;
		this.limite = limite;
		
	}

	public Integer getId() {
		return id;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public Double getFatura() {
		return fatura;
	}
	
	public void setFatura(Double fatura) {
		this.fatura = fatura;
	}

	public Double getLimite() {
		return limite;
	}
	
	public void setLimite(Double limite) {
		this.limite = limite;
	}
	
	public void debito(Double valor) throws InsufficientFunds{
		if (this.saldo < valor) {
			throw new InsufficientFunds("Saldo insuficiente");
		} else {
			double novoSaldo = this.saldo - valor;
			this.saldo = novoSaldo;
		}
	}
	
	public void credito(Double valor) throws OperationInvalid {
		if (this.limite < valor) {
			throw new OperationInvalid("Sem limite disponivel");
		} else {
			double novoLimite = this.limite - valor;
			double novoFatura = this.fatura + valor;
			this.limite = novoLimite;
			this.fatura = novoFatura;
		}
	}
	
}
