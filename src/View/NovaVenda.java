package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import control.NovaVendaControl;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NovaVenda extends JInternalFrame {
	private JTextField txtquantidade;
	private JTable table;
	private JTextField textValorPago;
	private NovaVendaControl novaVendaControl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovaVenda frame = new NovaVenda();
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
	public NovaVenda() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				novaVendaControl.listarCLiente();
				novaVendaControl.listarProdutoMedicamento();
				novaVendaControl.listarReceita();
			}
		});

		setClosable(true);
		setTitle("Venda");
		setBounds(100, 100, 527, 473);
		getContentPane().setLayout(null);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novaVendaControl.adicionarMedicamento();
			}
		});
		btnAdicionar.setBounds(392, 74, 108, 25);
		getContentPane().add(btnAdicionar);

		JComboBox comboProduto = new JComboBox();
		comboProduto.setBounds(0, 74, 134, 24);
		getContentPane().add(comboProduto);

		txtquantidade = new JTextField();
		txtquantidade.setBounds(146, 77, 56, 19);
		getContentPane().add(txtquantidade);
		txtquantidade.setColumns(10);

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(12, 58, 70, 15);
		getContentPane().add(lblProduto);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(146, 58, 91, 15);
		getContentPane().add(lblQuantidade);

		JButton btnRemoverProduto = new JButton("Remover Produto");
		btnRemoverProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novaVendaControl.removerMedicamento();
			}
		});
		btnRemoverProduto.setBounds(12, 308, 180, 25);
		getContentPane().add(btnRemoverProduto);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(238, 313, 56, 15);
		getContentPane().add(lblTotal);

		JLabel lblValorTotal = new JLabel("");
		lblValorTotal.setBounds(293, 310, 70, 19);
		getContentPane().add(lblValorTotal);

		JButton btnFinalizarCompra = new JButton("Finalizar Compra");
		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novaVendaControl.salvar();
				
			}
		});
		btnFinalizarCompra.setBounds(299, 393, 153, 25);
		getContentPane().add(btnFinalizarCompra);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 111, 489, 196);
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
				new DefaultTableModel(new Object[][] {}, new String[] { "Produto", "Receita", "Quantidade", "Valor" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		scrollPane.setViewportView(table);

		JLabel lblValorPago = new JLabel("Valor Pago:");
		lblValorPago.setBounds(202, 337, 83, 15);
		getContentPane().add(lblValorPago);

		textValorPago = new JTextField();
		textValorPago.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				novaVendaControl.calculaTroco();
			}
		});
		textValorPago.setColumns(10);
		textValorPago.setBounds(303, 341, 114, 19);
		getContentPane().add(textValorPago);

		JLabel lblTipoPagamento = new JLabel("Tipo Pagamento");
		lblTipoPagamento.setBounds(0, 345, 134, 15);
		getContentPane().add(lblTipoPagamento);

		JLabel labelTroco = new JLabel("Troco:");
		labelTroco.setBounds(228, 362, 56, 15);
		getContentPane().add(labelTroco);

		JComboBox comboCliente = new JComboBox();
		comboCliente.setBounds(11, 22, 123, 24);
		getContentPane().add(comboCliente);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(12, 0, 70, 15);
		getContentPane().add(lblCliente);

		JComboBox comboReceita = new JComboBox();
		comboReceita.setBounds(240, 74, 123, 24);
		getContentPane().add(comboReceita);

		JLabel lblReceita = new JLabel("Receita");
		lblReceita.setBounds(249, 58, 70, 15);
		getContentPane().add(lblReceita);

		JLabel labelValorTroco = new JLabel("");
		labelValorTroco.setBounds(299, 362, 70, 15);
		getContentPane().add(labelValorTroco);

		JComboBox cbFormaPagamento = new JComboBox();
		cbFormaPagamento.setModel(new DefaultComboBoxModel(new String[] { "Dinheiro", "Debito", "Credito" }));
		cbFormaPagamento.setToolTipText("Dinheiro Debito Credito");
		cbFormaPagamento.setBounds(10, 368, 158, 24);
		getContentPane().add(cbFormaPagamento);
		novaVendaControl = new NovaVendaControl(comboCliente, comboProduto, comboReceita, txtquantidade, table,
				cbFormaPagamento, textValorPago, lblValorTotal, labelValorTroco);
	}
}
