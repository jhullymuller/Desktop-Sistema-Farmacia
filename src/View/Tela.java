package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import control.ClienteControl;
import control.MedicamentoControl;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;

public class Tela extends JFrame {
	private JDesktopPane desktopPane;
	private CadastroCliente cadastroCliente;
	private JPanel contentPane;
	private CadastroMedicamento cadastroMedicamento;
	private Receita receita = null;
	private Sobre_1 sobre_1;
	private Ajuda ajuda;
	private NovaVenda novaVenda;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void mostrarCadastroMedicamento() {
		if (cadastroMedicamento == null) {
			cadastroMedicamento = new CadastroMedicamento();
			desktopPane.add(cadastroMedicamento);
			cadastroMedicamento.show();
		} else if (cadastroMedicamento != null) {
			cadastroMedicamento.setVisible(true);
		}
	}

	private void mostrarCadastroCliente() {
		if (cadastroCliente == null) {
			cadastroCliente = new CadastroCliente();
			desktopPane.add(cadastroCliente);
			cadastroCliente.show();
		} else if (cadastroCliente != null) {
			cadastroCliente.setVisible(true);
		}
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setBackground(UIManager.getColor("Table.dropCellBackground"));
		setTitle("Farmacia da Jhully");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 700);
		contentPane = new JPanel();
		contentPane.setToolTipText("Vendas");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("Button.shadow"));
		menuBar.setBounds(0, 0, 1010, 57);
		contentPane.add(menuBar);

		JMenu mnMedicamentos = new JMenu("Estoque");
		mnMedicamentos.setIcon(new ImageIcon(Tela.class.getResource("/icones/icons8-livro-de-fisica.png")));
		menuBar.add(mnMedicamentos);

		JMenuItem mntmRe = new JMenuItem("Relatorio Medicamento");
		mntmRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnMedicamentos.add(mntmRe);
			}
		});

		JMenuItem mntmNovoMedicamento = new JMenuItem("Novo Medicamento");
		mntmNovoMedicamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCadastroMedicamento();
			}
		});
		mnMedicamentos.add(mntmNovoMedicamento);

		JMenu mnVendas = new JMenu("Vendas");
		mnVendas.setIcon(new ImageIcon(Tela.class.getResource("/icones/icons8-comprar.png")));
		menuBar.add(mnVendas);

		JMenuItem mntmRealizarVenda = new JMenuItem("Realizar Venda");
		mntmRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (novaVenda== null) {
					novaVenda = new NovaVenda();
					desktopPane.add(novaVenda);
					novaVenda.show();
				} else if (novaVenda != null) {
					novaVenda.setVisible(true);
				}
			}
		});
		mnVendas.add(mntmRealizarVenda);

		JMenuItem mntmRelatorioDeVendas = new JMenuItem("Relatorio de Vendas");
		mntmRelatorioDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnVendas.add(mntmRelatorioDeVendas);

		JMenu mnCliente = new JMenu("Cliente ");
		mnCliente.setIcon(new ImageIcon(Tela.class.getResource("/icones/icons8-treinamento.png")));
		menuBar.add(mnCliente);

		JMenuItem mntmNovoCliente = new JMenuItem("Novo Cliente");
		mntmNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCadastroCliente();
			}
		});
		mnCliente.add(mntmNovoCliente);

		JMenuItem mntmReceitas = new JMenuItem("Receitas por Cliente");
		mntmReceitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (receita == null) {
					receita = new Receita();
					desktopPane.add(receita);
					receita.show();
				} else if (receita != null) {
					receita.setVisible(true);
				}
			}
		});
		mnCliente.add(mntmReceitas);

		JMenu Sobre = new JMenu("help");
		Sobre.setIcon(new ImageIcon(Tela.class.getResource("/icones/icons8-suporte-on-line-filled.png")));
		menuBar.add(Sobre);

		JMenuItem mntmSobrePrograma = new JMenuItem("Sobre Programa");
		mntmSobrePrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre_1 sobre = new Sobre_1();
				sobre.setVisible(true);

			}
		});
		Sobre.add(mntmSobrePrograma);

		JMenuItem mntmAjuda = new JMenuItem("Ajuda?");
		mntmAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ajuda == null) {
					ajuda = new Ajuda();
					desktopPane.add(ajuda);
					ajuda.show();
				} else if (ajuda != null) {
					ajuda.setVisible(true);
				}
			}
		});
		Sobre.add(mntmAjuda);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(UIManager.getColor("ComboBox.disabledForeground"));
		desktopPane.setBounds(10, 74, 1000, 600);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("FARMACIA  JHULLY");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(155, 155, 253, 43);
		desktopPane.add(lblNewLabel);

		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(
				"/home/jhully/Downloads/Trabalho final Renato/624dd0a951a1e8a118215b1b24a0da59-logotipo-da-farm-cia-by-vexels.png"));
		lblImage.setBounds(331, 26, 607, 429);
		desktopPane.add(lblImage);
	}
}
