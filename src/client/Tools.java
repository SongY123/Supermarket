package client;

import java.awt.Container;
import javax.swing.*;

public class Tools {

	//��JButton����������
	public static JButton setView(Container panel,ImageIcon image){
		JButton btn = new JButton();//������ť����
		btn.setBorderPainted(false);//���ñ߿򲻿ɼ�
		btn.setContentAreaFilled(false);//����͸��
		btn.setIcon(image);//����ͼƬ
		panel.add(btn);//��Ӱ�ť
		return btn;
	}
	
//	//�������Ӽ���
//	public static void addListener(JButton btn,String str){
//		MyEventListener event = new MyEventListener();
//		btn.setActionCommand(str);
//		btn.addActionListener(event);
//	}
	
}
