package lesson42;

import java.util.Scanner;

public class Work02 {
	
	static class Subscriber implements Runnable {

		String message = null;
		
		@Override
		public void run() {
			try {
				while(true) {
					synchronized (this) {
						if(message == null) {
							System.out.println("Waiting...");
							this.wait();
							System.out.println("Complete waiting");
						}
						System.out.println("I have a message! " + message);
						message = null;
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public synchronized void publish(String message) {
			this.message = message;
			System.out.println("Notify about message");
			this.notify();
			System.out.println("Leave method");
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Subscriber subscriber = new Subscriber();
		new Thread(subscriber).start();
		while(true) {
			String message = sc.nextLine();
			subscriber.publish(message);
		}
	}
}
