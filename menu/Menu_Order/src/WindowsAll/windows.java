package WindowsAll;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class windows implements ActionListener{

	private JFrame frame;
	private JButton chiefLogin;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	private JButton manageLogin;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windows window = new windows();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public windows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 550, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//����Ա��¼
		manageLogin = new JButton("\u7BA1\u7406\u5458\u767B\u5F55");
		manageLogin.setBounds(22, 116, 200, 50);
		manageLogin.addActionListener(this);
		frame.getContentPane().add(manageLogin);
		//��ʦ��¼
		chiefLogin = new JButton("\u53A8\u5E08\u767B\u5F55");
		chiefLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		chiefLogin.setBounds(22, 208, 200, 50);
		frame.getContentPane().add(chiefLogin);
		//����Ա��¼
		btnNewButton = new JButton("\u670D\u52A1\u5458\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(298, 116, 200, 50);
		frame.getContentPane().add(btnNewButton);
		//�˿͵�¼
		btnNewButton_1 = new JButton("\u987E\u5BA2\u767B\u5F55");
		btnNewButton_1.setBounds(298, 208, 200, 50);
		frame.getContentPane().add(btnNewButton_1);
		
		lblNewLabel = new JLabel("\u6B22\u8FCE\u6765\u5230\u597D\u8FD0\u6765\u996D\u5E97\uFF01");
		lblNewLabel.setBounds(184, 10, 137, 46);
		frame.getContentPane().add(lblNewLabel);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == manageLogin){
			manageLogin ma = new manageLogin();
			frame.dispose();	
		}
	}

}
