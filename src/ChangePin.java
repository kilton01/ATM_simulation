import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.DatabaseMetaData;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class ChangePin extends JFrame {

	private JPanel contentPane;
	private JPasswordField oldPin;
	private JPasswordField newPin;
	private JPasswordField CnewPin;
	protected MegDatabase Data;

	/**
	 * Create the frame.
	 */
	public ChangePin(MegDatabase data) {
		this.Data = data;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBack = new JButton("CANCEL");
		btnBack.setBackground(new Color(255, 228, 225));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainWindow window = new MainWindow(Data);
				window.setVisible(true);
			}
		});
		btnBack.setBounds(191, 224, 97, 26);
		contentPane.add(btnBack);

		JLabel lblEnterOldPin = new JLabel("ENTER OLD PIN");
		lblEnterOldPin.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblEnterOldPin.setBounds(34, 23, 216, 23);
		contentPane.add(lblEnterOldPin);

		oldPin = new JPasswordField();
		oldPin.setBounds(34, 51, 263, 28);
		contentPane.add(oldPin);
		oldPin.setColumns(10);

		JLabel lblEnterNewPin = new JLabel("ENTER NEW PIN");
		lblEnterNewPin.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblEnterNewPin.setBounds(34, 94, 183, 20);
		contentPane.add(lblEnterNewPin);

		newPin = new JPasswordField();
		newPin.setBounds(34, 115, 263, 28);
		contentPane.add(newPin);
		newPin.setColumns(10);

		JLabel lblConfirmNewPin = new JLabel("CONFIRM NEW PIN");
		lblConfirmNewPin.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblConfirmNewPin.setBounds(33, 154, 184, 20);
		contentPane.add(lblConfirmNewPin);

		CnewPin = new JPasswordField();
		CnewPin.setBounds(34, 185, 263, 28);
		contentPane.add(CnewPin);
		CnewPin.setColumns(10);

		JButton btnSave = new JButton("SAVE");
		btnSave.setBackground(new Color(255, 228, 225));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int old = java.lang.Integer.parseInt(oldPin.getText());
				int newP = java.lang.Integer.parseInt(newPin.getText());
				int Conf = java.lang.Integer.parseInt(CnewPin.getText());

				String o = Data.pinCodeResetValidator(old);
				String n = Data.pinCodeResetValidator(newP);
				String m = Integer.toString(Data.getPinCode());
				if (o != null && o != m) {
					JOptionPane.showMessageDialog(null, o);
				} else {
					Data.pinChecker(old);
					if (n != null) {
						JOptionPane.showMessageDialog(null, n);
					} else {
						Data.pinRewrite(newP);
						if (newP == Conf) {
							JOptionPane.showMessageDialog(null, "PIN SUCCESSFULLY CHANGED");
							//JOptionPane.showInputDialog("Do you want to continue?");
						} else {
							JOptionPane.showMessageDialog(null, "INVALID PIN CODE. TRY AGAIN!!");
						}
					}
				}
				Continue wannaContinue = new Continue(Data);
				wannaContinue.setVisible(true);
			}			
		});
		btnSave.setBounds(44, 224, 97, 26);
		contentPane.add(btnSave);
	}
}
