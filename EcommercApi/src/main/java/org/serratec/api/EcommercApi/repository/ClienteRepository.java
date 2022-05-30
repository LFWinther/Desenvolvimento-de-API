package org.serratec.api.EcommercApi.repository;

import org.serratec.api.EcommercApi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
