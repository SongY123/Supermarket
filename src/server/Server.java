package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;

import server.ServerThread;
import server.Users;
import server.Employee;
import server.Goods;
import server.Trade;

public class Server {
	private ServerSocket serverSocket;
	private int ClientCount = 0;
	private int serverPort = 8000;//服务器端口
	private Connection connection;
	private Users users;//会员数据库
	private Employee employees;//用户数据库
	private Trade trades;//交易记录数据库
	private Goods goods;//商品信息数据库
	public Server(){
		try {
				linkDatabase();
			} catch (Exception e) {
				e.printStackTrace();
			}//连接数据库
		listen();		
	}
	public void linkDatabase() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dict","root","User");
		System.out.println("Driver loaded!");
		users = new Users(connection);
		employees = new Employee(connection);
		trades = new Trade(connection);
		goods = new Goods(connection);
		System.out.println("Database connected!");
	  }
	public void listen(){
		  try {
		        serverSocket = new ServerSocket(serverPort);
		        while(true){
		        	Socket socket =  serverSocket.accept();//接收连接请求
		        	System.out.println("一个用户已连接");
		        	new ServerThread(socket).start();
		        }
		  }
		  catch(IOException ex) {
		      System.err.println(ex);
		    }
	  }
	public static void main(String[] args) {
		//System.out.println(Message.APP_NAME+"服务器启动..\n.");
		//初始化服务器数据
		//DemoData.init();
		System.out.println("Server On...");
		new Server();
		/*try {
			serversocket=new ServerSocket();
			while(true){
				Socket socket=serversocket.accept();
				Thread serverThread=new ServerThread(socket);
				serverThread.start();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

}