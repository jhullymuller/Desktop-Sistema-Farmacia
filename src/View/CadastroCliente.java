package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import control.ClienteControl;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CadastroCliente extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField textTelefone;
	private JTextField textEndereco;
	private ClienteControl clienteControl;
	private JTable table;
	private JTextField txtbuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void close() {
		this.setVisible(false);
	}
	
	/**
	 * Create the frame.
	 */
	public CadastroCliente() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				clienteControl.listar();
			}
		});
		setClosable(true);
		setTitle("Novo Cliente");
		setBounds(100, 100, 567, 496);
		getContentPane().setLayout(null);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente ");
		lblNomeDoCliente.setBounds(121, 0, 120, 20);
		getContentPane().add(lblNomeDoCliente);
		
		txtNome = new JTextField();
		txtNome.setBounds(80, 29, 263, 19);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(12, 62, 70, 15);
		getContentPane().add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(61, 60, 114, 19);
		getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(186, 60, 70, 15);
		getContentPane().add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(259, 60, 114, 19);
		getContentPane().add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setBounds(12, 105, 70, 15);
		getContentPane().add(lblEndereco);
		
		textEndereco = new JTextField();
		textEndereco.setBounds(85, 103, 324, 19);
		getContentPane().add(textEndereco);
		textEndereco.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clienteControl.salvar();
				
			}
		});
		btnSalvar.setBounds(12, 148, 117, 25);
		getContentPane().add(btnSalvar);
		
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clienteControl.deletar();
			
			}
		});
		btnExcluir.setBounds(292, 148, 117, 25);
		getContentPane().add(btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 254, 533, 198);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBounds(0, 0, 339, 67);
		table.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setToolTipText("ID\nNome\nCPF\n");
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Nome","CPF","Telefone","Endereço" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(167);
		scrollPane.setViewportView(table);
		
	
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clienteControl.editar();
			}
		});
		btnEditar.setBounds(151, 148, 117, 25);
		getContentPane().add(btnEditar);
		
		JLabel lblBuscarCliente = new JLabel("Buscar Cliente");
		lblBuscarCliente.setBounds(12, 201, 102, 15);
		getContentPane().add(lblBuscarCliente);
		
		txtbuscar = new JTextField();
		txtbuscar.setBounds(127, 199, 177, 19);
		getContentPane().add(txtbuscar);
		txtbuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clienteControl.listar();
			}
		});
		btnBuscar.setBounds(316, 196, 117, 25);
		getContentPane().add(btnBuscar);
		clienteControl = new ClienteControl(txtbuscar, table, txtNome, txtCpf, textTelefone, textEndereco);
	}
	

	public JTextField getTxtNome() {
		return txtNome;
	}

	public JTextField getTxtCpf() {
		return txtCpf;
	}

	public JTextField getTextTelefone() {
		return textTelefone;
	}

	public JTextField getTextEndereco() {
		return textEndereco;
	}

	public void setClienteControl(ClienteControl clienteControl) {
		this.clienteControl = clienteControl;
	}
}
