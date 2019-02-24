package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;

public class Sobre_1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre_1 frame = new Sobre_1();
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
	public Sobre_1() {
		setTitle("Sobre");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 676, 549);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.highlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSobreOPrograma = new JLabel("Sobre o Programa");
		lblSobreOPrograma.setBounds(123, 31, 246, 22);
		lblSobreOPrograma.setHorizontalAlignment(SwingConstants.CENTER);
		lblSobreOPrograma.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblSobreOPrograma);
		
		JLabel lblContato = new JLabel("Contato (48) 99897898");
		lblContato.setBounds(10, 420, 173, 36);
		contentPane.add(lblContato);
		
		JLabel lblEsteProgramaFoi = new JLabel("Este programa foi criado para utilizar na farmacia.Com intuito de automatizar o sistema.");
		lblEsteProgramaFoi.setBounds(10, 368, 629, 59);
		lblEsteProgramaFoi.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblEsteProgramaFoi);
		
		JLabel lblEmail = new JLabel("email: jhully.souza@aluno.sc.senac.br");
		lblEmail.setBounds(12, 468, 300, 15);
		contentPane.add(lblEmail);
		
		JLabel lblFacebookJhully = new JLabel("Facebook : Jhully Muller");
		lblFacebookJhully.setBounds(10, 495, 205, 15);
		contentPane.add(lblFacebookJhully);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Sobre_1.class.getResource("/icones/sobre.png")));
		lblNewLabel.setBounds(133, 76, 314, 245);
		contentPane.add(lblNewLabel);
		
		JLabel lblVerso = new JLabel("Vers\u00E3o 1.0");
		lblVerso.setForeground(Color.BLACK);
		lblVerso.setBounds(211, 333, 116, 15);
		contentPane.add(lblVerso);
		
	}
}
