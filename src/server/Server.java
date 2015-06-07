package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;

import server.ServerThread;
import server.Users;

public class Server {
	private ServerSocket serverSocket;
	private int ClientCount = 0;
	private int serverPort = 8000;//服务器端口
	private Connection connection;//连接
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
		System.out.println("Driver loaded!");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dict","root","User");
		System.out.println("Database connected!");
		FindWord=connection.prepareStatement("select * from wordlist where word = ? ");
			FindUserPassword = connection.prepareStatement("select * from user where id = ? and password = ?");
			FindUser = connection.prepareStatement("select * from user where id = ?");
			FindFriends = connection.prepareStatement("select * from friend where ida = ?");
			SetUser = connection.prepareStatement("update user set ip = ? ,port = ? where id = ?");
			InsertWord = connection.prepareStatement("insert into wordlist values(?,0,0,0)");
			InsertUser = connection.prepareStatement("insert into user values(?,?,?,\"127.0.0.1\",0)");
			InsertFriends = connection.prepareStatement("insert into friend values(?,?)");
			LikeWordBaidu = connection.prepareStatement("update wordlist set baidu = baidu+1 Where word = ?");
			DislikeWordBaidu = connection.prepareStatement("update wordlist set baidu = baidu-1 Where word = ?");
			LikeWordYoudao = connection.prepareStatement("update wordlist set youdao = youdao+1 Where word = ?");
			DislikeWordYoudao = connection.prepareStatement("update wordlist set youdao = youdao-1 Where word = ?");
			LikeWordBing = connection.prepareStatement("update wordlist set bing = bing+1 Where word = ?");
			DislikeWordBing = connection.prepareStatement("update wordlist set bing = bing-1 Where word = ?");
			FindLikeBaidu = connection.prepareStatement("select*from likebaidu where id = ? and word = ?");
			FindLikeYoudao = connection.prepareStatement("select*from likeyoudao where id = ? and word = ?");
			FindLikeBing = connection.prepareStatement("select*from likebing where id = ? and word = ?");
			InsertLikeBaidu = connection.prepareStatement("Insert likebaidu values(?,?)");
			InsertLikeYoudao = connection.prepareStatement("Insert likeyoudao values(?,?)");
			InsertLikeBing = connection.prepareStatement("Insert likebing values(?,?)");
			DropLikeBaidu = connection.prepareStatement("delete from likebaidu where id = ? and word = ?");
			DropLikeYoudao = connection.prepareStatement("delete from likeyoudao where id = ? and word = ?");
			DropLikeBing = connection.prepareStatement("delete from likebing where id = ? and word = ?");
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
		System.out.println("Server On...\n");
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