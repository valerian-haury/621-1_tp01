package ch.hesge.db;

public class CalculeThread  extends Thread{
	
	public CalculeThread() {
		super();
	}

	//Ne pas modifier cette méthode
	public void run() {
		System.out.println("==>CalculeProcess()");
		System.out.println("==> simulation d'un long calcule......");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Database().inc();
	}
}
