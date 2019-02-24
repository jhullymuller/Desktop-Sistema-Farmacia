package control;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import dao.ClienteDAO;
import model.Cliente;

public class ClienteControl implements ControlI {
	private JTextField txtbuscar;
	private JTable table;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField textTelefone;
	private JTextField textEndereco;
	private ClienteDAO clienteDao;
	private Cliente cliente;
	

	public ClienteControl(JTextField txtbuscar, JTable table,JTextField txtNome, JTextField txtCpf, JTextField textTelefone,
			JTextField textEndereco)  {
		super();
		this.txtbuscar = txtbuscar;
		this.table = table;
		this.txtNome = txtNome;
		this.txtCpf = txtCpf;
		this.textTelefone = textTelefone;
		this.textEndereco = textEndereco;
		this.clienteDao = new ClienteDAO();
	}

	

	public void listar() {
		List<Cliente> lista = clienteDao.listar(txtbuscar.getText());
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (Cliente cliente : lista) {
			model.addRow(new Object[] { cliente.getIdcliente(), cliente.getNome(), cliente.getCpf(), cliente.getTelefone(),
					cliente.getEndereco() });
		}
	}

	public void deletar() {
		setClienteSelecionada();
		if (cliente == null) {
			JOptionPane.showMessageDialog(null, "Selecione um cliente");
			return;
		}
		boolean deletada = clienteDao.deletar(cliente);
		if (deletada) {
			listar();
			JOptionPane.showMessageDialog(null, "Sucesso");
			listar();
		} else {
			JOptionPane.showMessageDialog(null, "Erro");
		}
	}

	private Cliente setClienteSelecionada() {
		int linhaSelecionada = table.getSelectedRow();
		Integer id = (Integer) table.getModel().getValueAt(linhaSelecionada, 0);
		String nome = (String) table.getModel().getValueAt(linhaSelecionada, 1);
		String cpf = (String) table.getModel().getValueAt(linhaSelecionada, 2);
		Integer telefone = (Integer) table.getModel().getValueAt(linhaSelecionada, 3);
		String endereco = (String) table.getModel().getValueAt(linhaSelecionada, 4);
		cliente = new Cliente();
		cliente.setIdcliente(id);
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setTelefone(telefone);
		cliente.setEndereco(endereco);
		return cliente;

	}

	public void salvar() {
		if (cliente == null) {
			cliente = new Cliente();
		}
		cliente.setNome(txtNome.getText());
		cliente.setCpf(txtCpf.getText());
		cliente.setTelefone(textTelefone.getX());
		cliente.setEndereco(textEndereco.getText());
		boolean salvo = false;
		if (cliente.getIdcliente() != null) {
			salvo = clienteDao.alterar(cliente);
		} else {
			salvo = clienteDao.cadastrar(cliente);
		}
		if (salvo) {
			JOptionPane.showMessageDialog(null, "Sucesso");
			limpa();
			listar();
		} else {
			JOptionPane.showMessageDialog(null, "Erro");
		}
		cliente = null;
	}

	public void editar() {
		setClienteSelecionada();
		txtNome.setText(cliente.getNome());
		txtCpf.setText(cliente.getCpf().toString());
		textTelefone.setText(cliente.getTelefone().toString());
		textEndereco.setText(cliente.getEndereco());
	}

	public void limpa() {
		cliente = new Cliente();
		txtNome.setText("");
		txtCpf.setText("");
		textTelefone.setText("");
		textEndereco.setText("");
	}
}
