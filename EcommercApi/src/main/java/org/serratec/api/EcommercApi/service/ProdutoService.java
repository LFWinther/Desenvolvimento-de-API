package org.serratec.api.EcommercApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.api.EcommercApi.DTO.ProdutoDTO;
import org.serratec.api.EcommercApi.exception.ProdutoException;
import org.serratec.api.EcommercApi.model.Funcionario;
import org.serratec.api.EcommercApi.model.Produto;
import org.serratec.api.EcommercApi.repository.FuncionarioRepository;
import org.serratec.api.EcommercApi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	public Produto toModel(Produto produto, ProdutoDTO produtoDTO) {
		produto.setDataValidade(produtoDTO.getDataValidade());
		produto.setPeriodoVld(produtoDTO.getPeriodoVld());
		produto.setDescricao(produtoDTO.getDescricao());
		produto.setNome(produtoDTO.getNome());
		produto.setQntEstoque(produtoDTO.getQntEstoque());
		produto.setValor(produtoDTO.getValor());

		if(produtoDTO.getIdFuncionario()!=null) {
			Optional<Funcionario> funcionario = funcionarioRepository.findById(produtoDTO.getIdFuncionario());
			if(funcionario.isPresent()) {
				produto.setFuncionario(funcionarioRepository.findById(produtoDTO.getIdFuncionario()).get());
			}
		}
		
		return produto;
	}
	public ProdutoDTO toDTO(ProdutoDTO produtoDTO, Produto produto) {
		produtoDTO.setIdProduto(produto.getIdProduto());
		produtoDTO.setDataValidade(produto.getDataValidade());
		produtoDTO.setPeriodoVld(produto.getPeriodoVld());
		produtoDTO.setDescricao(produto.getDescricao());
		produtoDTO.setNome(produto.getNome());
		produtoDTO.setQntEstoque(produto.getQntEstoque());
		produtoDTO.setValor(produto.getValor());
		return produtoDTO;
	}
	
	public String salvar(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();
		toModel(produto, produtoDTO);
		produtoRepository.save(produto);
		return "Novo produto cadastrado."
		+ "\nID produto: " + produto.getIdProduto();
	}
	
	public ProdutoDTO buscarPorId(Integer idProduto) throws ProdutoException {
		Optional<Produto> funOptional = produtoRepository.findById(idProduto);
		Produto produto = new Produto();
		ProdutoDTO produtoDTO = new ProdutoDTO();
		
		if(funOptional.isPresent()) {
			produto = funOptional.get();
			toDTO(produtoDTO, produto);
			return produtoDTO;
		}
		throw new ProdutoException("Produto não encontrado.");
		
	}
	
	public void delete(Integer idProduto) {
		produtoRepository.deleteById(idProduto);
	}
	
	public String atualizar(Integer idProduto, ProdutoDTO produtoDTO) throws ProdutoException {
		Optional<Produto> funOptional = produtoRepository.findById(idProduto);
		Produto produto = new Produto();
		
		if(funOptional.isPresent()) {
			produto = funOptional.get();
			if(produtoDTO.getValor()!= null) {
				produto.setValor(produto.getValor());
			}if(produtoDTO.getDataValidade()!= null) {
				produto.setDataValidade(produto.getDataValidade());
			}if(produtoDTO.getDescricao()!= null) {
				produto.setDescricao(produto.getDescricao());
			}if(produtoDTO.getNome()!= null) {
				produto.setNome(produto.getNome());
			}if(produtoDTO.getPeriodoVld()!= null) {
				produto.setPeriodoVld(produto.getPeriodoVld());
			}if(produtoDTO.getQntEstoque()!= null) {
				produto.setQntEstoque(produto.getQntEstoque());
			}
			produtoRepository.save(produto);
			return "Produto " + produto.getNome() + " foi atualizado.";
		}
		throw new ProdutoException("O produto não foi atualizado");
	}
	
	public List<ProdutoDTO> todosProdutos(){
		List<Produto> lisProdutos = produtoRepository.findAll();
		List<ProdutoDTO> produtoDTOs = new ArrayList<ProdutoDTO>();
		
		for (Produto produto : lisProdutos) {
			ProdutoDTO produtoDTO = new ProdutoDTO();
			toDTO(produtoDTO, produto);
			produtoRepository.save(produto);
		}
		return produtoDTOs;
	}

}
