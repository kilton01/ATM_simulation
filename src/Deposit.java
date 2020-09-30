import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Deposit extends JFrame {

	private JPanel contentPane;
	protected MegDatabase Data;
	private JTextField amount;
	private JPasswordField pinCode;

	/**
	 * Create the frame.
	 */
	public Deposit(MegDatabase data) {
		this.Data = data;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterAmount = new JLabel("ENTER AMOUNT");
		lblEnterAmount.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblEnterAmount.setBounds(36, 41, 241, 22);
		contentPane.add(lblEnterAmount);

		amount = new JTextField();
		amount.setBounds(36, 69, 332, 31);
		contentPane.add(amount);
		amount.setColumns(10);

		JLabel lblEnterPinCode = new JLabel("ENTER PIN CODE");
		lblEnterPinCode.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblEnterPinCode.setBounds(36, 121, 241, 22);
		contentPane.add(lblEnterPinCode);

		pinCode = new JPasswordField();
		pinCode.setBounds(36, 154, 332, 31);
		contentPane.add(pinCode);
		pinCode.setColumns(10);

		JButton proceed = new JButton("PROCEED");
		proceed.setBackground(new Color(255, 228, 225));
		proceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pin = java.lang.Integer.parseInt(pinCode.getText());
				int deposit = java.lang.Integer.parseInt(amount.getText());
				if (Data.getPinCode() == pin ) {
					int newAmount = Data.getAmount() + deposit;
					Data.setAmount(newAmount);
					JOptionPane.showMessageDialog(null, "YOUR NEW BALANCE IS "+ Data.getAmount());
				} else {
					JOptionPane.showMessageDialog(null, "PIN CODE INCORRECT");
				}
				Continue wannaContinue = new Continue(Data);
				wannaContinue.setVisible(true);

			}
		});
		proceed.setFont(new Font("Stencil", Font.PLAIN, 14));
		proceed.setBounds(128, 211, 127, 39);
		contentPane.add(proceed);
	}

}
