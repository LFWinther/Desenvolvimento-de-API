package org.serratec.backend.banckProject.repository;

import java.util.Optional;

import org.serratec.backend.banckProject.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{

	Optional<Conta> findByNumero(String numero);
}
