package lesson45;

public class Deadlock {

	public static void main(String[] args) throws InterruptedException {
		
		Account account1 = new Account(1000);
		Account account2 = new Account(1000);
		
		Thread t1 = new Thread(() -> {
			for(int i = 0; i < 100000; i++) {
				Account.transfer(account1, account2, 1, "thread1");
			}
		});
		Thread t2 = new Thread(() -> {
			for(int i = 0; i < 100000; i++) {
				Account.transfer(account2, account1, 1, "thread2");
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println(account1.balance);
		System.out.println(account2.balance);
	}

}
