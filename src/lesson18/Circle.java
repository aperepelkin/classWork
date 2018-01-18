package lesson18;

public class Circle {
	
	private int radius;
	private double squire;
	
	public Circle(int radius) {
		this.radius = radius;
		squire = 2 * radius * Math.PI;
	}
	
	public boolean isEquals(Circle other) {
		return radius == other.radius;
	}

}
