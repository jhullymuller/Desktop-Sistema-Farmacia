package model;

public class VendaMedicamento {
	private int idVendaMedicamento;
	private Medicamento medicamento;
	private Receita receita;
	private int quantidade;
	private double valor;
	private int idVenda;
	

	public int getIdVendaMedicamento() {
		return idVendaMedicamento;
	}

	public void setIdVendaMedicamento(int idVendaMedicamento) {
		this.idVendaMedicamento = idVendaMedicamento;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

}
