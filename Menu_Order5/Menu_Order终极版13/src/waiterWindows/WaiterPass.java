package waiterWindows;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import entity.Enwaiter;
import javax.swing.JPasswordField;

import Domain.WaiterClass;

public class WaiterPass {

	private JFrame frame;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	public WaiterPass(int id) {
		int sid = id;
		initialize(sid);
	}

	private void initialize(final int id) {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("����Ա�����޸�");
		lblNewLabel.setBounds(155, 10, 93, 42);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("������");
		lblNewLabel_1.setBounds(117, 62, 50, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("������");
		lblNewLabel_2.setBounds(117, 112, 50, 23);
		frame.getContentPane().add(lblNewLabel_2);

		final JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.setBounds(139, 188, 93, 23);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String passwd = passwordField.getText();
				Enwaiter enwaiter = new Enwaiter();

				WaiterClass waiterClass = enwaiter.wav(id);
				if (passwd.equals(waiterClass.passwd)) {
					System.out.println(id);
					enwaiter.correct(id, passwordField_1.getText());

				} else {
					JOptionPane.showMessageDialog(btnNewButton, "�������", "��ʾ",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		frame.getContentPane().add(btnNewButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(207, 58, 147, 27);
		frame.getContentPane().add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(207, 110, 147, 27);
		frame.getContentPane().add(passwordField_1);
	}
}
