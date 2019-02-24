package control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.ClienteDAO;
import dao.MedicamentoDAO;
import dao.ReceitaDao;
import dao.VendaDao;
import model.Cliente;
import model.Medicamento;
import model.Receita;
import model.Venda;
import model.VendaMedicamento;

public class NovaVendaControl {
	private JTextField txtquantidade;
	private JTable table;
	private VendaDao vendaDao;
	private Venda venda;
	private JComboBox comboCliente;
	private JComboBox comboProduto;
	private JComboBox comboReceita;
	private JTextField textValorPago;
	private JLabel lblValorTotal;
	private JLabel lblValorTroco;
	private JComboBox cbFormaPagamento;
	private ClienteDAO clienteDao;
	private MedicamentoDAO medicamentoDAO;
	private ReceitaDao receitaDao;
	private List<VendaMedicamento> vendasMedicamentos;

	public NovaVendaControl(JComboBox comboCliente, JComboBox comboProduto, JComboBox comboReceita,
			JTextField txtquantidade, JTable table, JComboBox cbFormaPagamento, JTextField textValorPago, JLabel lblValorTotal, JLabel lblValorTroco) {
		super();
		this.comboCliente = comboCliente;
		this.comboProduto = comboProduto;
		this.comboReceita = comboReceita;
		this.txtquantidade = txtquantidade;
		this.textValorPago = textValorPago;
		this.lblValorTotal = lblValorTotal;
		this.lblValorTroco = lblValorTroco;
		this.cbFormaPagamento = cbFormaPagamento;
		this.table = table;
		this.vendaDao = new VendaDao();
		this.venda = new Venda();
		this.clienteDao = new ClienteDAO();
		this.receitaDao = new ReceitaDao();
		this.medicamentoDAO = new MedicamentoDAO();
		this.vendasMedicamentos = new ArrayList<>();
	}

	public void listarCLiente() {
		List<Cliente> lista = clienteDao.listar("");
		for (int i = 0; i < lista.size(); i++) {
			Cliente cliente = lista.get(i);
			comboCliente.addItem(cliente);
		}
	}

	public void listarProdutoMedicamento() {
		List<Medicamento> lista = medicamentoDAO.listar("");
		for (int i = 0; i < lista.size(); i++) {
			Medicamento medicamento = lista.get(i);
			comboProduto.addItem(medicamento);
		}
	}

	public void listarReceita() {
		List<Receita> lista = receitaDao.listar("");
		for (int i = 0; i < lista.size(); i++) {
			Receita receita = lista.get(i);
			comboReceita.addItem(receita);
		}
	}

	public void adicionarMedicamento() {
		VendaMedicamento vendaMedicamento = new VendaMedicamento();
		Medicamento medicamento = (Medicamento) comboProduto.getSelectedItem();
		vendaMedicamento.setMedicamento(medicamento);
		Receita receita = (Receita) comboReceita.getSelectedItem();
		vendaMedicamento.setReceita(receita);
		Integer quantidade = Integer.parseInt(txtquantidade.getText());
		Double valor = medicamento.getValor() * quantidade;
		vendaMedicamento.setQuantidade(quantidade);
		vendaMedicamento.setValor(valor);
		vendasMedicamentos.add(vendaMedicamento);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { medicamento.getNome(), receita.getCrs(), quantidade,valor});
		
		lblValorTotal.setText(calculavalortotal().toString());
		calculaTroco();

	}

	public void salvar() {
		venda = new Venda();
		Cliente cliente = (Cliente) comboCliente.getSelectedItem();
		venda.setIdcliente(cliente.getIdcliente());
		venda.setData(new Date());
		venda.setValorTotal(calculavalortotal());
		venda.setFormaPagamento((String) cbFormaPagamento.getSelectedItem());
		venda.setListaMedicamentos(vendasMedicamentos);
		boolean salvo = vendaDao.cadastrar(venda);
		if (salvo) {
			JOptionPane.showMessageDialog(null, "Sucesso");

		} else {
			JOptionPane.showMessageDialog(null, "Erro");
		}
		venda = null;
		vendasMedicamentos = new ArrayList<>();

	}

	public Double calculavalortotal() {
		Double valor = 0d;
		for (int i = 0; i < vendasMedicamentos.size(); i++) {
			VendaMedicamento vendaMedicamento = vendasMedicamentos.get(i);
			valor = valor + vendaMedicamento.getValor();
		}
		return valor;
	}
	
	public void removerMedicamento() {
		int linhaSelecionada = table.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.removeRow(linhaSelecionada);
		this.vendasMedicamentos.remove(linhaSelecionada);
		lblValorTotal.setText(calculavalortotal().toString());
		calculaTroco();
	}
	
	public void calculaTroco() {
		if (textValorPago.getText() != null && textValorPago.getText().length() > 0) {
			Double valorTotal = calculavalortotal();
			Double valorPago = Double.parseDouble(textValorPago.getText());
			Double troco = valorPago - valorTotal;
			lblValorTroco.setText(troco.toString());
		} else {
			lblValorTroco.setText("");
		}
	}

}
