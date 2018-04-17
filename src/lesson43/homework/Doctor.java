package lesson43.homework;

import java.util.Deque;
import java.util.Random;

public class Doctor extends Thread {
	
	private int number; 
	private int visitTimeout;
	private Deque<Patient> queue;
	private int duration;
	private int count = 0;
	private long startTime;
	
	private static long counter;
	
	public Doctor(Deque<Patient> queue, int visitTimeout, int number) {
		this.visitTimeout = visitTimeout;
		this.queue = queue;
		this.number = number;
//		duration = (int) ((new Random().nextGaussian() + 2) * 2 * 60 * 1000);
		duration = new Random().nextInt(2 * 60) * 1000;
		System.err.println("Время работы " + duration);
	}

	@Override
	public void run() {
		startTime = System.currentTimeMillis();
		while(opened()) {
			Patient patient = null;
			synchronized (queue) {
				try {
					queue.wait();
					patient = queue.poll();
				} catch (InterruptedException e) {
					throw new RuntimeException(e); 
				}
			}
			if(patient == null) {
//				System.out.println("Queue is empty " + number);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					throw new RuntimeException(e); 
				}
				continue;
			}
			try {
				count++;
//				System.out.println(
//						String.format("Доктор %s принял пациента %s",
//								number, patient.getNumber()));
				Thread.sleep(new Random().nextInt(100 * visitTimeout));
//				System.out.println(
//						String.format("Доктор %s окончил прием пациента %s",
//								number, patient.getNumber()));
			} catch (InterruptedException e) {
				throw new RuntimeException(e); 
			}
		}
		System.err.println(
				String.format("Доктор %s принял %s пациентов",
						number, count));
	}
	
	public synchronized boolean opened() {
		return this.isAlive() && System.currentTimeMillis() - startTime < duration;
	}
}
