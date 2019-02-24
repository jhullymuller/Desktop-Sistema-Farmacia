package control;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.ClienteDAO;
import dao.ReceitaDao;
import model.Cliente;
import model.Medicamento;
import model.Receita;

public class ReceitaControl implements ControlI{
	private JComboBox comboBox_1;
	private JTextField textCRS;
	private JTextField txtquantidade;
	private ReceitaDao receitaDao;
	private Receita receita;
	private JTable table;
	private JComboBox combobox;
	private ClienteDAO clienteDao;
	

	public ReceitaControl(JComboBox comboBox_1, JTextField textCRS, JTextField txtquantidade, 
			JTable table, JComboBox combobox) {
		super();
		this.comboBox_1 = comboBox_1;
		this.textCRS = textCRS;
		this.txtquantidade = txtquantidade;
		this.table = table;
		this.combobox = combobox;
		this.receitaDao = new ReceitaDao();
		this.clienteDao =new ClienteDAO();
	}
	@Override
	public void listar() {
       List<Receita> lista = receitaDao.listar(null);
       DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (Receita  receita : lista) {
			model.addRow(new Object[] { receita.getIdreceita(), receita.getTipoReceita(), receita.getIdcliente(), receita.getQuantidadeCaixa()
					,receita.getCrs() });	
	}
	}
		public void listarCLiente(){
			 List<Cliente> lista = clienteDao.listar("");
			 for (int i = 0; i < lista.size(); i++) {
				Cliente cliente = lista.get(i);
				comboBox_1.addItem(cliente);
			}
		}

	@Override
	public void deletar() {

		setReceitaSelecionada();
		if (receita == null) {
			JOptionPane.showMessageDialog(null, "Selecione uma receita");
			return;
		}
		boolean deletada = receitaDao.deletar(receita);
		if (deletada) {
			listar();
			JOptionPane.showMessageDialog(null, "Sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Erro");
		}
	}

	private Receita  setReceitaSelecionada() {
		int linhaSelecionada = table.getSelectedRow();
		Integer id = (Integer) table.getModel().getValueAt(linhaSelecionada, 0);
		String nome = (String) table.getModel().getValueAt(linhaSelecionada, 1);
		Integer quantidade = (Integer) table.getModel().getValueAt(linhaSelecionada, 2);
		Double valor = (Double) table.getModel().getValueAt(linhaSelecionada, 3);
		receita = new Receita();
		receita.setIdreceita(id);
		receita.setTipoReceita(nome);
		receita.setQuantidadeCaixa(quantidade);
		return receita;

	}
	@Override
	public void salvar() {
		if (receita == null) {
			receita = new Receita();
		}
		receita.setIdcliente(buscarIdcliente());
		receita.setTipoReceita(buscarTipo());
		receita.setQuantidadeCaixa(Integer.parseInt(txtquantidade.getText()));
		receita.setCrs(textCRS.getText());
		boolean salvo = false;
		if (receita.getIdreceita() != null) {
			salvo = receitaDao.alterar(receita);
		} else {
			salvo = receitaDao.cadastrar(receita);
		}
		if (salvo) {
			JOptionPane.showMessageDialog(null, "Sucesso");
			limpar();
			listar();
		} else {
			JOptionPane.showMessageDialog(null, "Erro");
		} receita = null;
	} 

		private Integer buscarIdcliente() {
			Cliente cliente = (Cliente) comboBox_1.getSelectedItem();
			return cliente.getIdcliente();
		}
		
		private String buscarTipo( ) {
			return (String) combobox.getSelectedItem();
		}
	
	@Override
	public void editar() {
		setReceitaSelecionada();
		
		txtquantidade.setText(receita.getQuantidadeCaixa().toString());
		textCRS.setText(receita.getCrs().toString());
	}		
	
	public void limpar() {
		receita = new Receita();
		txtquantidade.setText("");
		textCRS.setText("");
	}		
	}
