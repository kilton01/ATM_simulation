import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

public class Amount extends JFrame {

	private JPanel contentPane;
	private JTextField Input;
	protected MegDatabase Data;
	protected int userAmount;

	/**
	 * Create the frame.
	 */
	public Amount(MegDatabase data) {
		this.Data = data;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnProceed = new JButton("PROCEED");
		btnProceed.setBackground(new Color(255, 228, 225));
		btnProceed.setFont(new Font("Stencil", Font.PLAIN, 14));
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userAmount = java.lang.Integer.parseInt(Input.getText());
				if (Data.getAmount()-userAmount < 10) {
					JOptionPane.showMessageDialog(null, "YOU DO NOT HAVE ENOUGH BALANCE TO MAKE THIS TRANSACTION");
				} else {
					int newAmount = Data.getAmount()-userAmount;
					Data.setAmount(newAmount);
					System.out.println(newAmount);
					JOptionPane.showMessageDialog(null, "YOU HAVE SUCCESSFULLY WITHDRAWN");
				}
				Continue wannaContinue = new Continue(Data);
				wannaContinue.setVisible(true);
			}
		});
		btnProceed.setBounds(146, 168, 133, 44);
		contentPane.add(btnProceed);

		Input = new JTextField();
		Input.setBounds(56, 93, 301, 44);
		contentPane.add(Input);
		Input.setColumns(10);

		JLabel lblEnterAmount = new JLabel("ENTER AMOUNT");
		lblEnterAmount.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblEnterAmount.setBounds(56, 48, 140, 34);
		contentPane.add(lblEnterAmount);
	}

}
