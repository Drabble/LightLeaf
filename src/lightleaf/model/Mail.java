package lightleaf.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;

import lightleaf.observer.Observer;

public class Mail extends MailAbstract{
	private String type; // Draft Inbox Sent Trash
	private boolean starred; 
	private String content;
	private String subject;
	private String sender;
	private String to;
	private String cc;
	
	public Mail(){    
		notifyObserver("NewMail");
	}
	
	public void sendMail(Setting setting){
		final String username = setting.getAddress();
		final String password = setting.getPassword();
 
		Properties props = new Properties(); 
		try {
			props.load(new FileInputStream(new File("src/lightleaf/resources/config/mail.conf")));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(this.getTo()));
			message.setSubject(this.getSubject());
			message.setText(this.getContent());
 
			Transport.send(message);
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void readMail(Setting setting){
		final String username = setting.getAddress();
		final String password = setting.getPassword();
		String receivingHost="imap.gmail.com";//for imap protocol
		 
        Properties props2=System.getProperties();
        props2.setProperty("mail.store.protocol", "imaps");
        // I used imaps protocol here
        Session session2=Session.getDefaultInstance(props2, null);
            try {
                    Store store=session2.getStore("imaps");
                    store.connect(receivingHost,username, password);
                    Folder folder=store.getFolder("INBOX");//get inbox
                    folder.open(Folder.READ_ONLY);//open folder only to read
                    Message message[]=folder.getMessages();
                    for(int i=0;i<message.length;i++){
                        //print subjects of all mails in the inbox
                        System.out.println(message[i].getSubject());
                        //anything else you want
                    }
                    //close connections
                    folder.close(true);
                    store.close();
            } catch (Exception e) {
                    System.out.println(e.toString());
            }
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isStarred() {
		return starred;
	}

	public void setStarred(boolean starred) {
		this.starred = starred;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String string) {
		this.cc = string;
	}
}
