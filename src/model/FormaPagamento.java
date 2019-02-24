package model;

public class FormaPagamento {
	private Integer idPagamento;
	private String tipoPagamento;
	private int quantidadeParcela;
	private Double valor;
	private int tipoCartao;
	public Integer getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	public int getQuantidadeParcela() {
		return quantidadeParcela;
	}
	public void setQuantidadeParcela(int quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public int getTipoCartao() {
		return tipoCartao;
	}
	public void setTipoCartao(int tipoCartao) {
		this.tipoCartao = tipoCartao;
	}
	
	

}
