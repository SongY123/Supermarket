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
	private int serverPort = 8000;//�������˿�
	private Users users;//��Ա���ݿ�
	public Server(){
		try {
				linkDatabase();
			} catch (Exception e) {
				e.printStackTrace();
			}//�������ݿ�
		listen();		
	}
	public void linkDatabase() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded!");
		users = new Users();
		System.out.println("Database connected!");
	  }
	public void listen(){
		  try {
		        serverSocket = new ServerSocket(serverPort);
		        while(true){
		        	Socket socket =  serverSocket.accept();//������������
		        	System.out.println("һ���û�������");
		        	new ServerThread(socket).start();
		        }
		  }
		  catch(IOException ex) {
		      System.err.println(ex);
		    }
	  }
	public static void main(String[] args) {
		//System.out.println(Message.APP_NAME+"����������..\n.");
		//��ʼ������������
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