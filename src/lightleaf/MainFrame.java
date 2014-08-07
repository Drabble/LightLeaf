package lightleaf;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import lightleaf.button.MenuButton;
import lightleaf.button.NewButton;
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
	
	MenuButton inboxButton = new MenuButton("Inbox");
	MenuButton trashButton = new MenuButton("Trash");
	MenuButton sentButton = new MenuButton("Sent");
	MenuButton starredButton = new MenuButton("Starred");
	MenuButton draftButton = new MenuButton("Draft");
	MenuButton settingButton = new MenuButton("Setting");
	
	NewButton newButton = new NewButton("New");

	public MainFrame() {
	//this.setUndecorated(true);
	this.setResizable(true);
	this.setTitle("LightLeaf mail");
	this.setSize(800, 900);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	RefreshThread refresh = new RefreshThread();
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
	
	JPanel newMenuPanel = new JPanel();
	JPanel mainMenuPanel = new JPanel();
	
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
		}
	}
	class SentButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cl.show(pan, "sent");
		}
	}
	class TrashButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cl.show(pan, "trash");
		}
	}
	class StarredButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cl.show(pan, "starred");
		}
	}
	class DraftButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cl.show(pan, "draft");
		}
	}
	class SettingButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cl.show(pan, "setting");
		}
	}
	class NewButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cl.show(pan, "new");
		}
	}
}