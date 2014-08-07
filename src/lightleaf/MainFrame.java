package lightleaf;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import lightleaf.button.MenuButton;
import lightleaf.button.NewButton;
import lightleaf.button.SaveButton;
import lightleaf.panel.HeaderPanel;
import lightleaf.panel.MainPanel;
import lightleaf.panel.MenuPanel;
import lightleaf.panel.main.DraftPanel;
import lightleaf.panel.main.InboxPanel;
import lightleaf.panel.main.NewPanel;
import lightleaf.panel.main.SentPanel;
import lightleaf.panel.main.SettingPanel;
import lightleaf.panel.main.StarredPanel;
import lightleaf.panel.main.TrashPanel;
import lightleaf.thread.RefreshThread;

public class MainFrame extends JFrame {

	CardLayout cl = new CardLayout();

	MenuPanel menu = new MenuPanel();
	MainPanel pan = new MainPanel();
	InboxPanel inbox = new InboxPanel();
	SentPanel sent = new SentPanel();
	TrashPanel trash = new TrashPanel();
	StarredPanel starred = new StarredPanel();
	DraftPanel draft = new DraftPanel();
	SettingPanel setting = new SettingPanel();
	NewPanel newPanel = new NewPanel();
	JPanel newMenuPanel = new JPanel();
	JPanel mainMenuPanel = new JPanel();
	
	MenuButton inboxButton = new MenuButton("Inbox");
	MenuButton trashButton = new MenuButton("Trash");
	MenuButton sentButton = new MenuButton("Sent");
	MenuButton starredButton = new MenuButton("Starred");
	MenuButton draftButton = new MenuButton("Draft");
	MenuButton settingButton = new MenuButton("Setting");
	NewButton newButton = new NewButton("New");
	
	JTextField address = new JTextField("");
	JPasswordField password = new JPasswordField(10);
	JLabel passwordLabel = new JLabel("Password : ");
	JLabel addressLabel = new JLabel("Email Adress : ");	
	SaveButton saveButton = new SaveButton("Save");
	
	//ArrayList<MenuButton> listMenuButton = new ArrayList<MenuButton>();

	public MainFrame() {
		//this.setUndecorated(true);
		this.setResizable(true);
		this.setTitle("LightLeaf mail");
		this.setSize(800, 900);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread refresh = new Thread(new RefreshThread());
		refresh.start();
		
		this.setLayout(new BorderLayout());
		
		//Header ----------------------------------------------------
		HeaderPanel header = new HeaderPanel();
		
		//Menu ---------------------------------------------------------
		inboxButton.addActionListener(new InboxButtonListener());
		sentButton.addActionListener(new SentButtonListener());
		trashButton.addActionListener(new TrashButtonListener());
		starredButton.addActionListener(new StarredButtonListener());
		draftButton.addActionListener(new DraftButtonListener());
		settingButton.addActionListener(new SettingButtonListener());
		newButton.addActionListener(new NewButtonListener());
		
		/*listMenuButton.add(inboxButton);
		listMenuButton.add(sentButton);
		listMenuButton.add(trashButton);
		listMenuButton.add(starredButton);
		listMenuButton.add(draftButton);
		listMenuButton.add(settingButton);*/
		
		newMenuPanel.setLayout(new BoxLayout(newMenuPanel, BoxLayout.LINE_AXIS));
		newMenuPanel.add(newButton, BorderLayout.CENTER);
		
		mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS));
		mainMenuPanel.add(inboxButton);
		mainMenuPanel.add(sentButton);
		mainMenuPanel.add(trashButton);
		mainMenuPanel.add(starredButton);
		mainMenuPanel.add(draftButton);
		mainMenuPanel.add(settingButton);
		
		menu.add(newMenuPanel);
		menu.add(mainMenuPanel);
		
		inboxButton.setSelected(true);
		
		//Setting --------------------------------------------------------
		JPanel form = new JPanel();
	    Font police = new Font("Arial", Font.PLAIN, 12);
	    address.setFont(police);
	    address.setPreferredSize(new Dimension(150, 30));
	    address.setForeground(Color.BLACK);
	    password.setFont(police);
	    password.setPreferredSize(new Dimension(150, 30));
	    password.setForeground(Color.BLACK);
	    
	    form.add(addressLabel);
	    form.add(address);
	    form.add(passwordLabel);
	    form.add(password);
	    form.add(saveButton);
	    setting.add(form, BorderLayout.WEST);
		
		//Main ------------------------------------------------------------
		pan.setLayout(cl);
		pan.add(inbox, "inbox");
		pan.add(sent, "sent");
		pan.add(trash, "trash");
		pan.add(starred, "starred");
		pan.add(draft, "draft");
		pan.add(setting, "setting");
		pan.add(newPanel, "new");
		
		this.getContentPane().add(header, BorderLayout.NORTH);
		this.getContentPane().add(menu, BorderLayout.WEST);
		this.getContentPane().add(pan, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	class InboxButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cl.show(pan, "inbox");
			Component[] menuButtons = mainMenuPanel.getComponents();
			for(int i=0; i<menuButtons.length; i++)
		    {
		        if (menuButtons[i] instanceof MenuButton)
		        {
		            MenuButton m = (MenuButton)menuButtons[i];
		            m.setSelected(false);
		        }
		    }
			inboxButton.setSelected(true);
		}
	}
	class SentButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cl.show(pan, "sent");
			Component[] menuButtons = mainMenuPanel.getComponents();
			for(int i=0; i<menuButtons.length; i++)
		    {
		        if (menuButtons[i] instanceof MenuButton)
		        {
		            MenuButton m = (MenuButton)menuButtons[i];
		            m.setSelected(false);
		        }
		    }
			sentButton.setSelected(true);
		}
	}
	class TrashButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cl.show(pan, "trash");
			Component[] menuButtons = mainMenuPanel.getComponents();
			for(int i=0; i<menuButtons.length; i++)
		    {
		        if (menuButtons[i] instanceof MenuButton)
		        {
		            MenuButton m = (MenuButton)menuButtons[i];
		            m.setSelected(false);
		        }
		    }
			trashButton.setSelected(true);
		}
	}
	class StarredButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cl.show(pan, "starred");
			Component[] menuButtons = mainMenuPanel.getComponents();
			for(int i=0; i<menuButtons.length; i++)
		    {
		        if (menuButtons[i] instanceof MenuButton)
		        {
		            MenuButton m = (MenuButton)menuButtons[i];
		            m.setSelected(false);
		        }
		    }
			starredButton.setSelected(true);
		}
	}
	class DraftButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cl.show(pan, "draft");
			Component[] menuButtons = mainMenuPanel.getComponents();
			for(int i=0; i<menuButtons.length; i++)
		    {
		        if (menuButtons[i] instanceof MenuButton)
		        {
		            MenuButton m = (MenuButton)menuButtons[i];
		            m.setSelected(false);
		        }
		    }
			draftButton.setSelected(true);
		}
	}
	class SettingButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cl.show(pan, "setting");
			Component[] menuButtons = mainMenuPanel.getComponents();
			for(int i=0; i<menuButtons.length; i++)
		    {
		        if (menuButtons[i] instanceof MenuButton)
		        {
		            MenuButton m = (MenuButton)menuButtons[i];
		            m.setSelected(false);
		        }
		    }
			settingButton.setSelected(true);
		}
	}
	class NewButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cl.show(pan, "new");
		}
	}
}