package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import control.ClienteControl;
import control.ReceitaControl;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class Receita extends JInternalFrame {
	private JTextField textCRS;
	private JTextField txtquantidade;
	private JTable table;
	private JTextField txtbuscar;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private ReceitaControl receitaControl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receita frame = new Receita();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Receita() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				receitaControl.listar();
				receitaControl.listarCLiente();
			}
		});
		
		setClosable(true);
		getContentPane().setForeground(Color.WHITE);
		setTitle("Receita");
		setBounds(100, 100, 521, 520);
		getContentPane().setLayout(null);
		
		JLabel lblTipoDaReceita = new JLabel("Tipo da Receita");
		lblTipoDaReceita.setBounds(135, 6, 109, 15);
		getContentPane().add(lblTipoDaReceita);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Médica", "Veterinária"}));
		comboBox.setBounds(135, 33, 151, 24);
		getContentPane().add(comboBox);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente");
		lblNomeDoCliente.setBounds(135, 69, 128, 15);
		getContentPane().add(lblNomeDoCliente);
		
		JLabel lblCrmCrv = new JLabel("CRM / CRV");
		lblCrmCrv.setBounds(110, 127, 70, 15);
		getContentPane().add(lblCrmCrv);
		
		textCRS = new JTextField();
		textCRS.setBounds(103, 154, 114, 19);
		getContentPane().add(textCRS);
		textCRS.setColumns(10);
		
		txtquantidade = new JTextField();
		txtquantidade.setBounds(267, 154, 114, 19);
		getContentPane().add(txtquantidade);
		txtquantidade.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receitaControl.salvar();
			}
		});
		btnSalvar.setBounds(186, 195, 117, 25);
		getContentPane().add(btnSalvar);
		
		JLabel lblQuantidadeDeCaixa = new JLabel("Quantidade De Caixa");
		lblQuantidadeDeCaixa.setBounds(257, 127, 151, 15);
		getContentPane().add(lblQuantidadeDeCaixa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 245, 487, 206);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setToolTipText("TipodaReceita \nCliente\nQuantidadeCaixa\n");
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		scrollPane.setViewportView(table);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "TipodaReceita", "Cliente", "Quantidade Caixa", "CRS" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(167);
		scrollPane.setViewportView(table);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(135, 91, 151, 24);
		getContentPane().add(comboBox_1);
		
		receitaControl = new ReceitaControl(comboBox_1, textCRS, txtquantidade, table, comboBox);
		
	}
}
