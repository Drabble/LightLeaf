package lightleaf.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Setting {
	private String address;
	private String password;
	
	public Setting(){
		try (FileReader reader = new FileReader("src/lightleaf/resources/config/setting.conf")) {
			Properties properties = new Properties();
			properties.load(reader);
			this.setAddress(properties.getProperty("Address"));
		    this.setPassword(properties.getProperty("Password"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		try {
	        Properties props = new Properties();
	        try{
		        props.setProperty("Address", this.address);
	        }
	        catch(Exception e){}
	        try{
	        	props.setProperty("Password", this.password);
	        }
	        catch(Exception e){}
	        File f = new File("src/lightleaf/resources/config/setting.conf");
	        OutputStream out = new FileOutputStream( f );
	        props.store(out, "Settings");
	    }
	    catch (Exception e ) {
	        e.printStackTrace();
	    }
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
		try {
	        Properties props = new Properties();
	        try{
		        props.setProperty("Address", this.address);
	        }
	        catch(Exception e){}
	        try{
	        	props.setProperty("Password", this.password);
	        }
	        catch(Exception e){}
	        File f = new File("src/lightleaf/resources/config/setting.conf");
	        OutputStream out = new FileOutputStream( f );
	        props.store(out, "Settings");
	    }
	    catch (Exception e ) {
	        e.printStackTrace();
	    }
	}
	
	
}
