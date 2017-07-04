package WineOperate;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Dao.ChiefOperate;

public class del_Wine implements ActionListener{

	private JFrame frame;
	private JTextField textField;
	JButton delete;
	JButton reset;
	ChiefOperate chiefOperate = new ChiefOperate();
	/**
	 * Create the application.
	 */
	public del_Wine() {
		initialize();
		frame.setVisible(true);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(320, 320, 550, 400);
		frame.getContentPane().setLayout(null);
		//����
		JLabel head = new JLabel("\u5220\u9664\u9152\u54C1");
		head.setFont(new Font("����", Font.PLAIN, 16));
		head.setForeground(Color.BLACK);
		head.setBounds(208, 23, 106, 42);
		frame.getContentPane().add(head);
		//����
		JLabel name = new JLabel("\u9152\u540D");
		name.setFont(new Font("����", Font.PLAIN, 14));
		name.setBounds(150, 108, 34, 50);
		frame.getContentPane().add(name);
		//������
		textField = new JTextField();
		textField.setBounds(206, 119, 139, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		//ɾ��
		delete = new JButton("\u5220\u9664");
		delete.setBounds(162, 248, 71, 23);
		delete.addActionListener(this);
		frame.getContentPane().add(delete);
		//����
		reset = new JButton("\u91CD\u7F6E");
		reset.setBounds(294, 248, 71, 23);
		frame.getContentPane().add(reset);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == delete) {
			try {
				String name = textField.getText();
				chiefOperate.deleteWine(name);
				JOptionPane.showMessageDialog(delete, "ɾ���ɹ� ��");
				frame.dispose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	} 

}
