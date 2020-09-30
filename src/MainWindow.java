import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	protected MegDatabase Data;

	/**
	 * Create the frame.
	 */
	public MainWindow(MegDatabase data) {
		this.Data = data;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnDeposit = new JButton("DEPOSIT");
		btnDeposit.setBackground(new Color(255, 228, 225));
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposit deposit = new Deposit(Data);
				deposit.setVisible(true);
			}
		});
		btnDeposit.setBounds(30, 92, 115, 41);
		contentPane.add(btnDeposit);

		JButton btnWithdrawal = new JButton("WITHDRAWAL");
		btnWithdrawal.setBackground(new Color(255, 228, 225));
		btnWithdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean permit = Data.withdrawalPermit();
				if(permit == true) {
					Withdrawal withdraw = new Withdrawal(Data);
					withdraw.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "TRANSACTION CANNOT BE PERMITTED. NOT ENOUGH FUNDS");
				}

			}
		});
		btnWithdrawal.setBounds(263, 92, 108, 41);
		contentPane.add(btnWithdrawal);

		JButton btnCheckBalance = new JButton("CHECK BALANCE");
		btnCheckBalance.setBackground(new Color(255, 228, 225));
		btnCheckBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "YOU HAVE " + Data.getAmount() + "");
				Continue wannaContinue = new Continue(Data);
				wannaContinue.setVisible(true);
			}
		});
		btnCheckBalance.setBounds(30, 181, 115, 41);
		contentPane.add(btnCheckBalance);

		JButton btnChangePin = new JButton("CHANGE PIN");
		btnChangePin.setBackground(new Color(255, 228, 225));
		btnChangePin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePin newPin = new ChangePin(Data);
				newPin.setVisible(true);
			}
		});
		btnChangePin.setBounds(263, 181, 108, 41);
		contentPane.add(btnChangePin);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setFont(new Font("Stencil", Font.PLAIN, 30));
		lblWelcome.setForeground(new Color(85, 107, 47));
		lblWelcome.setBackground(new Color(47, 79, 79));
		lblWelcome.setBounds(133, 26, 163, 41);
		contentPane.add(lblWelcome);
	}
}
