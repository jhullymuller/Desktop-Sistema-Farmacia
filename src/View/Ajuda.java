package View;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ajuda extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajuda frame = new Ajuda();
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
	public Ajuda() {
		setClosable(true);
		setTitle("Ajuda");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblTireSuasDvidas = new JLabel("Tire as suas D\u00FAvidas");
		lblTireSuasDvidas.setBounds(44, 38, 189, 19);
		lblTireSuasDvidas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		getContentPane().add(lblTireSuasDvidas);
		
		JLabel lblDigiteASua = new JLabel("Digite a sua Duvida :");
		lblDigiteASua.setBounds(10, 83, 143, 19);
		lblDigiteASua.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(lblDigiteASua);
		
		textField = new JTextField();
		textField.setBounds(10, 112, 143, 36);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnPesquisar.setBounds(168, 119, 89, 23);
		getContentPane().add(btnPesquisar);
		
		JButton btnWwwgooglecom = new JButton("www.google.com");
		btnWwwgooglecom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					try {
						URI uri = new URI("https://www.google.com.br");
						Desktop.getDesktop().browse(uri);
					} catch (IOException | URISyntaxException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnWwwgooglecom.setBounds(12, 191, 226, 25);
		getContentPane().add(btnWwwgooglecom);

	}
}
