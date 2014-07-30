package lightleaf;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import lightleaf.button.MenuButton;
import lightleaf.panel.HeaderPanel;
import lightleaf.panel.MainPanel;
import lightleaf.panel.MenuPanel;
import lightleaf.panel.main.InboxPanel;
import lightleaf.panel.main.SentPanel;
import lightleaf.panel.main.TrashPanel;

public class MainFrame extends JFrame{
	
	MainPanel pan = new MainPanel();
	CardLayout cl = new CardLayout();
	
	public MainFrame(){
		this.setUndecorated(true);
		this.setResizable(true);
	    this.setTitle("LightLeaf mail");
	    this.setSize(800, 900);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    
	    this.setLayout(new BorderLayout());    
	    
	    //Header ----------------------------------------------------
	    HeaderPanel header = new HeaderPanel();
	    
	    //Menu ---------------------------------------------------------
	    MenuPanel menu = new MenuPanel();
	    MenuButton inboxButton = new MenuButton("Inbox");
	    inboxButton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	          cl.show(pan,  "inbox");
	        }
	    });
	    MenuButton sentButton = new MenuButton("Sent");
	    sentButton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	          cl.show(pan,  "sent");
	        }
	    });
	    MenuButton trashButton = new MenuButton("Trash");
	    trashButton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	          cl.show(pan,  "trash");
	        }
	    });
	    menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));
	    menu.add(inboxButton);
	    menu.add(sentButton);
	    menu.add(trashButton);
	    
	    //Main ------------------------------------------------------------
	    InboxPanel inbox = new InboxPanel();
	    SentPanel sent = new SentPanel();
	    TrashPanel trash = new TrashPanel();
	    pan.setLayout(cl);
	    pan.add(inbox, "inbox");
	    pan.add(sent, "sent");
	    pan.add(trash, "trash");
	    
	    
	    
	    
	    
	    this.getContentPane().add(header, BorderLayout.NORTH);  
	    this.getContentPane().add(menu, BorderLayout.WEST);  
	    this.getContentPane().add(pan, BorderLayout.CENTER);  
	    
	    this.setVisible(true);
	  }
}
