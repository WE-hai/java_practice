
class MineThread extends Thread {
	int a;
	int n;
	MineThread(int a) {
		this.a = a;
		
	}
	public void run() {
		n = (int)(Math.random()*6000);
		try {
			Thread.sleep(n);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+": "+a+" "+n);
	}
}
public class Test {

	public static void main(String[] args) {
		Thread t1 = new MineThread(1);
		Thread t2 = new MineThread(1);
		Thread t3 = new MineThread(1);
		t1.start();
		t2.start();
		t3.start();
	}

}
