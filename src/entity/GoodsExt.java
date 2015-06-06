package entity;

import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import util.DEFINE;
import util.FileTools;
import util.InputTools;
import util.Message;
import util.SocketTools;
import util.Tools;

public class GoodsExt {
	//goods�ļ�·��
		private static String path_goods=Tools.getValue(DEFINE.SYS_PATH)+Tools.getValue(DEFINE.SYS_DATA_GOODS);
		
		/*
		 * ��ȡ��Ʒ�б�
		 * ����ֵ:HashMap���͵�Goods�б�
		 */
		@SuppressWarnings("unchecked")
		public static HashMap<Integer,Goods> getGoodsList(){
			return (HashMap<Integer,Goods>) FileTools.readData(path_goods);
		}
		
		/*
		 * д����Ʒ�б�
		 * ����:map_goods��HashMap�������͵�Goods�б�
		 * ����ֵ:д��ɹ�����true��д��ʧ�ܷ���false
		 */
		public static boolean setGoodsList(HashMap<Integer,Goods> map_goods){
			return FileTools.writeData(map_goods, path_goods);
		}
		
		
		
		
	
	
	
}