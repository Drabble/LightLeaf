package lightleaf.thread;

public class RefreshThread extends Thread {

	public RefreshThread(){
	}
	
	public void run(){
		for(int i = 0; i < 10; i++){
			System.out.println("Reloading mails");
			try {
				this.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
	}
}
