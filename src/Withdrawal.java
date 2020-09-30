import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Withdrawal extends JFrame {

	private JPanel contentPane;
	protected MegDatabase Data;

	/**
	 * Create the frame.
	 */
	public Withdrawal(MegDatabase data) {
		this.Data = data;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("100");
		button.setBackground(new Color(255, 235, 205));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Data.getAmount()-100 < 10) {
					JOptionPane.showMessageDialog(null, "YOU DO NOT HAVE ENOUGH BALANCE TO MAKE THIS TRANSACTION");
				} else {
					int newAmount = Data.getAmount()-100;
					Data.setAmount(newAmount);
					System.out.println(newAmount);
					JOptionPane.showMessageDialog(null, "YOU HAVE SUCCESSFULLY WITHDRAWN");
				}
				Continue wannaContinue = new Continue(Data);
				wannaContinue.setVisible(true);
			}
		});
		button.setBounds(31, 106, 115, 50);
		contentPane.add(button);
		
		JButton button_1 = new JButton("200");
		button_1.setBackground(new Color(255, 250, 205));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Data.getAmount()-200 < 10) {
					JOptionPane.showMessageDialog(null, "YOU DO NOT HAVE ENOUGH BALANCE TO MAKE THIS TRANSACTION");
				} else {
					int newAmount = Data.getAmount()-200;
					Data.setAmount(newAmount);
					System.out.println(newAmount);
					JOptionPane.showMessageDialog(null, "YOU HAVE SUCCESSFULLY WITHDRAWN");
				}
				Continue wannaContinue = new Continue(Data);
				wannaContinue.setVisible(true);
			}
		});
		button_1.setBounds(31, 173, 115, 50);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("500");
		button_2.setBackground(new Color(250, 250, 210));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Data.getAmount()-500 < 10) {
					JOptionPane.showMessageDialog(null, "YOU DO NOT HAVE ENOUGH BALANCE TO MAKE THIS TRANSACTION");
				} else {
					int newAmount = Data.getAmount()-500;
					Data.setAmount(newAmount);
					System.out.println(newAmount);
					JOptionPane.showMessageDialog(null, "YOU HAVE SUCCESSFULLY WITHDRAWN");
				}
				Continue wannaContinue = new Continue(Data);
				wannaContinue.setVisible(true);
			}
		});
		button_2.setBounds(237, 36, 104, 50);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("50");
		button_3.setBackground(new Color(250, 250, 210));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Data.getAmount()-50 < 10) {
					JOptionPane.showMessageDialog(null, "YOU DO NOT HAVE ENOUGH BALANCE TO MAKE THIS TRANSACTION");
				} else {
					int newAmount = Data.getAmount()-50;
					Data.setAmount(newAmount);
					System.out.println(newAmount);
					JOptionPane.showMessageDialog(null, "YOU HAVE SUCCESSFULLY WITHDRAWN");
				}
				Continue wannaContinue = new Continue(Data);
				wannaContinue.setVisible(true);
			}
		});
		button_3.setBounds(31, 36, 115, 50);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("1000");
		button_4.setBackground(new Color(255, 239, 213));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Data.getAmount()-1000 < 10) {
					JOptionPane.showMessageDialog(null, "YOU DO NOT HAVE ENOUGH BALANCE TO MAKE THIS TRANSACTION");
				} else {
					int newAmount = Data.getAmount()-1000;
					Data.setAmount(newAmount);
					System.out.println(newAmount);
					JOptionPane.showMessageDialog(null, "YOU HAVE SUCCESSFULLY WITHDRAWN");
				}
				Continue wannaContinue = new Continue(Data);
				wannaContinue.setVisible(true);
			}
		});
		button_4.setBounds(237, 107, 104, 48);
		contentPane.add(button_4);
		
		JButton btnOther = new JButton("Other");
		btnOther.setBackground(new Color(250, 235, 215));
		btnOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Amount amount = new Amount(Data);
				amount.setVisible(true);
			}
		});
		btnOther.setBounds(237, 173, 104, 50);
		contentPane.add(btnOther);
	}

}
