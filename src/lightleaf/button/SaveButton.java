package lightleaf.button;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException; 

import javax.imageio.ImageIO;
import javax.swing.JButton;

import sun.java2d.loops.FillRect;

public class SaveButton extends JButton implements MouseListener{
  private String name;
  private Color c;
  
  public SaveButton(String str){
    this.name = str;
    this.setBorderPainted(false);
    this.c = Color.decode("#009933");
	this.setPreferredSize( new Dimension( 150, 40) );
	this.setMaximumSize( new Dimension( 150, 40));
	this.setMinimumSize(new Dimension( 150, 40));
    this.addMouseListener(this);
    this.setCursor(new Cursor(Cursor.HAND_CURSOR));
  }

  public void paintComponent(Graphics g){
	g.setColor(c); 
	g.fillRect(0, 0, 150, 40);

    g.setFont(new Font("Arial", Font.BOLD, 11));
    g.setColor(Color.white);          
    g.drawString(this.name, this.getWidth() / 2 - (this.getWidth() /  2 /4), (this.getHeight() / 2) + 5);
  }

  //Méthode appelée lors du clic de souris
  public void mouseClicked(MouseEvent event) {
	  
  }

  //Méthode appelée lors du survol de la souris
  public void mouseEntered(MouseEvent event) {
	  this.c = Color.decode("#006633");
      
  }

  //Méthode appelée lorsque la souris sort de la zone du bouton
  public void mouseExited(MouseEvent event) {
	  this.c = Color.decode("#009933");
  }

  //Méthode appelée lorsque l'on presse le bouton gauche de la souris
  public void mousePressed(MouseEvent event) {
  }

  //Méthode appelée lorsque l'on relâche le clic de souris
  public void mouseReleased(MouseEvent event) { }       
}