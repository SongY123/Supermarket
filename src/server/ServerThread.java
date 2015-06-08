package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import entity.Datas;
import entity.GoodsExt;
import entity.MemberExt;
import entity.UserExt;
import util.DEFINE;


public class ServerThread extends Thread{
	private Socket socket=null;
	private InputStream is = null;
	private ObjectInputStream ois = null;
	private OutputStream os = null;
	private ObjectOutputStream oos= null;
	
	public ServerThread(Socket socket){
		this.socket=socket;
	}
	
	public void run(){
			try {
				while(true){
					is=socket.getInputStream();
					ois=new ObjectInputStream(is);
					os = socket.getOutputStream();
					oos = new ObjectOutputStream(os);
			
					Datas datas = (Datas) ois.readObject();
					
					//登录请求
					if(DEFINE.SYS_LOGIN.equals(datas.getFlags())){
						
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