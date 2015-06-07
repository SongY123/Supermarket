package client;

import entity.UserExt;
import util.InputTools;
import util.Message;
public class Client{ 
	
	public static void main(String[] args) {
		//LoginUI lui = new LoginUI();
		//runClient();
		SimpleUI sui = new SimpleUI();
	}
	
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
		UserExt.login();//ÓÃ»§µÇÂ¼
		System.out.println(Message.OUTPUT_START+Message.OUTPUT_START+Message.OUTPUT_START);
	}
}