package lesson18;

public class Rect extends Shape {
	
	public Rect() {
		super("red");
		System.out.println("Create Rect");
	}
	
	public void print() {
		System.out.println("Rect");
		super.print();
	}
}
