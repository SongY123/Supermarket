package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Trade {
	private PreparedStatement FindTrade;//���ҽ��׼�¼
	private PreparedStatement InsertTrade;//���뽻�׼�¼,�û��������׽�����ʱ��
	private Connection connection;
	public Trade(){
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dict","root","User");
			FindTrade = connection.prepareStatement("select * from trade where id = ?");
			InsertTrade = connection.prepareStatement("insert into trade values(?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void insertTrade(String Username,Double Sum,String Time){
		try {
			InsertTrade.setString(1, Username);
			InsertTrade.setDouble(2, Sum);
			InsertTrade.setString(3, Time);
			InsertTrade.executeUpdate();//�������ݿ�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	int findTrade(String Username){//�������ѽ��
		try {
			FindTrade.setString(1, Username);
			ResultSet resultSet = FindTrade.executeQuery();
			return resultSet.getInt(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
	
}
