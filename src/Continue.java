import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Continue extends JFrame {

	private JPanel contentPane;
	MegDatabase Data;

	/**
	 * Create the frame.
	 */
	public Continue(MegDatabase data) {
		this.Data = data;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDoYouWanna = new JLabel("DO YOU WANNA CONTINUE TRACNSACTION?");
		lblDoYouWanna.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblDoYouWanna.setBounds(10, 51, 287, 72);
		contentPane.add(lblDoYouWanna);

		JButton yes = new JButton("YES");
		yes.setBackground(new Color(255, 228, 225));
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainWindow window = new MainWindow(Data);
				window.setVisible(true);
			}
		});
		yes.setFont(new Font("Stencil", Font.PLAIN, 14));
		yes.setBounds(311, 126, 123, 41);
		contentPane.add(yes);

		JButton btnNo = new JButton("NO");
		btnNo.setBackground(new Color(255, 228, 225));
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "TRANSACTION COMPLETE.");
				MegaPlatform login = new MegaPlatform(Data);
				login.frame.setVisible(true);
			}
		});
		btnNo.setFont(new Font("Stencil", Font.PLAIN, 14));
		btnNo.setBounds(311, 180, 123, 41);
		contentPane.add(btnNo);
	}

}
