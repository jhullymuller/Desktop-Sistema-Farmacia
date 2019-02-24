package control;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.MedicamentoDAO;
import model.Medicamento;

public class MedicamentoControl implements ControlI {
	private JTextField txtnomeMedicamento;
	private JTextField txtquantidade;
	private JTextField textValor;
	private MedicamentoDAO medicamentoDAO;
	private JTable table;
	private JTextField tfBusca;
	private Medicamento medicamento;

	public MedicamentoControl(JTable table, JTextField tfBusca, JTextField txtnomeMedicamento, JTextField txtquantidade, JTextField textValor) {
		this.table = table;
		this.tfBusca = tfBusca;
		this.txtnomeMedicamento = txtnomeMedicamento;
		this.txtquantidade = txtquantidade;
		this.textValor = textValor;
		this.medicamentoDAO = new MedicamentoDAO();
	}

	public void listar() {
		List<Medicamento> lista = medicamentoDAO.listar(tfBusca.getText());
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (Medicamento medicamento : lista) {
			model.addRow(new Object[] { medicamento.getIdMedicamento(), medicamento.getNome(),
					medicamento.getQuantidade(), medicamento.getValor() });
		}
	}

	public void iniciacadastro(JTextField txtnomeMedicamento, JTextField txtquantidade, JTextField textValor) {
		this.txtnomeMedicamento = txtnomeMedicamento;
		this.txtquantidade = txtquantidade;
		this.textValor = textValor;

	}

	public void deletar() {
		setCadastroMedicamentoSelecionada();
		if (medicamento == null) {
			JOptionPane.showMessageDialog(null, "Selecione um medicamento");
			return;
		}
		boolean deletada = medicamentoDAO.deletar(medicamento);
		if (deletada) {
			listar();
			JOptionPane.showMessageDialog(null, "Sucesso");
			listar();

		} else {
			JOptionPane.showMessageDialog(null, "Erro");
		}
	}

	private Medicamento setCadastroMedicamentoSelecionada() {
		int linhaSelecionada = table.getSelectedRow();
		Integer id = (Integer) table.getModel().getValueAt(linhaSelecionada, 0);
		String nome = (String) table.getModel().getValueAt(linhaSelecionada, 1);
		Integer quantidade = (Integer) table.getModel().getValueAt(linhaSelecionada, 2);
		Double valor = (Double) table.getModel().getValueAt(linhaSelecionada, 3);
		medicamento = new Medicamento();
		medicamento.setIdMedicamento(id);
		medicamento.setNome(nome);
		medicamento.setQuantidade(quantidade);
		medicamento.setValor(valor);
		return medicamento;

	}

	public void salvar() {
		if (medicamento == null) {
			medicamento = new Medicamento();
		}
		medicamento.setNome(txtnomeMedicamento.getText());
		medicamento.setQuantidade(Integer.parseInt(txtquantidade.getText()));
		medicamento.setValor(Double.parseDouble(textValor.getText()));
		boolean salvo = false;
		if (medicamento.getIdMedicamento() != null) {
			salvo = medicamentoDAO.alterar(medicamento);
		} else {
			salvo = medicamentoDAO.cadastrar(medicamento);
		}
		if (salvo) {
			JOptionPane.showMessageDialog(null, "Sucesso");
			limpar();
			listar();

			
		} else {
			JOptionPane.showMessageDialog(null, "Erro");
		}
		medicamento = null;
		
	}

	public void editar() {
		setCadastroMedicamentoSelecionada();
		txtnomeMedicamento.setText(medicamento.getNome());
		txtquantidade.setText(medicamento.getQuantidade().toString());
		textValor.setText(medicamento.getValor().toString());
	}

	public void limpar() {
		medicamento = new Medicamento();
		txtnomeMedicamento.setText("");
		txtquantidade.setText("");
		textValor.setText("");
	}
}
