package lightleaf;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
 
public class MainPanel extends JPanel { 
  public void paintComponent(Graphics g){
	  
	        
	    
   
	g.setColor(Color.decode("#080808"));
    g.fillRect(0, 0, this.getWidth(), 40);
    
    g.setColor(Color.decode("#009933")); 
    g.fillRect(0, 40, 150, this.getHeight() - 40);
    
    g.setColor(Color.decode("#006633")); 
    g.fillRect(0, 200, 150, 40);
    
    g.setColor(Color.decode("#F4130D")); 
    g.fillRoundRect(15, 50, 120, 40, 5, 5);
    
    g.setColor(Color.white); 
    g.fillRect(150, 40, this.getWidth() - 80, this.getHeight() - 40);
    
  
    
    Font font = new Font("Arial", Font.BOLD, 11);
    g.setFont(font);
    g.setColor(Color.white);          
    g.drawString("LightLeaf", 15, 25);   
    

  }     
  
}