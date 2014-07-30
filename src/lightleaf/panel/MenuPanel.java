package lightleaf.panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
 
public class MenuPanel extends JPanel { 
	public MenuPanel(){
		this.setPreferredSize( new Dimension( 150, this.getHeight() ) );
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.decode("#009933")); 
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}     
}