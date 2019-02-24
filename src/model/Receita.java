package model;

public class Receita {
	private Integer idreceita;
	private String tipoReceita;
    private Integer quantidadeCaixa;
    private String crs;
    private Integer Idcliente;
	public Integer getIdreceita() {
		return idreceita;
	}
	public void setIdreceita(Integer idreceita) {
		this.idreceita = idreceita;
	}
	public String getTipoReceita() {
		return tipoReceita;
	}
	public void setTipoReceita(String tipoReceita) {
		this.tipoReceita = tipoReceita;
	}
	public Integer getQuantidadeCaixa() {
		return quantidadeCaixa;
	}
	public void setQuantidadeCaixa(Integer quantidadeCaixa) {
		this.quantidadeCaixa = quantidadeCaixa;
	}
	public Integer getIdcliente() {
		return Idcliente;
	}
	public void setIdcliente(Integer idcliente) {
		Idcliente = idcliente;
	}
	public String getCrs() {
		return crs;
	}
	public void setCrs(String crs) {
		this.crs = crs;
	}
	
	@Override
	public String toString() {
		return crs;
	}
	
    
}
