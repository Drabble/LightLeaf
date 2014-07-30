package lightleaf.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
 
public class HeaderPanel extends JPanel { 
	
	private Image exit;
	private Image maximize;
	private Image minimize;
	
	public HeaderPanel(){
		this.setPreferredSize( new Dimension( this.getWidth(), 40) );
		
		try {
	      maximize = ImageIO.read(new File("maximize.png"));
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		
		try {
	      minimize = ImageIO.read(new File("minimize.png"));
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		
		try {
	      exit = ImageIO.read(new File("exit.png"));
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.decode("#080808"));
	    g.fillRect(0, 0, this.getWidth(), 40);
	    Font font = new Font("Arial", Font.BOLD, 11);
	    g.setFont(font);
	    g.setColor(Color.white);          
	    g.drawString("LightLeaf", 15, 25);   
	    
	    
	    Graphics2D g2d = (Graphics2D)g;

	    g2d.drawImage(exit, this.getWidth() - 15, 25, 32, 32, this);
	    g2d.drawImage(maximize, this.getWidth() - 25, 25, 32, 32, this);
	    g2d.drawImage(minimize, this.getWidth() - 35, 25, 32, 32, this);
	}     
  
}