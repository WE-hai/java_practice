
class MineTask implements Runnable {
	int a;
	int n;
	MineTask(int a) {
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

public class Test2 {
	public static void main(String[] args) {
		MineTask t1 = new MineTask(1);
		new Thread(t1).start();
		new Thread(t1).start();
		new Thread(t1).start();
	}
}
