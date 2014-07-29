package lightleaf;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	public MainFrame(){
		this.setUndecorated(true);
		this.setResizable(true);
	    this.setTitle("LightLeaf mail");
	    this.setSize(800, 900);
	    this.setLocationRelativeTo(null);
	        
	    
	    //Instanciation d'un objet JPanel
	    MainPanel pan = new MainPanel();
	    //Définition de sa couleur de fond
	    pan.setBackground(Color.black);        
	    
	    
	    //On prévient notre JFrame que notre JPanel sera son content pane
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    this.setContentPane(pan);  
	    this.setVisible(true);
	    
	  }
}
