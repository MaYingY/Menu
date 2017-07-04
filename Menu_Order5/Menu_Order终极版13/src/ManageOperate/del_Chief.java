package ManageOperate;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import Dao.ManageOperate;

public class del_Chief implements ActionListener{

	private JFrame frame;
	private JTextField textField;
	JButton del;
	JButton reset;
	public del_Chief() {
		initialize();
		frame.setVisible(true);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 400);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u5220\u9664\u53A8\u5E08");
		label.setBounds(215, 10, 102, 42);
		frame.getContentPane().add(label);
		
		JLabel name = new JLabel("\u7F16\u53F7");
		name.setFont(new Font("����", Font.PLAIN, 14));
		name.setBounds(158, 109, 58, 21);
		frame.getContentPane().add(name);
		
		textField = new JTextField();
		textField.setBounds(257, 109, 86, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		del = new JButton("\u5220\u9664");
		del.setBounds(171, 235, 64, 23);
		del.addActionListener(this);
		frame.getContentPane().add(del);
		
		reset = new JButton("\u91CD\u7F6E");
		reset.setBounds(287, 235, 71, 23);
		frame.getContentPane().add(reset);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == del) {
			ManageOperate man = new ManageOperate();
			try {
				int id=Integer.parseInt(textField.getText());
				man.delWaiter(id);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(del, "ɾ���ɹ�");
			frame.dispose();
		}
		else if (e.getSource() == reset) {
			textField.setText("");
		}
	}

}
