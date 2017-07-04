package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManageOperate {

	static Main newMain = new Main();
	static Connection con = newMain.getConn();

	// ��¼����û���
	public int Login(String username) throws SQLException {

		String sql = "select * from manager where username=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, username);
		ResultSet rs = preparedStatement.executeQuery();
		int flag = 0;
		if (!rs.next()) {
			flag = 1;
		}
		return flag;
	}
	// ����û���������
	public int ifLogin(String username, String password) throws SQLException {
		String sql = "select * from manager where username = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, username);
		ResultSet rs = preparedStatement.executeQuery();
		int flag = 1;
		while (rs.next()) {
			if (rs.getString(2).equals(password)) {
				flag = 0;
			}
		}
		return flag;
	}

	// ��Ʒ���
		public static int addMenu( String name, double price, int chief,
				int type) throws SQLException {
			int id=MenuID();
			String sql = "insert into dishes(id, name, price, chief, type) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setDouble(3, price);
			preparedStatement.setInt(4, chief);
			preparedStatement.setInt(5, type);
			preparedStatement.executeUpdate();
			return id;
		}

		// �޸Ĳ�Ʒ
		public static void modMenu(int id, String name, double price, int type, int chief) throws SQLException {
			String sql = "update dishes set name=?,price=?,chief=?,type=? where id=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, price);
			preparedStatement.setInt(3, chief);
			preparedStatement.setInt(4, type);
			preparedStatement.setInt(5, id);
			preparedStatement.executeUpdate();
		}
		public static int MenuID() {
			int sid = 0;
			try {
				
				Connection connection = newMain.getConn();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM dishes");
				while (resultSet.next()) {
					int id = resultSet.getInt(1);
					if (id > sid) {
						sid = id;
					}
				}
			} catch (Exception e) {
				System.out.println("HHH");
			}
			return sid;
			
		}

		// ɾ����Ʒ
		public void deleteMenu(String name) throws SQLException {
			// TODO Auto-generated method stub
			String sql = "delete from dishes where name=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
		}
		public static int search() {
			int sid = 0;
			Main ma = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager
						.getConnection(
								"jdbc:mysql://localhost:3306/menu?user=root&password=1&useUnicode=true&characterEncoding=utf8",
								"root", "");
				//Connection connection = ma.getConn();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM chief");
				while (resultSet.next()) {
					int id = resultSet.getInt(1);
					if (id > sid) {
						sid = id;
					}
				}
			} catch (Exception e) {
				System.out.println("HHH");
			}
			return sid + 1;
		}

	// ��ӳ�ʦ
	public static int addChief(String name, String passwd)
			throws SQLException {
		int id = searchChiefId();
		String sql = "insert into chief(id, name, passwd) values(?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, passwd);
		preparedStatement.executeUpdate();
		return id;
	}
	//����ID
	public static int searchChiefId() {
		int sid = 0;
		try {
			Connection connection = newMain.getConn();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM chief");
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				System.out.println(id);
				if (id > sid) {
					sid = id;
				}
			}
		} catch (Exception e) {
			System.out.println("HHH");
		}
		return sid + 1;
	}

	// ɾ����ʦ
	public static void delChief(String name) throws SQLException {
		String sql = "delete from chief where name=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.executeUpdate();
	}

	
	// ��ӷ���Ա
	public static int addWaiter(String name, String passwd) throws SQLException {
		int id = searchId();
		String sql = "insert into waiter(id, name, passwd) values(?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, passwd);
		preparedStatement.executeUpdate();
		return id;
	}
	
	// ����ID
	public static int searchId() {
		int sid = 0;
		try {
			Connection connection = newMain.getConn();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM waiter");
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				System.out.println(id);
				if (id > sid) {
					sid = id;
				}
			}
		} catch (Exception e) {
			System.out.println("HHH");
		}
		return sid + 1;
	}
	// ɾ������Ա
	public static void delWaiter(int name) throws SQLException {
		String sql = "delete from waiter where id=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, name);
		
		preparedStatement.executeUpdate();System.out.println("))");
	}

}

