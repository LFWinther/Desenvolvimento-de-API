package org.serratec.java2backed.biblioteca.repository;

import java.util.List;

import org.serratec.java2backed.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LivroRepository extends JpaRepository<Livro, Integer>{

	
	@Query(value = "SELECT * FROM livro ORDER BY livro_cd_id DESC", nativeQuery = true)
	List<Livro> buscarLivrosDesc();
	
//	Optional<Livro> findById(Integer idLivro);
}
