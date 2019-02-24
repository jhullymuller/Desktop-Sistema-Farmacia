package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import control.MedicamentoControl;
import dao.MedicamentoDAO;
import model.Medicamento;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CadastroMedicamento extends JInternalFrame {
	private JTextField txtnomeMedicamento;
	private JTextField txtquantidade;
	private JTextField textValor;
	private MedicamentoDAO medicamentoDao;
	private MedicamentoControl cadastroMedicamentoControl;
	private JTextField tfBusca;
	private JTable table;
	private MedicamentoControl medicamentoControl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroMedicamento frame = new CadastroMedicamento();
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

	public CadastroMedicamento() {
			addComponentListener(new ComponentAdapter() {
				@Override
				public void componentShown(ComponentEvent e) {
					medicamentoControl.listar();
				}
				});
		getContentPane().setBackground(UIManager.getColor("TabbedPane.unselectedBackground"));
		getContentPane().setForeground(new Color(51, 51, 51));
		setClosable(true);
		setTitle("Novo Medicamento");
		setBounds(100, 100, 534, 442);
		getContentPane().setLayout(null);

		JLabel lblNomeDoMedicamento = new JLabel("Nome do Medicamento:");
		lblNomeDoMedicamento.setBounds(85, 0, 171, 15);
		getContentPane().add(lblNomeDoMedicamento);

		txtnomeMedicamento = new JTextField();
		txtnomeMedicamento.setBounds(53, 23, 292, 19);
		getContentPane().add(txtnomeMedicamento);
		txtnomeMedicamento.setColumns(10);

		JLabel lblNewLabel = new JLabel("Quantidade");
		lblNewLabel.setBounds(63, 54, 100, 15);
		getContentPane().add(lblNewLabel);

		txtquantidade = new JTextField();
		txtquantidade.setBounds(76, 81, 70, 19);
		getContentPane().add(txtquantidade);
		txtquantidade.setColumns(10);

		JLabel lblPreo = new JLabel("Valor:");
		lblPreo.setBounds(186, 54, 70, 15);
		getContentPane().add(lblPreo);

		textValor = new JTextField();
		textValor.setBounds(175, 81, 70, 19);
		getContentPane().add(textValor);
		textValor.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medicamentoControl.salvar();
				
			}
		});
		btnSalvar.setBounds(171, 193, 117, 25);
		getContentPane().add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medicamentoControl.deletar();

			}
		});
		btnExcluir.setBounds(333, 193, 117, 25);
		getContentPane().add(btnExcluir);

		JLabel lblReceitaObrigatoria = new JLabel("Receita Obrigatoria");
		lblReceitaObrigatoria.setBounds(81, 112, 158, 15);
		getContentPane().add(lblReceitaObrigatoria);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sim", "Não"}));
		comboBox.setToolTipText("0-Sim 1-Nao");
		comboBox.setBounds(81, 140, 158, 24);
		getContentPane().add(comboBox);
		
		JButton buttonEditar = new JButton("Editar");
		buttonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medicamentoControl.editar();
			}
		});
		buttonEditar.setBounds(12, 193, 117, 25);
		getContentPane().add(buttonEditar);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(12, 234, 70, 15);
		getContentPane().add(lblBuscar);
		
		tfBusca = new JTextField();
		tfBusca.setBounds(66, 232, 207, 19);
		getContentPane().add(tfBusca);
		tfBusca.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(btnPesquisar);
				btnPesquisar.setBounds(291, 229, 117, 25);
			}
		});
	
	
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 261, 481, 137);
		getContentPane().add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setToolTipText("");
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID","Nome", "Quantidade", "Valor" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(167);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		scrollPane_1.setViewportView(table);
		 medicamentoControl = new MedicamentoControl(table, tfBusca, txtnomeMedicamento, txtquantidade, textValor);
		
	}

	public JTextField getTxtnomeMedicamento() {
		return txtnomeMedicamento;
	}

	public JTextField getTxtquantidade() {
		return txtquantidade;
	}

	public JTextField getTextValor() {
		return textValor;
	}
}
