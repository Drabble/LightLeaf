package lightleaf.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
 
public class HeaderPanel extends JPanel { 
	
	public HeaderPanel(){
		this.setPreferredSize( new Dimension( this.getWidth(), 40) );
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.decode("#080808"));
	    g.fillRect(0, 0, this.getWidth(), 40);
	    Font font = new Font("Arial", Font.BOLD, 11);
	    g.setFont(font);
	    g.setColor(Color.white);          
	    g.drawString("LightLeaf", 15, 25);   
	}     
  
}