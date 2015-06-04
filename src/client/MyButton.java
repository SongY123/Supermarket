package client;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MyButton extends JLabel{

	ImageIcon normal,hover;
	
	public MyButton(ImageIcon normal,ImageIcon hover){
		this.normal=normal;
		this.hover=hover;
		this.setIcon(normal);
		// button.add(this);
		addListener();
	}
	
	public void addListener(){
		this.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				MyButton.this.setIcon(hover);
			}
			public void mouseExited(MouseEvent e){
				MyButton.this.setIcon(normal);
			}
		});
	}
	
}
