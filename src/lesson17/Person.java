package lesson17;

public class Person {
	
	private static int counter = 0;
	private int number;
	
	public Person() {
		System.out.println("I am number " + ++counter);
		number = counter;
	}
	
	public void sayMyNumber() {
		System.out.println("My number is " + number);
	}
	
	public static void howManyPersons() {
		System.out.println("Count " + counter);
	}
}
