package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Goods {
	private PreparedStatement FindGood;//������Ʒ
	private PreparedStatement InsertGood;//������Ʒ��Ϣ����Ʒ���id����Ʒ��name������count������price
	private PreparedStatement UpdateGood;//��Ʒ�۳�count
	private Connection connection;
	public Goods(){
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dict","root","User");
			FindGood = connection.prepareStatement("select * from good where id = ?");
			InsertGood = connection.prepareStatement("insert into good values(?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void insertGood(String id,String name,int count,double price){
		try {
			InsertGood.setString(1, id);
			InsertGood.setString(2, name);
			InsertGood.setInt(3, count);
			InsertGood.setDouble(4, price);
			InsertGood.executeUpdate();//�������ݿ�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	int findGoodCount(String id){
		try {
			FindGood.setString(1, id);
			ResultSet resultSet = FindGood.executeQuery();
			return resultSet.getInt(3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	double findGoodPrice(String id){
		try {
			FindGood.setString(1, id);
			ResultSet resultSet = FindGood.executeQuery();
			return resultSet.getDouble(4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}
