package lightleaf.model;

import lightleaf.observer.Observer;

public class Mail extends MailAbstract{
	private String type; // Draft Inbox Sent Trash
	private boolean starred; 
	private String content;
	private String subject;
	private String sender;
	private String[] to;
	private String[] cc;
	
	public void Mail(String ope){    
		notifyObserver("NewMail");
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

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}
}
