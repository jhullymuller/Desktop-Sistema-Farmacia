package model;

import java.util.Date;
import java.util.List;

public class Venda {
	private Integer idVenda ;
	private double valorTotal;
	private Date data;
	private Integer idcliente;
	private String formaPagamento;
	private List<VendaMedicamento> listaMedicamentos;
	public Integer getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<VendaMedicamento> getListaMedicamentos() {
		return listaMedicamentos;
	}
	public void setListaMedicamentos(List<VendaMedicamento> listaMedicamentos) {
		this.listaMedicamentos = listaMedicamentos;
	}
	public Integer getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	

	
	
	
	

}
