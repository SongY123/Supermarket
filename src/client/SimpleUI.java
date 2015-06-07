package client;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.Date;



public class SimpleUI extends JFrame{
	
	//Components
	JLabel bg;
	JLabel headTitle;
	JLabel userLabel;
	JTextField userInfo;
	JLabel customerLabel;
	JTextField customerInfo;
	JLabel dataLabel;
	JLabel goodIdLabel;
	JTextField goodIdInfo;
	JLabel goodNumLabel;
	JTextField goodNumInfo;
	JButton addItemButton;
	JButton resetItemButton;
	JLabel listTitle;
	JTextArea tarea;
	ScrollPane spanel;
	JLabel sumLabel;
	JLabel sumNumLabel;
	JLabel s1;
	JLabel s2;
	JLabel s3;
	JLabel s4;
	
	//constants
	private static final Font fontc = new Font("微软雅黑",Font.PLAIN+Font.BOLD,20);
	private static final Font fonte = new Font("Calibri",Font.PLAIN,16);
	private static final Font fontc1 = new Font("微软雅黑",Font.PLAIN,14);
	private static final Font fontc2 = new Font("微软雅黑",Font.PLAIN+Font.BOLD,17);
	private static final String splitline = "--------------------------------------------"
			+ "------------------------------------------------------------------"
			+ "------------------------------------";
	private static final String splitline2 = "--------------------------------------------"
			+ "------------------------------------------------------";
	
	
	@SuppressWarnings("deprecation")
	public SimpleUI() {		
		setSize(600, 800);
		bg = new JLabel();
		//ImageIcon icon = new ImageIcon("images/bg1.jpg");
		//icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT));
		bg.setBounds(0, 0, 600, 800);  
        bg.setHorizontalAlignment(0);  
       // bg.setIcon(icon); 
        
        //head title
		headTitle = new JLabel("NJUSE 超市收银系统");
		headTitle.setFont(fontc);
		headTitle.setBounds(200,10,200,25);
		bg.add(headTitle);
		
		//日期
		Date d = new Date();
		int year = d.getYear()+1900;
		int month = d.getMonth();
		int day = d.getDay();
		int daynum = d.getDate();
		int hour = d.getHours();
		int minute = d.getMinutes();
		String ds = String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(daynum);
		String hh = "";
		String mm = "";
		if(hour<10) {
			hh = "0"+ String.valueOf(hour);
		}
		else {
			hh = String.valueOf(hour);
		}
		if(minute<10) {
			mm = "0"+ String.valueOf(minute);
		}
		else {
			mm = String.valueOf(minute);
		}
		String ds2 = hh+" : "+mm;
		String ds3 = getDayString(day);
		String ddd = ds+"    "+ds2+"    "+ds3;		
		dataLabel = new JLabel(ddd);
		dataLabel.setFont(fonte);
		dataLabel.setBounds(200, 40, 200, 20);
		bg.add(dataLabel);
		
		//split line
		s1 = new JLabel(splitline);
		s1.setBounds(0, 55, 600, 20);
		bg.add(s1);
		
		//操作员
		userLabel = new JLabel("操作员：");
		userLabel.setFont(fontc1);
		userLabel.setBounds(25, 80, 75, 25);
		userInfo = new JTextField();
		userInfo.setText("101");
		userInfo.setFont(fonte);
		userInfo.setEditable(false);
		userInfo.setBounds(85, 80, 125, 25);
		bg.add(userLabel);
		bg.add(userInfo);
		
		//会员信息
		customerLabel = new JLabel("会员编号：");
		customerLabel.setFont(fontc1);
		customerLabel.setBounds(300, 80, 105, 25);
		customerInfo = new JTextField();
		customerInfo.setText("1001");
		customerInfo.setFont(fonte);
		customerInfo.setEditable(true);
		customerInfo.setBounds(410, 80, 125, 25);
		bg.add(customerLabel);
		bg.add(customerInfo);	
		
		//split line2
		s2 = new JLabel(splitline);
		s2.setBounds(0, 115, 600, 20);
		bg.add(s2);
		
		// goodIdLable;
		// goodNumLabel;
		// 商品编号
		goodIdLabel = new JLabel("商品编号：");
		goodIdLabel.setFont(fontc1);
		goodIdLabel.setBounds(25, 140, 105, 25);
		goodIdInfo = new JTextField();
		goodIdInfo.setFont(fonte);
		goodIdInfo.setEditable(true);
		goodIdInfo.setBounds(110, 140, 200, 25);
		bg.add(goodIdLabel);
		bg.add(goodIdInfo);
		
		// 商品数量
		goodNumLabel = new JLabel("商品数量：");
		goodNumLabel.setFont(fontc1);
		goodNumLabel.setBounds(25, 176, 105, 25);
		goodNumInfo = new JTextField();
		goodNumInfo.setFont(fonte);
		goodNumInfo.setEditable(true);
		goodNumInfo.setBounds(110, 176, 200, 25);
		bg.add(goodNumLabel);
		bg.add(goodNumInfo);
		
		//buttons for add and reset
		addItemButton = new JButton("添加");
		addItemButton.setFont(fontc1);
		addItemButton.setBounds(365, 158, 80, 25);
		resetItemButton = new JButton("重置");
		resetItemButton.setFont(fontc1);
		resetItemButton.setBounds(470, 158, 80, 25);
		bg.add(addItemButton);
		bg.add(resetItemButton);
		
		//split line3
		s3 = new JLabel(splitline);
		s3.setBounds(0, 206, 600, 20);
		bg.add(s3);
		
		//listTitle
		listTitle = new JLabel("销售清单");
		listTitle.setFont(fontc2);
		listTitle.setBounds(255, 225, 80, 25);
		bg.add(listTitle);
		
		//textArea+Scrollpanel
		tarea = new JTextArea();
		tarea.setEditable(false);
		tarea.setFont(fontc1);
		tarea.append(" 编号\t名称\t\t数量\t单价\t小计\n"+splitline2+"\n");
		spanel = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
		spanel.add(tarea);
		spanel.setBounds(0, 260, 600, 250);
		bg.add(spanel);
		
		//split line4
		s4 = new JLabel(splitline);
		s4.setBounds(0, 520, 600, 20);
		bg.add(s4);
		
		//Sum
		
		add(bg);		
		this.setTitle("收银系统");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		addItemButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id = goodIdInfo.getText();
						String num = goodNumInfo.getText();
						if(!(id.equals("")||num.equals(""))) {
							tarea.append(" "+id+"\t"+"名称可能很长"+"\t\t"+num+"\t"+"单价"+"\t"+"小计"+"\n");
						}
						goodIdInfo.setText("");
						goodNumInfo.setText("");
					}
				}
			); 
		
		resetItemButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						goodIdInfo.setText("");
						goodNumInfo.setText("");
					}
				}
			); 
	}

	
	private String getDayString(int t) {
		String temp = "";
		if(t == 0) {
			temp = temp+"Sunday";
		}
		else if(t == 1) {
			temp = temp+"Monday";
		}
		else if(t == 2) {
			temp = temp+"Tuesday";
		}
		else if(t == 3) {
			temp = temp+"Wednesday";
		}
		else if(t == 4) {
			temp = temp+"Thursday";
		}
		else if(t == 5) {
			temp = temp+"Friday";
		}
		else {
			temp = temp+"Saturday";
		}

		
		return temp;
	}
}
