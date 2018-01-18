package lesson18;

import java.util.Scanner;

public class Work01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¬ведите длину очереди");
		int n = sc.nextInt();
		sc.nextLine();
		Person[] queue = new Person[n];
		int current = 0;
		while(true) {
			System.out.println("¬ведите им€ или exit дл€ выхода");
			String name = sc.nextLine();
			if(name.equals("exit"))
				break;
			queue[current++] = new Person(name);
			if(current >= n)
				current = 0;
		}
		for(Person person : queue)
			person.sayInfo();
	}
}
