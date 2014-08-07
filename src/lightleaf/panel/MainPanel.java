package lightleaf.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
 
public class MainPanel extends JPanel { 
	public MainPanel(){
			this.setPreferredSize( new Dimension( this.getWidth(), this.getHeight()) );
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE); 
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}     
}