package org.serratec.api.borracharia.repository;

import org.serratec.api.borracharia.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer>{

}
