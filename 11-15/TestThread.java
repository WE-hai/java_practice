class MyThread extends Thread {
	private String cityName;
	MyThread(String cityName ) {
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

public class TestThread {

	public static void main(String[] args) {
		Thread t1 = new MyThread("xining");
		Thread t2 = new MyThread("xi'an");
		t1.start();
		t2.start();
	}

}