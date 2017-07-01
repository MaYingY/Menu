package ChiefManage;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;


import Dao.Main;
import Dao.ManageOperate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class ChiefLogin implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton login;
	private JButton reset;

	/**
	 * Create the application.
	 */
	public ChiefLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(310, 310, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		// ����Ա��½
		JLabel headname = new JLabel("\u53A8\u5E08\u767B\u5F55");
		headname.setBounds(223, 27, 136, 46);
		frame.getContentPane().add(headname);
		// �û���
		JLabel username = new JLabel("\u7528\u6237\u540D");
		username.setBounds(164, 102, 76, 34);
		frame.getContentPane().add(username);
		// ����
		JLabel passwd = new JLabel("\u5BC6\u7801");
		passwd.setBounds(164, 168, 76, 34);
		frame.getContentPane().add(passwd);
		// �û�����
		textField = new JTextField();
		textField.setBounds(250, 109, 136, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addActionListener(this);
		// �����
		passwordField = new JPasswordField();
		passwordField.setBounds(250, 175, 136, 21);
		frame.getContentPane().add(passwordField);
		passwordField.addActionListener(this);
		// ��½
		login = new JButton("\u767B\u9646");
		login.setBounds(202, 243, 66, 34);
		login.addActionListener(this);
		frame.getContentPane().add(login);
		// ����
		reset = new JButton("\u91CD\u7F6E");
		reset.setBounds(302, 243, 66, 34);
		reset.addActionListener(this);
		frame.getContentPane().add(reset);

	}

	public void actionPerformed(ActionEvent e) {
		String username = textField.getText();
		String password = passwordField.getText();
		Main newMain = new Main();
		Connection con = newMain.getConn();
		Chief_Operate chiefOperate = new Chief_Operate();
		if (e.getSource() == login) {
			if (username.isEmpty()) {
				// �û����쳣
				JTextField textField_1 = new JTextField(10);
				textField_1.setBounds(250, 140, 173, 21);
				textField_1.setEditable(false);
				textField_1.setText("�û�������Ϊ�� ��");
				frame.getContentPane().add(textField_1);
			} 
			else{
				try {
					int a = ChiefIfLogin.Login(username);
					if(a == 1) {
					JTextField textField_1 = new JTextField(10);
					textField_1.setBounds(250, 140, 173, 21);
					textField_1.setEditable(false);   
					textField_1.setText("�û��������� ��");
					frame.getContentPane().add(textField_1);
				}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
			if (password.isEmpty()) {
				// �����쳣
				JTextField textField_2 = new JTextField();
				textField_2.setBounds(250, 212, 173, 21);
				textField_2.setEditable(false);
				textField_2.setVisible(true);
				frame.getContentPane().add(textField_2);
				textField_2.setColumns(10);
				textField_2.setText("���벻��Ϊ�� ��");
			} 
			if (! username.isEmpty() && ! password.isEmpty()) {
				
				try {
					int flag = ChiefIfLogin.ifLogin(username, password);
					if(flag == 1) {
						Chief_Operate chief = new Chief_Operate();
						frame.dispose();
					}
				} 
				 catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

	}
}
