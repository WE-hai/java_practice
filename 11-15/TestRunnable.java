class MyTask implements Runnable {
	private String cityName;
	MyTask(String cityName){
		this.cityName = cityName;
	}
	public void run() {
		int n ;
		for(int i = 0;i < 10;i++) {
			System.out.println((i+1)+"："+cityName);
			n = (int)(Math.random()*1000);
			try {
				Thread.sleep(n);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}	
}
public class TestRunnable {
	public static void main(String[] args) {
		MyTask t1 = new MyTask("xining");
		MyTask t2 = new MyTask("xi'an");
		new Thread(t1).start();
		new Thread(t2).start();
	}
}