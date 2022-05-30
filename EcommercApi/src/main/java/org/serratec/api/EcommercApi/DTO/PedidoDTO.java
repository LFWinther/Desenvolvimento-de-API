package org.serratec.api.EcommercApi.DTO;

import java.io.Serializable;

public class PedidoDTO implements Serializable {
	
		private static final long serialVersionUID = 1L;

		private Integer idPedido;
		private Integer idCliente;
		private Integer idProduto;
		private Double valorTotal;
	

		public PedidoDTO() {}


		public Integer getIdPedido() {
			return idPedido;
		}


		public void setIdPedido(Integer idPedido) {
			this.idPedido = idPedido;
		}


		public Integer getIdCliente() {
			return idCliente;
		}


		public void setIdCliente(Integer idCliente) {
			this.idCliente = idCliente;
		}


		public Integer getIdProduto() {
			return idProduto;
		}


		public void setIdProduto(Integer idProduto) {
			this.idProduto = idProduto;
		}


		public Double getValorTotal() {
			return valorTotal;
		}


		public void setValorTotal(Double valorTotal) {
			this.valorTotal = valorTotal;
		}
		
		
}