package ManageOperate;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.JButton;
import Dao.ManageOperate;
import javax.swing.JPasswordField;
public class add_Chief implements ActionListener {

	private JFrame frame;
	private JTextField textField_1;
	JButton add;
	JButton reset;
	private JPasswordField passwordField;
	public add_Chief() {
		initialize();
		frame.setVisible(true);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 400);
		frame.getContentPane().setLayout(null);
		//����
		JLabel lblNewLabel = new JLabel("\u6DFB\u52A0\u53A8\u5E08");
		lblNewLabel.setBounds(210, 26, 78, 24);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel);
		//�û���
		JLabel name = new JLabel("\u59D3\u540D");
		name.setBounds(125, 117, 54, 15);
		name.setFont(new Font("����", Font.PLAIN, 14));
		frame.getContentPane().add(name);
		//����
		JLabel passwd = new JLabel("\u5BC6\u7801");
		passwd.setBounds(125, 188, 54, 15);
		passwd.setFont(new Font("����", Font.PLAIN, 14));
		frame.getContentPane().add(passwd);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 114, 151, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		//���
		add = new JButton("\u6DFB\u52A0");
		add.setBounds(173, 300, 63, 23);
		add.addActionListener(this);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(210, 185, 151, 21);
		frame.getContentPane().add(passwordField);
		frame.getContentPane().add(add);
		//����
		reset = new JButton("\u91CD\u7F6E");
		reset.setBounds(268, 300, 63, 23);
		reset.addActionListener(this);
		frame.getContentPane().add(reset);
	}
	public void actionPerformed(ActionEvent e) {
		//���
		if(e.getSource() == add) {
			ManageOperate man = new ManageOperate();
			try {
				int t=man.addChief(textField_1.getText(), passwordField.getText());
				JOptionPane.showMessageDialog(add, "����Ա�˺�Ϊ��"+t);
				frame.dispose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource() == reset){
			textField_1.setText("");
			passwordField.setText("");
			
		}
	}
}
