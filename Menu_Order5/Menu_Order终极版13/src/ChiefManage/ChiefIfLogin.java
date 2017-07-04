package ChiefManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.Main;

public class ChiefIfLogin {
	
	static Main newMain = new Main();
    static Connection con = newMain.getConn();
	//��¼����û���
	public int Login(String username) throws SQLException {
		
		String sql = "select * from chief where name=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, username);
		ResultSet rs = preparedStatement.executeQuery();
		int flag = 0;
		if(! rs.next()) {  
			flag = 1;
		} 
		return flag;
	}
	//����û���������
	public int ifLogin(String username, String password) throws SQLException {
		String sql = "select * from chief where name = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, username);
		ResultSet rs = preparedStatement.executeQuery();
		int flag = 1;
		while( rs.next()) {
			if(rs.getString(3).equals(password)) {
				flag = 0;
			}
		}
		return flag;
	}
}
