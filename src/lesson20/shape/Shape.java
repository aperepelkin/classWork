package lesson20.shape;

public class Shape {

	protected String color;
	
	public Shape(String color) {
		this.color = color;
	}
	
	public void fill() {
		System.out.println("Fill shape with color " + color);
	}
}
