package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsDB {
	private PreparedStatement FindGood;//������Ʒ
	private PreparedStatement InsertGood;//������Ʒ��Ϣ����Ʒ���id����Ʒ��name������count������price
	private PreparedStatement UpdateGood;//��Ʒ�۳�count
	private Connection connection;
	public GoodsDB(Connection connection){
		try {
			this.connection = connection;
			FindGood = connection.prepareStatement("select * from good where id = ?");
			InsertGood = connection.prepareStatement("insert into good values(?,?)");
			UpdateGood = connection.prepareStatement("update good set count = ? where id = ?");
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
	
	int findGoodCount(String id){//������Ʒʣ������
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
	
	public String findGoodname(String id){
		try {
			FindGood.setString(1, id);
			ResultSet resultSet = FindGood.executeQuery();		
			if(resultSet.next()){
				return resultSet.getString(2);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public double findGoodPrice(String id){//��ѯ��Ʒ����
		try {
			FindGood.setString(1, id);
			ResultSet resultSet = FindGood.executeQuery();
			if(resultSet.next()){
				return resultSet.getDouble(4);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	void updateGood(String id,int deccount){//�۳���Ʒ����
		try {
			UpdateGood.setString(2,id);
			UpdateGood.setInt(1,findGoodCount(id)-deccount);
			UpdateGood.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
