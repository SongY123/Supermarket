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
import entity.Goods;
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
	
	private UsersDB users;//��Ա���ݿ�
	private EmployeeDB employees;//�û����ݿ�
	private TradeDB trades;//���׼�¼���ݿ�
	private GoodsDB goods;//��Ʒ��Ϣ���ݿ�
	
	public ServerThread(Socket socket,UsersDB users, EmployeeDB employees,TradeDB trades,GoodsDB goods){
		this.socket=socket;
		this.users = users;
		this.employees = employees;
		this.trades = trades;
		this.goods = goods;
	}
	
	public void run(){
			try {
				is=socket.getInputStream();
				ois=new ObjectInputStream(is);
				os = socket.getOutputStream();
				oos = new ObjectOutputStream(os);
				while(true){
			
					Datas datas = (Datas) ois.readObject();
System.out.println(datas);		
System.out.println(datas.getFlags());
					//��¼����
					if(DEFINE.SYS_LOGIN.equals(datas.getFlags())){
						System.out.println("��¼");
						User u = datas.getUser();
						int tag = employees.loginEmployee(u.getUserid(),u.getPassword());
						System.out.println(u.getUserid()+" "+u.getPassword());
						Datas outdata = new Datas();
						if(tag==0||tag==-1){//�������,�ظ���¼����¼ʧ��
							System.out.println("��¼ʧ��");
							outdata.setFlags(DEFINE.SYS_LOGINFAIL);
						}
						else{
							System.out.println("��¼�ɹ�");
							u.setAuthority(employees.findEmployeelevel(u.getUserid()));
							outdata.setFlags(DEFINE.SYS_LOGINSUCCESS);
							outdata.setUser(u);
						}
						oos.writeObject(outdata);
					}
					else if(DEFINE.SYS_LOGOUT.equals(datas.getFlags())){//�ǳ�
						System.out.println("�ǳ�");
						User u = datas.getUser();
						int tag = employees.logoutEmployee(u.getUserid());
						Datas outdata = new Datas();
						if(tag==-1){//�ǳ�ʧ��
							System.out.println("�ǳ�ʧ��");
							outdata.setFlags(DEFINE.SYS_LOGOUTFAIL);
						}
						else{
							System.out.println("�ǳ��ɹ�");
							outdata.setFlags(DEFINE.SYS_LOGOUTSUCCESS);
							outdata.setUser(u);
						}
						oos.writeObject(outdata);
					}
					else if(DEFINE.SYS_GOODS_INFO.equals(datas.getFlags())){//��ѯ��Ʒ��Ϣ
						String getid=datas.getGoods().getGoodid();
						int getcount =datas.getGoods().getCount();
						Datas outdata = new Datas();
						Goods good = new Goods();
						good.setCount(getcount);
						good.setGoodid(getid);
						good.setPrice(goods.findGoodPrice(getid));
						good.setName(goods.findGoodname(getid));
						
						outdata.setGoods(good);
						
						oos.writeObject(outdata);
						
					}
					else if(DEFINE.SYS_MEMBER_QUERY.equals(datas.getFlags())){
						String getid=datas.getUser().getUserid();
						Datas outdata = new Datas();
						User user = new User();
						user.setUserid(getid);
						user.setAuthority(users.findUser(getid));
System.out.println(users.findUser(getid));
						outdata.setUser(user);
						
						oos.writeObject(outdata);
						
					}
					else if(DEFINE.SYS_GOODS_OUT.equals(datas.getFlags())){//��Ʒ����
						
					}
					else if(DEFINE.SYS_BALANCE.equals(datas.getFlags())){//�˵�
						
					}
					
				}
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
			} catch (IOException e) {
				//e.printStackTrace();
			}
	}

}