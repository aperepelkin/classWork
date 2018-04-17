package lesson45;

import java.util.Random;

public class Account {

	volatile double balance = 0;
	int number = new Random().nextInt(1000);
	
	Account(double amount) {
		balance = amount;
	}
	
	void withdraw(double amount) {
		balance -= amount;
	}
	
	void deposit(double amount) {
		balance += amount;
	}
	
	static void transfer(Account from, Account to, double amount, String threadName) {
		Account a1 = from;//from.number > to.number ? from : to;
		Account a2 = to; //from.number < to.number ? from : to;
		System.out.println(threadName + ": from " + from.number + " to " + to.number );
		synchronized (a1) {
			System.out.println("Blocked by " + threadName + " " + a1.number);
			synchronized (a2) {
				System.out.println("Blocked " + threadName + " " + a2.number);
				from.withdraw(amount);
				to.deposit(amount);
			}
		}
	}
}
