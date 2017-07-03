package WindowsAll;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

import WineOperate.add_Wine;
import WineOperate.del_Wine;
import WineOperate.mod_Wine;

import com.sun.xml.internal.ws.api.addressing.AddressingVersion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class wineManage implements ActionListener {

	private JFrame frame;
	JButton addWine;
	JButton delWine;
	JButton modWine;
	JButton searchWine;
	/**
	 * Create the application.
	 */
	public wineManage() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//����
		JLabel head = new JLabel("\u9152\u5355\u7BA1\u7406");
		head.setFont(new Font("����", Font.PLAIN, 14));
		head.setBounds(218, 26, 105, 50);
		frame.getContentPane().add(head);
		//��Ӿ�
		addWine = new JButton("\u6DFB\u52A0\u9152\u54C1");
		addWine.addActionListener(this);
		addWine.setBounds(81, 104, 105, 35);
		frame.getContentPane().add(addWine);
		//ɾ��
		delWine = new JButton("\u5220\u9664\u9152\u54C1");
		delWine.setBounds(81, 204, 105, 35);
		delWine.addActionListener(this);
		frame.getContentPane().add(delWine);
		//�޸ľ�
		modWine = new JButton("\u4FEE\u6539\u9152\u54C1");
		modWine.setBounds(297, 104, 93, 35);
		modWine.addActionListener(this);
		frame.getContentPane().add(modWine);
		//��ѯ�Ƶ�
		searchWine = new JButton("\u67E5\u8BE2\u9152\u5355");
		searchWine.setBounds(297, 204, 93, 35);
		searchWine.addActionListener(this);
		frame.getContentPane().add(searchWine);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addWine) {
			add_Wine add = new add_Wine();
		}
		if(e.getSource() == delWine) {
			del_Wine del = new del_Wine();
		}
		if(e.getSource() == modWine) {
			mod_Wine mod = new mod_Wine();
		}
	}
}
