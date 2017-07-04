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

public class add_Waiter implements ActionListener {

	private JFrame frame;
	private JTextField textField_1;
	JButton add;
	JButton reset;
	private JPasswordField passwordField;

	public add_Waiter() {
		initialize();
		frame.setVisible(true);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 400);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//����
		JLabel head = new JLabel("\u6DFB\u52A0\u670D\u52A1\u5458");
		head.setFont(new Font("����", Font.PLAIN, 14));
		head.setBounds(210, 26, 78, 24);
		frame.getContentPane().add(head);
		//����	
		JLabel name = new JLabel("\u59D3\u540D");
		name.setFont(new Font("����", Font.PLAIN, 14));
		name.setBounds(125, 99, 54, 15);
		frame.getContentPane().add(name);
		//����
		JLabel passwd = new JLabel("\u5BC6\u7801");
		passwd.setFont(new Font("����", Font.PLAIN, 14));
		passwd.setBounds(125, 152, 54, 15);
		frame.getContentPane().add(passwd);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 96, 151, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(210, 152, 151, 21);
		frame.getContentPane().add(passwordField);
		
		
		//���
		add = new JButton("\u6DFB\u52A0");
		add.setBounds(139, 234, 93, 23);
		add.addActionListener(this);
		frame.getContentPane().add(add);
		//����
		reset = new JButton("\u91CD\u7F6E");
		reset.setBounds(257, 234, 93, 23);
		reset.addActionListener(this);
		frame.getContentPane().add(reset);
	}

	public void actionPerformed(ActionEvent e) {
		//���
		if(e.getSource() == add) {
			ManageOperate man = new ManageOperate();
			try {
				int t=man.addWaiter(textField_1.getText(), passwordField.getText());
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
