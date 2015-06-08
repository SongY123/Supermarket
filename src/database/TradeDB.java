package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TradeDB {
	private PreparedStatement FindTrade;//查找交易记录
	private PreparedStatement InsertTrade;//插入交易记录,用户名，交易金额，交易时间
	private Connection connection;
	public TradeDB(Connection connection){
		try {
			this.connection = connection;
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
			InsertTrade.executeUpdate();//更新数据库
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	int findTrade(String Username){//返回消费金额
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
