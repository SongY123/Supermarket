package client;

import java.awt.Container;
import javax.swing.*;

public class Tools {

	//给JButton对象添加组件
	public static JButton setView(Container panel,ImageIcon image){
		JButton btn = new JButton();//创建按钮对象
		btn.setBorderPainted(false);//设置边框不可见
		btn.setContentAreaFilled(false);//设置透明
		btn.setIcon(image);//设置图片
		panel.add(btn);//添加按钮
		return btn;
	}
	
//	//给组件添加监听
//	public static void addListener(JButton btn,String str){
//		MyEventListener event = new MyEventListener();
//		btn.setActionCommand(str);
//		btn.addActionListener(event);
//	}
	
}
