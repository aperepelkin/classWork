package lesson46.homework;

import java.util.concurrent.atomic.AtomicInteger;

public class Doctors {
	
	public static final Doctors instance = new Doctors();
	
	AtomicInteger counter = new AtomicInteger();

	private Doctors() {
		
	}	
	
	public Integer addDoctor() {
		return counter.incrementAndGet();
	}
	
	public Integer removeDoctor() {
		return counter.decrementAndGet();
	}
	
	public boolean hasOneDoctor() {
		return counter.get() == 1;
	}
	
//	public Doctors getInstance() {
//		if(instance == null)
//			synchronized (counter) {
//				if(instance == null)
//					instance = new Doctors();
//			}
//		return instance;
//	}
}
