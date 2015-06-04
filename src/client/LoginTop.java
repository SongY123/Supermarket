package client;
/**
 * 登录界面的顶部
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoginTop extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9088362429217950123L;
	private JButton min; //最小化按钮
	private JButton close; //关闭按钮
	private List<ImageIcon> list = new ArrayList<ImageIcon>();
	private LoginUI frame;
	
	public LoginTop(LoginUI frame) {
		this.frame = frame;
		getImg();
		setLoginToppanel();
	}
	
	//设置面板
	public void setLoginToppanel() {
		this.setSize(380,30);
		this.setLayout(null);
		this.setOpaque(false);
		
		//最小化按钮
		min = Tools.setView(this, list.get(3));
		min.setBounds(313, 0, list.get(3).getIconWidth(), list.get(3).getIconHeight());
		min.addMouseListener(this);
		//关闭按钮
		close = Tools.setView(this, list.get(6));
		close.setBounds(341, 0, list.get(6).getIconWidth(), list.get(6).getIconHeight());
		close.addMouseListener(this);
	}
	
	public void getImg() {
		for(int i=1;i<10;i++){
			ImageIcon img = new ImageIcon("images/log/"+i+".png");
			list.add(img);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==min){
			min.setIcon(list.get(5));
			frame.getFrame().setExtendedState(JFrame.ICONIFIED);
		}
		if(e.getSource()==close){
			close.setIcon(list.get(8));
			System.exit(0);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==min){
			min.setIcon(list.get(4));
		}
		if(e.getSource()==close){
			close.setIcon(list.get(7));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==min){
			min.setIcon(list.get(3));
		}
		if(e.getSource()==close){
			close.setIcon(list.get(6));
		}
	}
}
