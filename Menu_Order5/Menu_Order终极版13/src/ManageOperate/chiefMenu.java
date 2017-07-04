package ManageOperate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import Dao.Main;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class chiefMenu extends JFrame {

	private JScrollPane scpDemo;
	private JButton btnShow;
	private JTableHeader jth;
	private JTable tabDemo;

	Main ma = new Main();
	private JTextField textField;
	// ���췽��
	public chiefMenu() {
		// �����������ԵĶ���
		super("JTable���ݰ�ʾ��");
		this.setSize(330, 400);
		this.setLocation(100, 50);
		getContentPane().setLayout(null);
		// �������
		this.scpDemo = new JScrollPane();
		scpDemo.setBounds(10, 50, 300, 270);
		// ��������뵽������
		getContentPane().add(this.scpDemo);
		//id
		JLabel id = new JLabel("\u8BF7\u8F93\u5165\u53A8\u5E08\u7F16\u53F7");
		id.setBounds(10, 5, 100, 35);
		getContentPane().add(id);
		
		textField = new JTextField();
		textField.setBounds(114, 10, 41, 27);
		getContentPane().add(textField);
		textField.setColumns(10);
		// ��������뵽������
		getContentPane().add(this.scpDemo);
		this.btnShow = new JButton("\u67E5\u8BE2");
		btnShow.setBounds(179, 11, 74, 23);
		getContentPane().add(btnShow);
		// ����ťע�����
		this.btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					btnShow_ActionPerformed(ae);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		// ��ʾ����
		this.setVisible(true);
		// ��ʾ����
		this.setVisible(true);
	}

	// �����ťʱ���¼�����
	public void btnShow_ActionPerformed(ActionEvent ae) throws ClassNotFoundException {
		Statement statement = null;
		// ��������������Դ����ʾ���ݵľ��崦��������ע����
		try {
			int id = Integer.parseInt(textField.getText());
			Connection connection = ma.getConn();
			String sql = "select * from dishes where id=?"; 

			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, id);
			// ִ�в�ѯ
			ResultSet resultSet = pstm.executeQuery();
			// �����ж�������¼
			int count = 0;
			while(resultSet.next()){
			count++;
			}
			resultSet = pstm.executeQuery();
			JRadioButton rButton[]=new JRadioButton[count];
			Object[][] info = new Object[count][5];
			JRadioButton radioButton[]=new JRadioButton[count];
			count = 0;
			while (resultSet.next()) {
				info[count][0] = resultSet.getInt("id");
				//info[count][1]=radioButton[count].setText(resultSet.getString("name"));
				info[count][1] = resultSet.getString("name");
				info[count][2] = resultSet.getDouble("price");
				info[count][3] = resultSet.getInt("chief");
				
				int type = resultSet.getInt("type");
				String dishName = null;
				if(type == 1) {
					dishName = "�ղ�";
				} else if(type == 2) {
					dishName = "����";
				} else if(type == 3) {
					dishName = "��";
				} else if(type == 4) {
					dishName = "��ɫ��";
				}
				info[count][4] = dishName;
				count++;

			}
			// �����ͷ
			String[] title = { "���", "����", "�۸�", "����", "����" };
			// ����JTable
			this.tabDemo = new JTable(info, title);
			// ��ʾ��ͷ
			this.jth = this.tabDemo.getTableHeader();
			this.scpDemo.setViewportView(tabDemo);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "���ݲ�������", "����",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
