package lesson18;

public class Person {
	
	private static int counter = 0;
	private int number;
	private String name;
	
	public Person(String name) {
		System.out.println("I am number " + ++counter);
		number = counter;
		this.name = name;
	}
	
	public void sayInfo() {
		System.out.println("My number is " + number + " and I am " + name);
	}
	
	public static void howManyPersons() {
		System.out.println("Count " + counter);
	}
}
