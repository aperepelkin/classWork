package lesson46.homework;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;


public class App {

	public static int NDoctors; 
	public static void main(String[] args) throws InterruptedException {
		
		System.out.print("Введите кол-во докторов: ");
		Scanner sc = new Scanner(System.in);
		NDoctors = sc.nextInt();
		List<Thread> doctors = new ArrayList<>();
		Deque<Patient> queue = new ConcurrentLinkedDeque<>();
		
		
		for(int i = 0; i < NDoctors; i++) {
			Doctor doc = new Doctor(queue, NDoctors+1);
			Integer val = i+1;
			Thread doctor = new Thread(doc,val.toString() );
			doctors.add(doctor);
			doctor.start();
		}
		int number = 0;
		while(doctors.stream().anyMatch(thread -> thread.isAlive())) {
		synchronized (queue) 
			{
				if(!Doctors.instance.hasOneDoctor())			// если можно добавлять пациетов в очередь 
					queue.push(new Patient(++number));
								  
				queue.notifyAll(); //переключиться на обработку очереди пациетов					
			}
			Thread.sleep(50);
		}
		System.out.println("Всего поступило пациентов: " + number);
		System.out.println(queue.isEmpty()? "Все пациенты приняты.":"Кол-во непринятых пациентов: "+ queue.size());
	}
}