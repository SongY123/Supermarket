package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Users {
	private PreparedStatement FindUser;//�����û�
	private PreparedStatement InsertUser;//�����û�
	private Connection connection;
	public Users(){
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dict","root","User");
			FindUser = connection.prepareStatement("select * from user where id = ?");
			InsertUser = connection.prepareStatement("insert into user values(?,?,?,0)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
