package client;

import entity.UserExt;
import util.InputTools;
import util.Message;
public class Client{ 

	public static void main(String[] args) {
		//runClient();
		// SimpleUI sui = new SimpleUI();
		@SuppressWarnings("unused")
		ManagerUI mui = new ManagerUI("dd");
		//LoginUI lui = new LoginUI();
	}
	/*
	public static void runClient(){
		int int_select=0;
		
		int_select=InputTools.getInt(null, Message.ERR_SELECT);
		if(int_select==2){
			return;
		}
		
		if(int_select!=1){
			System.out.println(Message.ERR_SELECT);
			runClient();
		}
		UserExt.login();//�û���¼
		System.out.println(Message.OUTPUT_START+Message.OUTPUT_START+Message.OUTPUT_START);
	}
	*/
}