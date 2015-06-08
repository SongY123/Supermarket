package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import database.EmployeeDB;
import database.GoodsDB;
import database.TradeDB;
import database.UsersDB;
import entity.Datas;
import entity.GoodsExt;
import entity.MemberExt;
import entity.User;
import entity.UserExt;
import util.DEFINE;


public class ServerThread extends Thread{
	private Socket socket=null;
	private InputStream is = null;
	private ObjectInputStream ois = null;
	private OutputStream os = null;
	private ObjectOutputStream oos= null;
	
	private UsersDB users;//会员数据库
	private EmployeeDB employees;//用户数据库
	private TradeDB trades;//交易记录数据库
	private GoodsDB goods;//商品信息数据库
	
	public ServerThread(Socket socket,UsersDB users, EmployeeDB employees,TradeDB trades,GoodsDB goods){
		this.socket=socket;
		this.users = users;
		this.employees = employees;
		this.trades = trades;
		this.goods = goods;
	}
	
	public void run(){
		System.out.print(1);
			try {
				System.out.print(2);
				is=socket.getInputStream();
				System.out.print(3);
				ois=new ObjectInputStream(is);
				System.out.print(4);
				os = socket.getOutputStream();
				System.out.print(5);
				oos = new ObjectOutputStream(os);
				System.out.print(6);
				while(true){
					System.out.print(1);
			
					Datas datas = (Datas) ois.readObject();
					
					//登录请求
					if(DEFINE.SYS_LOGIN.equals(datas.getFlags())){
						User u = datas.getUser();
						int tag = employees.loginEmployee(u.getUserid(),u.getPassword());
						Datas outdata = new Datas();
						if(tag==0||tag==-1){//密码错误,重复登录，登录失败
							outdata.setFlags(DEFINE.SYS_LOGINFAIL);
						}
						else{
							outdata.setFlags(DEFINE.SYS_LOGINSUCCESS);
						}
						oos.writeObject(outdata);
					}
					else if(DEFINE.SYS_LOGOUT.equals(datas.getFlags())){//登出
						
					}
					else if(DEFINE.SYS_GOODS_INFO.equals(datas.getFlags())){//查询商品信息
						
					}
					else if(DEFINE.SYS_GOODS_OUT.equals(datas.getFlags())){//商品出库
						
					}
					else if(DEFINE.SYS_BALANCE.equals(datas.getFlags())){//账单
						
					}
					
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}