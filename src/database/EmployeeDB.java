package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDB {
	private PreparedStatement FindEmployee;//���ҹ�Ա
	private PreparedStatement InsertEmployee;//�����û�,�ʺţ����룬�ȼ�
	private PreparedStatement VerifyEmployee;//��֤�û���������
	private PreparedStatement LoginEmployee;//��¼
	private PreparedStatement LogoutEmployee;//�ǳ�
	private Connection connection;
	public EmployeeDB(Connection connection){
		try {
			this.connection = connection;
			FindEmployee = connection.prepareStatement("select * from employee where id = ?");
			InsertEmployee = connection.prepareStatement("insert into employee values(?,?,?,0)");
			VerifyEmployee = connection.prepareStatement("select * from employee where id = ? and password = ?");
			LoginEmployee = connection.prepareStatement("update employee set online = 1 where id = ?");
			LogoutEmployee = connection.prepareStatement("update employee set online = 0 where id = ?");
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
			if(resultSet.next())return resultSet.getInt(4);
			else return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	int findEmployeelevel(String Username){
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
	int findEmployeeonline(String Username){
		try {
			FindEmployee.setString(1, Username);
			ResultSet resultSet = FindEmployee.executeQuery();
			return resultSet.getInt(4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	int loginEmployee(String Username,String Password){
		int tag = verifyEmployee(Username,Password);
		if(tag==-1)return 0;//�������
		else if(tag==1)return -1;//�ظ���¼
		else {
			try {
				LoginEmployee.setString(1, Username);
				LoginEmployee.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 1;
		}
	}
	
	int loginoutEmployee(String Username){
		int tag = findEmployeeonline(Username);
		if(tag==-1||tag==0)return -1;//�Ѿ��ǳ�
		else {
			try {
				LogoutEmployee.setString(1, Username);
				LogoutEmployee.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 1;
		}
	}
}
