package lightleaf.panel.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class SettingPanel extends JPanel { 
	
  public void SettingPanel(){  
  }
	
  public void paintComponent(Graphics g){
	  g.setColor(Color.WHITE);
	  g.fillRect(0, 0, this.getWidth(), this.getHeight());
  }     
}