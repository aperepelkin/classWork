package lesson18;

public class Shape {
	
	String color;
	static String defaultColor;
	
	static {
		System.out.println("initialization");
		defaultColor = "yellow";
	}
	
	public Shape() {
		
	}
	
	public Shape(String color) {
		System.out.println("Create shape");
		init();
	}
	
	
	
	public void init() {
		// TODO very long computation
	}



	public void print() {
		System.out.println("I don't know who am i");
	}
}
