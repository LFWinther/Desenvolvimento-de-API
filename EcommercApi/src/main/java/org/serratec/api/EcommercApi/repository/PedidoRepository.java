package org.serratec.api.EcommercApi.repository;

import org.serratec.api.EcommercApi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}