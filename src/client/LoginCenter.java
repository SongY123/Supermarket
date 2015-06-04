package client;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

@SuppressWarnings("serial")
public class LoginCenter extends JPanel implements MouseListener{

	private List<ImageIcon> list= new ArrayList<ImageIcon>();
	private JButton headb;
	private JTextField userName;
	private JPasswordField passWord;
	private static final Font font1 = new Font("Calibri",Font.PLAIN,14);
	
	public LoginCenter(){
		getImg();
		setLoginCenter();
	}
	
	public void setLoginCenter(){
		this.setSize(380,100);
		this.setLayout(null);
		this.setOpaque(false);
		
		//ͷ��߿�
		JLabel head = new JLabel(list.get(9));
		head.setBounds(25, 11, list.get(9).getIconWidth(), list.get(9).getIconHeight());
		add(head);
		//ͷ��
		headb = Tools.setView(this, list.get(10));
		headb.setBounds(26, 12, list.get(10).getIconWidth(), list.get(10).getIconHeight());
		//�û���Ϣ��
		userName = new JTextField("UserID");//��������
		userName.setFont(font1);
		userName.setBounds(120, 18, 220, 29);//�趨λ��
		add(userName);//��ӵ�����
		userName.addMouseListener(this);//���������
		//�����
		passWord = new JPasswordField();
		userName.setFont(font1);
		passWord.setBounds(120, 58, 220, 29);
		add(passWord);
		
		
		JLabel bg = new JLabel(list.get(13));
		bg.setBounds(0, 0, 380, 135);
		add(bg);
	}
	
	//����ͼƬ
	public void getImg(){
		for(int i=1;i<15;i++){
			ImageIcon img = new ImageIcon("images/log/c"+i+".png");
			list.add(img);
		}
		for(int i=20;i<26;i++){
			ImageIcon img = new ImageIcon("images/log/c"+i+".png");
			list.add(img);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

	} 
	
	public String getName() {
		return userName.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getPassword() {
		return passWord.getText();
	}
	
}

