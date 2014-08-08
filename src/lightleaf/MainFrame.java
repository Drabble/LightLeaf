package lightleaf;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import lightleaf.button.MenuButton;
import lightleaf.button.NewButton;
import lightleaf.button.SaveButton;
import lightleaf.button.SendButton;
import lightleaf.model.Mail;
import lightleaf.model.Setting;
import lightleaf.panel.HeaderPanel;
import lightleaf.panel.MainPanel;
import lightleaf.panel.MenuPanel;
import lightleaf.panel.main.DraftPanel;
import lightleaf.panel.main.FormPanel;
import lightleaf.panel.main.InboxPanel;
import lightleaf.panel.main.NewPanel;
import lightleaf.panel.main.SentPanel;
import lightleaf.panel.main.SettingPanel;
import lightleaf.panel.main.StarredPanel;
import lightleaf.panel.main.TrashPanel;
import lightleaf.thread.RefreshThread;

public class MainFrame extends JFrame {

	Setting setting = new Setting();
	CardLayout cl = new CardLayout();

	MenuPanel menu = new MenuPanel();
	MainPanel pan = new MainPanel();
	InboxPanel inboxPanel = new InboxPanel();
	SentPanel sentPanel = new SentPanel();
	TrashPanel trashPanel = new TrashPanel();
	StarredPanel starredPanel = new StarredPanel();
	DraftPanel draftPanel = new DraftPanel();
	SettingPanel settingPanel = new SettingPanel();
	NewPanel newPanel = new NewPanel();
	JPanel newMenuPanel = new JPanel();
	JPanel mainMenuPanel = new JPanel();
	
	
	MenuButton inboxButton = new MenuButton("inboxPanel");
	MenuButton trashButton = new MenuButton("trashPanel");
	MenuButton sentButton = new MenuButton("sentPanel");
	MenuButton starredButton = new MenuButton("starredPanel");
	MenuButton draftButton = new MenuButton("draftPanel");
	MenuButton settingButton = new MenuButton("Setting");
	NewButton newButton = new NewButton("New");
	
	FormPanel settingForm = new FormPanel();
	JTextField address = new JTextField("");
	JLabel addressLabel = new JLabel("Email Adress : ");
	JPasswordField password = new JPasswordField(10);
	JLabel passwordLabel = new JLabel("Password : ");
	SaveButton saveButton = new SaveButton("Save");
	
	FormPanel newForm = new FormPanel();
	JTextField to = new JTextField("");
	JLabel toLabel = new JLabel("To : ");	
	JTextField cc = new JTextField("");
	JLabel ccLabel = new JLabel("Cc : ");	
	JTextField subject = new JTextField("");
	JLabel subjectLabel = new JLabel("Subject : ");	
	JTextArea content = new JTextArea(35, 50);
	JScrollPane scrollPane = new JScrollPane(content); 
	SendButton sendButton = new SendButton("Send");
	
	Font textFieldPolice = new Font("Arial", Font.PLAIN, 12);
	
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
		saveButton.addActionListener(new SaveButtonListener());
		sendButton.addActionListener(new SendButtonListener());
		
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
		
		//New --------------------------------------------------------
		JPanel toPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		toPanel.setBackground(Color.WHITE);
	    to.setFont(textFieldPolice);
	    to.setPreferredSize(new Dimension(200, 40));
	    to.setForeground(Color.BLACK);
	    toPanel.add(toLabel);
	    toPanel.add(to);
	    
	    JPanel ccPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ccPanel.setBackground(Color.WHITE);
	    cc.setFont(textFieldPolice);
	    cc.setPreferredSize(new Dimension(200, 40));
	    cc.setForeground(Color.BLACK);
	    ccPanel.add(ccLabel);
	    ccPanel.add(cc);
	    
	    JPanel subjectPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    subjectPanel.setBackground(Color.WHITE);
	    subject.setFont(textFieldPolice);
	    subject.setPreferredSize(new Dimension(350, 40));
	    subject.setForeground(Color.BLACK);
	    subjectPanel.add(subjectLabel);
	    subjectPanel.add(subject);
	    
	    JPanel contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    contentPanel.setBackground(Color.WHITE);
	    content.setFont(textFieldPolice);
	    content.setForeground(Color.BLACK);
	    content.setPreferredSize(new Dimension(350, 400));
	    Border border = BorderFactory.createLineBorder(Color.BLACK);
	    content.setBorder(BorderFactory.createCompoundBorder(border, 
	                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	    contentPanel.add(content);
	    
	    JPanel sendPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    sendPanel.setBackground(Color.WHITE);
	    sendPanel.add(sendButton);

	    newForm.setLayout(new BoxLayout(newForm, BoxLayout.Y_AXIS));
	    newForm.setAlignmentX( Component.LEFT_ALIGNMENT );
	    newForm.add(toPanel);
	    newForm.add(ccPanel);
	    newForm.add(subjectPanel);
	    newForm.add(contentPanel);
	    newForm.add(sendPanel);
	    
	    GridBagConstraints gbcNew = new GridBagConstraints();
	    gbcNew.weightx = 1;
	    gbcNew.weighty = 1;
	    gbcNew.anchor = GridBagConstraints.NORTHWEST;
	    
	    gbcNew.gridx = 0;
	    gbcNew.gridy = 0;
	    newPanel.setLayout(new GridBagLayout());
	    newPanel.add(newForm, gbcNew);
	    JPanel newPaddingPanel = new JPanel();
	    newPaddingPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
	    newPaddingPanel.setBackground(Color.WHITE);
	    newPaddingPanel.add(newPanel);
		
		//Setting --------------------------------------------------------
	    address.setFont(textFieldPolice);
	    address.setPreferredSize(new Dimension(150, 30));
	    address.setForeground(Color.BLACK);
	    address.setText(setting.getAddress());
	    password.setFont(textFieldPolice);
	    password.setPreferredSize(new Dimension(150, 30));
	    password.setForeground(Color.BLACK);
	    password.setText(setting.getPassword());
	    System.out.println(setting.getPassword());
	    System.out.println(setting.getAddress());
	    
	    GridLayout glSetting = new GridLayout();
	    glSetting.setColumns(1);
	    glSetting.setRows(3);
	    glSetting.setHgap(10);
	    glSetting.setVgap(10);
	    settingForm.setLayout(glSetting);	
	    settingForm.add(addressLabel);
	    settingForm.add(address);
	    settingForm.add(passwordLabel);
	    settingForm.add(password);
	    settingForm.add(saveButton);
	    
	    GridBagConstraints gbcSetting = new GridBagConstraints();
	    gbcSetting.weightx = 1;
	    gbcSetting.weighty = 1;
	    gbcSetting.anchor = GridBagConstraints.NORTHWEST;
	    
	    gbcSetting.gridx = 0;
	    gbcSetting.gridy = 0;
	    settingPanel.setLayout(new GridBagLayout());
	    settingPanel.add(settingForm, gbcSetting);
	    JPanel settingPaddingPanel = new JPanel();
	    settingPaddingPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
	    settingPaddingPanel.setBackground(Color.WHITE);
	    settingPaddingPanel.add(settingPanel);
		
		//Main ------------------------------------------------------------
		pan.setLayout(cl);
		pan.add(inboxPanel, "inboxPanel");
		pan.add(sentPanel, "sentPanel");
		pan.add(trashPanel, "trashPanel");
		pan.add(starredPanel, "starredPanel");
		pan.add(draftPanel, "draftPanel");
		pan.add(settingPaddingPanel, "settingPanel");
		pan.add(newPaddingPanel, "new");
		
		this.getContentPane().add(header, BorderLayout.NORTH);
		this.getContentPane().add(menu, BorderLayout.WEST);
		this.getContentPane().add(pan, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	class InboxButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cl.show(pan, "inboxPanel");
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
			cl.show(pan, "sentPanel");
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
			cl.show(pan, "trashPanel");
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
			cl.show(pan, "starredPanel");
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
			cl.show(pan, "draftPanel");
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
			cl.show(pan, "settingPanel");
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
	class SaveButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String passwordText = "";
			String addressText = "";
			if(address.getText().length()>0){
				addressText = address.getText();
			}
			if(password.getText().length()>0){
				passwordText = password.getText();
			}
			setting.setAddress(addressText);
			setting.setPassword(passwordText);
		}
	}
	class SendButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Mail m = new Mail();
			if(to.getText().length()>0){
				m.setTo(to.getText());
			}
			if(cc.getText().length()>0){
				m.setTo(cc.getText());
			}
			if(subject.getText().length()>0){
				m.setTo(subject.getText());
			}
			if(content.getText().length()>0){
				m.setTo(content.getText());
			}
			m.sendMail(setting);
			to.setText("");
			cc.setText("");
			subject.setText("");
			content.setText("");
		}
	}
}