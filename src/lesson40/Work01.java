package lesson40;

import java.io.IOException;

class MyThread extends Thread {
	
	public int counter = 100;
	private boolean exit = false;

	@Override
	public void run() {
		while(counter > 0 && !exit) {
			try {
				System.out.println(counter--);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Boom! Thread terminated");
	}
	
	public void stopIt() {
		exit = true;
	}
}

public class Work01 {

	public static void main(String[] args) 
			throws InterruptedException, IOException {
		
		MyThread thread1 = new MyThread();
		thread1.start();
		
		Thread.sleep(500);
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("do something and exit");
			}
		});
		
		while(true) {
			System.out.println("Reset counter! Quick, press enter");
			System.in.read();
			thread1.counter = 100;
			thread2.();
		}
	}
}
