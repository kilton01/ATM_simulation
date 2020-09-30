import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InternetBanking {

	JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	MegDatabase Data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the application.
	 */
	public InternetBanking(MegDatabase data) {
		this.Data = data;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(41, 100, 342, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(41, 174, 342, 31);
		frame.getContentPane().add(passwordField);
		
		JLabel lblEnterYourPassword = new JLabel("ENTER YOUR PASSWORD");
		lblEnterYourPassword.setFont(new Font("Stencil", Font.PLAIN, 13));
		lblEnterYourPassword.setBounds(41, 142, 329, 21);
		frame.getContentPane().add(lblEnterYourPassword);
		
		JLabel lblEnterName = new JLabel("ENTER NAME");
		lblEnterName.setFont(new Font("Stencil", Font.PLAIN, 13));
		lblEnterName.setBounds(41, 68, 329, 21);
		frame.getContentPane().add(lblEnterName);
		
		JLabel lblMegbankOnlineBanking = new JLabel("MEGBANK ONLINE BANKING PORTAL");
		lblMegbankOnlineBanking.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblMegbankOnlineBanking.setBounds(63, 26, 320, 31);
		frame.getContentPane().add(lblMegbankOnlineBanking);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pin = java.lang.Integer.parseInt(lblEnterYourPassword.getText());
				if (lblEnterName.getText().equals(Data.getName()) && pin == Data.getPinCode()) {
					HomePage home = new HomePage(Data);
					home.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "INVALID USERNAME OR PIN CODE");
				}
			}
		});
		btnLogin.setBounds(41, 216, 89, 23);
		frame.getContentPane().add(btnLogin);
	}
}
