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
	//goods文件路径
		private static String path_goods=Tools.getValue(DEFINE.SYS_PATH)+Tools.getValue(DEFINE.SYS_DATA_GOODS);
		
		/*
		 * 读取商品列表
		 * 返回值:HashMap类型的Goods列表
		 */
		@SuppressWarnings("unchecked")
		public static HashMap<Integer,Goods> getGoodsList(){
			return (HashMap<Integer,Goods>) FileTools.readData(path_goods);
		}
		
		/*
		 * 写入商品列表
		 * 参数:map_goods是HashMap数组类型的Goods列表
		 * 返回值:写入成功返回true，写入失败返回false
		 */
		public static boolean setGoodsList(HashMap<Integer,Goods> map_goods){
			return FileTools.writeData(map_goods, path_goods);
		}
		
		
		
		
	
	
	
}