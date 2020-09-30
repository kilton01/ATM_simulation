import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;

public class MegaPlatform {

	JFrame frame;
	protected JTextField accountNumber;
	protected JPasswordField pinCode;
	protected MegDatabase Data;

	/**
	 * Create the application.
	 */
	public MegaPlatform(MegDatabase data) {
		this.Data = data;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 205));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnProceed = new JButton("PROCEED");
		btnProceed.setBounds(128, 203, 166, 47);
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String acc = accountNumber.getText();
				int pin = java.lang.Integer.parseInt(pinCode.getText());
				String c = Data.getClientInfo(acc,pin);
				if (c != null) {
					JOptionPane.showMessageDialog(null, "YOU HAVE SUCCESSFULLY LOGGED IN AS "+ c.toUpperCase());
					MainWindow window = new MainWindow(Data);
					window.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "INVALID ACCOUNT NUMBER OR PIN CODE");
				}



			}
		});
		frame.getContentPane().setLayout(null);

		JLabel lblEnter = new JLabel(" ENTER ACCOUNT NUMBER");
		lblEnter.setBounds(125, 69, 179, 17);
		lblEnter.setFont(new Font("Tahoma", Font.ITALIC, 14));
		frame.getContentPane().add(lblEnter);

		accountNumber = new JTextField();
		accountNumber.setBounds(57, 97, 305, 25);
		frame.getContentPane().add(accountNumber);
		accountNumber.setColumns(10);

		JLabel lblEnterPinCode = new JLabel("ENTER PIN CODE");
		lblEnterPinCode.setBounds(154, 133, 118, 17);
		lblEnterPinCode.setFont(new Font("Tahoma", Font.ITALIC, 14));
		frame.getContentPane().add(lblEnterPinCode);

		pinCode = new JPasswordField();
		pinCode.setBounds(57, 161, 305, 25);
		frame.getContentPane().add(pinCode);
		btnProceed.setBackground(new Color(245, 245, 220));
		btnProceed.setFont(new Font("Stencil", Font.ITALIC, 15));
		frame.getContentPane().add(btnProceed);

		JLabel label = new JLabel("MEG BANK");
		label.setFont(new Font("Stencil Std", Font.BOLD, 36));
		label.setBounds(109, 0, 224, 37);
		frame.getContentPane().add(label);
	}
}
