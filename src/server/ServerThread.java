package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import entity.Datas;
import entity.GoodsExt;
import entity.MemberExt;
import entity.UserExt;
import util.DEFINE;


public class ServerThread extends Thread{
	private Socket socket=null;
	
	public ServerThread(Socket socket){
		this.socket=socket;
	}
	
	public void run(){
			try {
				while(true){
					InputStream is=socket.getInputStream();
					ObjectInputStream ois=new ObjectInputStream(is);
					Datas datas = (Datas) ois.readObject();
					
					//��¼����
					if(DEFINE.SYS_LOGIN.equals(datas.getFlags())){
						UserExt.loginCheck(datas, socket);	
					}
					
					//��⡢��������
					if(datas.getFlags().equals(DEFINE.SYS_GOODS_IN) || datas.getFlags().equals(DEFINE.SYS_GOODS_OUT)){
						GoodsExt.stockInOutCheck(datas, socket);
					}
					
					//�����Ʒ����
					if(datas.getFlags().equals(DEFINE.SYS_GOODS_ADD)){
						GoodsExt.stockAddCheck(datas, socket);
					}
					
					//����Ʒid��ѯ����
					if(datas.getFlags().equals(DEFINE.SYS_GOODS_QUERY_BYID)){
						GoodsExt.replyGoodsQueryByid(datas, socket);
					}
					
					//��ѯȫ����Ʒ
					if(datas.getFlags().equals(DEFINE.SYS_GOODS_QUERY_ALL)){
						GoodsExt.replyGoodsQueryAll(datas,socket);
					}
					
					//��ѯ��Ա����
					if(datas.getFlags().equals(DEFINE.SYS_MEMBER_QUERY)){
						MemberExt.checkMemberScore(datas, socket);
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}