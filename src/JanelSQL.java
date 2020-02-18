import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelSQL {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelSQL window = new JanelSQL();
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelSQL() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SQL APP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Source Code Pro Black", Font.PLAIN, 18));
		lblNewLabel.setBounds(172, 16, 91, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JButton buton = new JButton("Enviar");
		buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexao cx = new Conexao();
				String valor = textField.getText();
				cx.Conect();
				cx.Insert(valor);
				cx.Fechar();

			}
		});
		buton.setBounds(148, 149, 115, 29);
		frame.getContentPane().add(buton);
		
		textField = new JTextField();
		textField.setBounds(106, 107, 225, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(179, 77, 69, 20);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
