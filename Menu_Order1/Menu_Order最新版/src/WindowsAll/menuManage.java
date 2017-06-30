package WindowsAll;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import Domain.ManageOperate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class menuManage implements ActionListener{

	JFrame frame;
	JButton addMenu;
	JButton modMenu;
	JButton delMenu;
	JButton searchMenu;
	ManageOperate manageOperate = new ManageOperate();
	/**
	 * Create the application.
	 */
	public menuManage() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(310, 310, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//����
		JLabel head = new JLabel("\u6B22\u8FCE\u6765\u5230\u597D\u8FD0\u6765\u996D\u5E97\uFF01");
		head.setBounds(181, 33, 120, 39);
		frame.getContentPane().add(head);
		//��Ӳ�Ʒ
		addMenu = new JButton("\u6DFB\u52A0\u83DC\u54C1");
		addMenu.setBounds(68, 113, 93, 23);
		addMenu.addActionListener(this);
		frame.getContentPane().add(addMenu);
		//�޸Ĳ�Ʒ
		modMenu = new JButton("\u4FEE\u6539\u83DC\u54C1");
		modMenu.setBounds(68, 236, 93, 23);
		modMenu.addActionListener(this);
		frame.getContentPane().add(modMenu);
		//ɾ����Ʒ
		delMenu = new JButton("\u5220\u9664\u83DC\u54C1");
		delMenu.setBounds(332, 113, 93, 23);
		delMenu.addActionListener(this);
		frame.getContentPane().add(delMenu);
		//��ѯ�˵�
		searchMenu = new JButton("\u83DC\u5355\u67E5\u8BE2");
		searchMenu.setBounds(332, 236, 93, 23);
		searchMenu.addActionListener(this);
		frame.getContentPane().add(searchMenu);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addMenu) {
			addMenu add = new addMenu();
			frame.dispose();
		}
		if(e.getSource() == modMenu) {
			modMenu mod = new modMenu();
			frame.dispose();
		}
		if(e.getSource() == delMenu) {
			delMenu del = new delMenu();
			frame.dispose();
		}
		if(e.getSource() == searchMenu) {
		
				try {
					manageOperate.searchDishes();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		}
	}

}
