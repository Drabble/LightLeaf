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
               
                CardLayout cl = new CardLayout();
               
                MenuPanel menu = new MenuPanel();
                MainPanel pan = new MainPanel();
                InboxPanel inbox = new InboxPanel();
    SentPanel sent = new SentPanel();
    TrashPanel trash = new TrashPanel();
   
    MenuButton inboxButton = new MenuButton("Inbox");
                MenuButton trashButton = new MenuButton("Trash");
                MenuButton sentButton = new MenuButton("Sent");
               
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
                    inboxButton.addActionListener( new InboxButtonListener());
                    sentButton.addActionListener( new SentButtonListener());
                    trashButton.addActionListener( new TrashButtonListener());
                   
                    menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));
                    menu.add(inboxButton);
                    menu.add(sentButton);
                    menu.add(trashButton);
                   
                    //Main ------------------------------------------------------------
                    pan.setLayout(cl);
                    pan.add(inbox, "inbox");
                    pan.add(sent, "sent");
                    pan.add(trash, "trash");
 
                    this.getContentPane().add(header, BorderLayout.NORTH); 
                    this.getContentPane().add(menu, BorderLayout.WEST); 
                    this.getContentPane().add(pan, BorderLayout.CENTER); 
                    
                    this.setVisible(true);
                  }
               
                class InboxButtonListener implements ActionListener{
                               public void actionPerformed(ActionEvent e) {
                                               cl.show(pan,  "inbox");
                               }
                }
                class SentButtonListener implements ActionListener{
                               public void actionPerformed(ActionEvent e) {
                                               cl.show(pan,  "sent");
                               }
                }
                class TrashButtonListener implements ActionListener{
                               public void actionPerformed(ActionEvent e) {
                                               cl.show(pan,  "trash");
                               }
                }
}