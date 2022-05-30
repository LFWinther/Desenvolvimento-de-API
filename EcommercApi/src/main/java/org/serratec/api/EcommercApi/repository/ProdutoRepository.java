package org.serratec.api.EcommercApi.repository;

import org.serratec.api.EcommercApi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
