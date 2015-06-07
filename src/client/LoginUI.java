package client;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class LoginUI extends JFrame {
	//Components
	JLabel head;
	JLabel idLabel;
	JLabel pwdLabel;
	JTextField idTextField;
	JPasswordField pwdField;
	JButton loginIn;
	JButton cancle;	
	private static final Font fontc = new Font("Î¢ÈíÑÅºÚ",Font.PLAIN+Font.BOLD,14);
	private static final Font fonte = new Font("Calibri",Font.PLAIN,14);
	
	//Information
	String id;
	String pwd;
	
	public LoginUI() {
		setSize(380, 290);
		//background
		head = new JLabel();
		ImageIcon icon = new ImageIcon("images/log/bg.png");
		icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT));
		head.setBounds(0, 0, 380, 290);  
        head.setHorizontalAlignment(0);  
        head.setIcon(icon);         
        
        //Username and password
        idLabel = new JLabel(" µÇÂ¼ÕËºÅ");
        pwdLabel = new JLabel(" µÇÂ¼ÃÜÂë");
        idLabel.setFont(fontc);
        idLabel.setForeground(Color.WHITE);
        pwdLabel.setFont(fontc);
        pwdLabel.setForeground(Color.WHITE);
        idTextField = new JTextField();
        idTextField.setFont(fonte);
        idTextField.setText("User ID/Name");
        pwdField = new JPasswordField();
        idLabel.setBounds(20, 110, 100, 27);
        pwdLabel.setBounds(20, 145, 100, 27);
        idTextField.setBounds(110, 110, 215, 27);
        pwdField.setBounds(110, 145, 215, 27);
        head.add(idLabel);
        head.add(pwdLabel);
        head.add(idTextField);
        head.add(pwdField);
        
        ImageIcon img1 = new ImageIcon("images/log/p1.png");
        loginIn = new JButton(img1);
       	loginIn.setOpaque(false);
       	loginIn.setBounds(45, 200, 110, 27);
        ImageIcon img4 = new ImageIcon("images/log/p2.png");
        cancle = new JButton(img4);
       	cancle.setOpaque(false);
       	cancle.setBounds(205, 200, 110, 27);
       	
       	head.add(loginIn);
       	head.add(cancle);      	
        
        add(head);
        
        //display
        this.setTitle("µÇÂ¼");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        //Listeners
        idTextField.addMouseListener(
        	new MouseAdapter() {
        		public void mouseClicked(MouseEvent me) {
        			idTextField.setText("");
        		}
        	}
        );
        
        loginIn.addActionListener(
			new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					id = idTextField.getText();
					pwd = pwdField.getText();
					System.out.println(id+"\t"+pwd);
					// Óëserver ½»»¥
					//If correct, accoding to ID, here manager as an example!
					@SuppressWarnings("unused")
					AdministratorUI mui = new AdministratorUI(id);
					setInvisible();
				}
			}
		); 
        
        cancle.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setInvisible();
				}
			}
    	);
	}
	
	public void setInvisible() {
		this.setVisible(false);
	}
	
	public String getID() {
		return id;
	}

}