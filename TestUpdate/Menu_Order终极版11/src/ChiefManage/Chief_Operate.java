package ChiefManage;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

import WindowsAll.menuManage;
import WindowsAll.wineManage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class Chief_Operate implements ActionListener {

	private JFrame frame;
	JButton addMenu;
	JButton addWine;
	JButton lookMenu;
	JButton modInfo;
	String chiefname;
	/**
	 * Create the application.
	 * @param username 
	 */
	public Chief_Operate(String username) {
		chiefname = username;
		initialize(chiefname);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String chiefName) {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//����
		JLabel head = new JLabel("\u53A8\u5E08\u7BA1\u7406");
		head.setFont(new Font("����", Font.PLAIN, 14));
		head.setBounds(194, 10, 129, 50);
		frame.getContentPane().add(head);
		//�Ӳ�
		addMenu = new JButton("\u83DC\u5355\u7BA1\u7406");
		addMenu.setBounds(57, 80, 153, 50);
		addMenu.addActionListener(this);
		frame.getContentPane().add(addMenu);
		//�Ӿ�
		addWine = new JButton("\u9152\u5355\u7BA1\u7406");
		addWine.addActionListener(this);
		addWine.setBounds(57, 197, 153, 50);
		frame.getContentPane().add(addWine);
		//�鿴�˵�
		lookMenu = new JButton("\u67E5\u770B\u83DC\u5355");
		lookMenu.addActionListener(this);
		lookMenu.setBounds(275, 80, 167, 50);
		frame.getContentPane().add(lookMenu);
		//�޸���Ϣ
		modInfo = new JButton("\u4FEE\u6539\u4FE1\u606F");
		modInfo.addActionListener(this);
		modInfo.setBounds(275, 197, 167, 50);
		frame.getContentPane().add(modInfo);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addMenu) {
			new menuManage();
		}
		if(e.getSource() == addWine) {
			new wineManage();
		}
		if(e.getSource() == modInfo) {
			new ModInfo();
		}
		if(e.getSource() == lookMenu) {
			try {
				new lookMenu_Window(chiefname);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}


}
