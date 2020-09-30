import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;
	protected MegDatabase Data;

	/**
	 * Create the frame.
	 */
	public HomePage(MegDatabase data) {
		this.Data = data;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMegbank = new JLabel("MEGBANK");
		lblMegbank.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblMegbank.setBounds(10, 11, 87, 34);
		contentPane.add(lblMegbank);
		
		JButton btnNewButton_1 = new JButton("GENERATE TOKEN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long withdraw =Data.withdrawalToken();
				JOptionPane.showMessageDialog(null, "YOUR TOKEN IS: " + withdraw);
			}
		});
		btnNewButton_1.setBounds(10, 73, 133, 55);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ONLINE SHOPPING");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long credit = Data.ShoppingToken();
				JOptionPane.showMessageDialog(null, "YOUR SHOPPING TOKEN IS: " + credit);
			}
		});
		btnNewButton_2.setBounds(10, 156, 133, 60);
		contentPane.add(btnNewButton_2);
	}

}
