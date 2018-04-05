package lesson42;

import java.util.ArrayList;
import java.util.List;

public class Work01 {
	
	private static Integer counter = 0;

	public static void main(String[] args) throws InterruptedException {
		final int N = 10000000;
		List<Integer> list = new ArrayList<>();
		Object[] monitors = {
				new Object(), 
				new Object(), 
				new Object(), 
				new Object()
				};
		
		List<Thread> threads = new ArrayList<>();
		long startTime = System.nanoTime();
		for(int i = 0; i < 4; i++) {
			final int fi = i;
			Thread thread = new Thread(() -> {
				for(int j = 0; j < N/4; j++)
					synchronized (monitors[fi]) {
						counter++;
					}
			});
			thread.start();
			threads.add(thread);
		}
//		for(int i = 0; i<N; i++)
//			list.add(i);
		for (Thread thread : threads) {
			thread.join();
		}
		
		System.out.println("Duration: " + (System.nanoTime() - startTime));
		System.out.println(counter);
		
		//4091344948
	}
	
	private synchronized static void increment() {
		counter++;
	}

}
