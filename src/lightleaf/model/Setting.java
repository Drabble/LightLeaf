package lightleaf.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Setting {
	private String address;
	private String password;
	
	public void Setting(){
		Properties props = new Properties();
	    InputStream is = null;
	 
	    // First try loading from the current directory
	    try {
	        File f = new File("server.properties");
	        is = new FileInputStream( f );
	    }
	    catch ( Exception e ) { is = null; }
	 
	    try {
	        if ( is == null ) {
	            // Try loading from classpath
	            is = getClass().getResourceAsStream("src/lightleaf/resources/config/setting.conf");
	        }
	 
	        // Try loading properties from the file (if found)
	        props.load( is );
	    }
	    catch ( Exception e ) { }
	 
	    this.setAddress(props.getProperty("Address"));
	    this.setPassword(props.getProperty("Password"));
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		try {
	        Properties props = new Properties();
	        if(this.address.length()>0){
		        props.setProperty("Address", this.address);
	        }
	        if(this.password.length()>0){
		        props.setProperty("Password", this.password);
	        }
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
	        if(this.address.length()>0){
		        props.setProperty("Address", this.address);
	        }
	        if(this.password.length()>0){
		        props.setProperty("Password", this.password);
	        }
	        File f = new File("src/lightleaf/resources/config/setting.conf");
	        OutputStream out = new FileOutputStream( f );
	        props.store(out, "Settings");
	    }
	    catch (Exception e ) {
	        e.printStackTrace();
	    }
	}
	
	
}
