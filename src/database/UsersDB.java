package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDB {
	private PreparedStatement FindUser;//�����û�
	private PreparedStatement InsertUser;//�����û�,�ʺţ���Ա�ȼ�
	private Connection connection;
	public UsersDB(Connection connection){
		try {
			this.connection = connection;
			FindUser = connection.prepareStatement("select * from user where id = ?");
			InsertUser = connection.prepareStatement("insert into user values(?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void insertUser(String Username,int level){
		try {
			InsertUser.setString(1, Username);
			InsertUser.setInt(2, level);
			InsertUser.executeUpdate();//�������ݿ�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	int findUser(String Username){
		try {
			FindUser.setString(1, Username);
			ResultSet resultSet = FindUser.executeQuery();
			return resultSet.getInt(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
	
}
