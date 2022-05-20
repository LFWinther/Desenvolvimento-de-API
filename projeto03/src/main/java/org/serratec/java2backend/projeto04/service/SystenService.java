package org.serratec.java2backend.projeto04.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.serratec.java2backend.projeto04.exception.SystenException;
import org.serratec.java2backend.projeto04.pessoas.Usuario;
import org.springframework.stereotype.Service;

@Service
public class SystenService {
	
	List<Usuario> lista = new ArrayList<Usuario>();
	
		public List<Usuario> usuarios = Arrays.asList(new Usuario(1, 1000, "Jurema", "Juju", "ju123"),
				new Usuario(2, 1001, "Kleberson", "klebin", "kle123"),
				new Usuario(3, 1002, "Valdicreme", "valval", "val123"));
	
	
	public void adicionar(Usuario usuario) {
		lista.add(usuario);
	}

	public void atualizar(Integer idUsuario, Usuario usuario) {
		Usuario usuarios = new Usuario();
		usuarios = lista.get(idUsuario);
		
		usuarios.setIdUsuario(usuario.getIdUsuario());
		usuarios.setIdConta(usuario.getIdConta());
		usuarios.setNome(usuario.getNome());
		usuarios.setLogin(usuario.getLogin());
		usuarios.setSenha(usuario.getSenha());
	}
	
	
	public Usuario buscarPorIdUsuario(Integer idUsuario) throws SystenException {
		Usuario todosUsuarios = new Usuario();
		for (Usuario usuario : lista) {
			if(usuario.getIdUsuario().equals(idUsuario)) {
				todosUsuarios = usuario;
			}
		}
		if(todosUsuarios.getIdUsuario()==(null)) {
			throw new SystenException(idUsuario);
		}
		return todosUsuarios;
	}
	
	public void deletar(Integer idUsuario) {
		lista.remove((int) idUsuario);
	}
}
