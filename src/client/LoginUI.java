package client;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.Date;

public class LoginUI extends MouseAdapter {
	//Components
	private JFrame jframe = new JFrame();
	private boolean isDragged = true;
	private Point loc, tmp;
	private LoginTop top;
	private LoginCenter cen = new LoginCenter();
	private JPanel bot = new JPanel();
	private JButton jbt;
	String uname;
	String pwd;
	JLabel bg;
	
	
	public LoginUI() {
		showLoginUI();
		setDragable();
	}
	
	public JFrame getFrame() {
		return jframe;
	}
	
	//显示登陆界面
	public void showLoginUI() {
		jframe.setSize(380,290);
		jframe.setDefaultCloseOperation(3);
		jframe.setLocationRelativeTo(null);//设置窗体中间位置
		jframe.setLayout(null);//绝对布局
		jframe.setUndecorated(true);//去除窗体
		jframe.setAlwaysOnTop(true); //设置界面悬浮
		//上部
		top = new LoginTop(this);
		top.setBounds(0, 0, top.getWidth(), top.getHeight());
		jframe.add(top);
		//中部
		// cen = new LoginCenter(this);
		cen.setBounds(0, 140, cen.getWidth(), cen.getHeight());
		jframe.add(cen);
		//底部
		bot.setSize(380,50);
		bot.setLayout(null);
		bot.setOpaque(false);
		ImageIcon img4 = new ImageIcon("images/log/b4.png");
		jbt = Tools.setView(bot, img4);
		jbt.setBounds(108, 5, img4.getIconWidth(), img4.getIconHeight());
		jbt.addMouseListener(this);
		bot.setBounds(0, 240, bot.getWidth(), bot.getHeight());
		ImageIcon img10 = new ImageIcon("images/log/b10.png");
		JLabel bg = new JLabel(img10);
		bg.setBounds(0, 0, 380, 50);
		bot.add(bg);
		jframe.add(bot);
		
		setBgimg();//设置背景
		jframe.setVisible(true);
	}
	
	//拖动窗体的方法
	private void setDragable() {
		jframe.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				isDragged = false;
				jframe.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());//获取窗体位置
				isDragged = true;
				jframe.setCursor(new Cursor(Cursor.MOVE_CURSOR));
			}
		});
		jframe.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (isDragged) {
					loc = new Point(jframe.getLocation().x + e.getX()
							- tmp.x, jframe.getLocation().y + e.getY()
							- tmp.y);
					jframe.setLocation(loc);
				}
			}
		});
	} 
	
	//设置背景
	public void setBgimg() {
		@SuppressWarnings("deprecation")
		int h = new Date().getHours();
		bg = new JLabel();
		if(4<h&&h<=10){
			bg.setIcon(new ImageIcon("images/log/morning.jpg"));
		}else if(10<h&&h<=15){
			bg.setIcon(new ImageIcon("images/log/noon.jpg"));
		}else if(15<h&&h<=19){
			bg.setIcon(new ImageIcon("images/log/afternoon.jpg"));
		}else if(19<h&&h<=24||0<=h&&h<=4){
			bg.setIcon(new ImageIcon("images/log/night.jpg"));
		}
		bg.setBounds(0, 0, 380, 290);
		jframe.add(bg);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		uname = cen.getName();
		pwd = cen.getPassword();
		System.out.println(uname+"\t" +pwd);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==jbt){
			ImageIcon img5 = new ImageIcon("images/log/b5.png");
			jbt.setIcon(img5);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() == jbt) {
			jframe.setVisible(false);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==jbt){
			ImageIcon img5 = new ImageIcon("images/log/b5.png");
			jbt.setIcon(img5);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==jbt){
			ImageIcon img4 = new ImageIcon("images/log/b4.png");
			jbt.setIcon(img4);
		}
	}

	public static void main(String[] args) {
		new LoginUI();
	}
	
	public String getUsername() {
		return uname;
	}
	
	public String getPassword() {
		return pwd;
	}
}