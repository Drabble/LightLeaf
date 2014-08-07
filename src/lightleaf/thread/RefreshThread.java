package lightleaf.thread;

public class RefreshThread implements Runnable {

	public RefreshThread(){
	}
	
	public void run(){
		for(int i = 0; i < 10; i++){
			System.out.println("Reloading mails");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
	}
}
