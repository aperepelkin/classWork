package lesson46.homework;

import java.awt.FlowLayout;
import java.util.Deque;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Doctor implements Runnable {

	private int visitTimeout;
	private Deque<Patient> queue;
	private int duration;// время приема доктора
	private long startTime;
	private int count = 0;
	private int docCount = 0; // текущий номер доктора-потока

	public Doctor(Deque<Patient> queue, int visitTimeout) {
		this.visitTimeout = visitTimeout;
		this.queue = queue;
		docCount = Doctors.instance.addDoctor();
		duration = new Random().nextInt(2 * 60) * 100;
		System.err.println("Время работы доктора "+ docCount +" равно " + duration);
	}
	
	@Override
	public void run() {
	
		startTime = System.currentTimeMillis();
		
		while(opened()) {
			Patient patient = null;
			
			synchronized (queue) {
				try {
					queue.wait();// ждем, если нет пациентов
					patient = queue.poll(); // пациент есть, процесс продолжается с этого места
				} catch (InterruptedException e) {
					throw new RuntimeException(e); 
				}
			}
			if(patient == null) {
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
//								Thread.currentThread().getName(), patient.getNumber()));
				
				patient.setDocNumber(docCount);
				Thread.sleep(new Random().nextInt(100 * visitTimeout));
				
			} catch (InterruptedException e) {
				throw new RuntimeException(e); 
			}
		}

		//завершился процесс доктор
		System.err.println(
				String.format("Доктор %s принял %s пациентов за время %s",
						docCount, count, System.currentTimeMillis() - startTime));

		// поток закончился, уменьшаем кол-во активных докторов - потоков
		// если остался единственный доктор-поток, пациенты больше не добавляются в очередь
		Doctors.instance.removeDoctor();
	}
	boolean opened(){
		if(Doctors.instance.hasOneDoctor() && queue.isEmpty() == false)	
			return true;
		return (System.currentTimeMillis() - startTime < duration);
	}
}