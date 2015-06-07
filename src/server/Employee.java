package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
	private PreparedStatement FindEmployee;//���ҹ�Ա
	private PreparedStatement InsertEmployee;//�����û�,�ʺţ����룬�ȼ�
	private PreparedStatement VerifyEmployee;//��֤�û���������
	private Connection connection;
	public Employee(){
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dict","root","User");
			FindEmployee = connection.prepareStatement("select * from employee where id = ?");
			InsertEmployee = connection.prepareStatement("insert into employee values(?,?,?)");
			VerifyEmployee = connection.prepareStatement("select * from employee where id = ? and password = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void insertEmployee(String Username,String Password,int level){
		try {
			InsertEmployee.setString(1, Username);
			InsertEmployee.setString(2, Password);
			InsertEmployee.setInt(3, level);
			InsertEmployee.executeUpdate();//�������ݿ�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	int verifyEmployee(String Username,String Password){
		try {
			VerifyEmployee.setString(1, Username);
			VerifyEmployee.setString(2, Password);
			ResultSet resultSet = VerifyEmployee.executeQuery();
			if(resultSet.next())return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	int findEmployee(String Username){
		try {
			FindEmployee.setString(1, Username);
			ResultSet resultSet = FindEmployee.executeQuery();
			return resultSet.getInt(3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
	
}
