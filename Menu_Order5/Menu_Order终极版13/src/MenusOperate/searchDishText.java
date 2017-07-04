package MenusOperate;

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

public class searchDishText extends JFrame {
	// �������
	private JScrollPane scpDemo;
	private JTableHeader jth;
	private JTable tabDemo;
	private JButton btnShow;

	Main ma = new Main();
	// ���췽��
	public searchDishText() {
		// �����������ԵĶ���
		super("JTable���ݰ�ʾ��");
		this.setSize(330, 400);
		this.setLayout(null);
		this.setLocation(100, 50);
		// �������
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(10, 50, 300, 270);
		this.btnShow = new JButton("��ʾ����");
		this.btnShow.setBounds(10, 10, 300, 30);
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
		// ��������뵽������
		add(this.scpDemo);
		add(this.btnShow);
		// ��ʾ����
		this.setVisible(true);
	}

	// �����ťʱ���¼�����
	public void btnShow_ActionPerformed(ActionEvent ae) throws ClassNotFoundException {
		Statement statement = null;
		// ��������������Դ����ʾ���ݵľ��崦��������ע����
		try {
			Connection connection = ma.getConn();
			String sql = "select * from dishes"; 

			PreparedStatement pstm = connection.prepareStatement(sql);
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
			// ��JTable���뵽���������������
			this.scpDemo.getViewport().add(tabDemo);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "���ݲ�������", "����",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}