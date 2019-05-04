package cpm.app.test;

public class RunTest implements Runnable {

	static MyPing ping=new MyPing();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1=new Thread(new RunTest());
		t1.start();
		Thread t2=new Thread(new RunTest());
		t2.start();
		int str = 10;
		str += 20;
		System.out.println("s "+str);
		
	}  

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ping.call(Thread.currentThread().getId());
	}

}
