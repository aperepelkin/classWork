package lesson43.homework;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Thread> doctors = new ArrayList<>();
		Deque<Patient> queue = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			Thread doctor = new Thread(new Doctor(queue, n+1, i+1));
			doctors.add(doctor);
			doctor.start();
		}
		
		int number = 0;
		while(doctors.stream().anyMatch(thread -> thread.isAlive())) {
			synchronized (queue) {
				queue.push(new Patient(++number));
				queue.notifyAll();
			}
			Thread.sleep(50);
		}
		System.out.println("Пациентов " + number);
		System.out.println("Все пациенты приняты " + queue.isEmpty());
	}
}
