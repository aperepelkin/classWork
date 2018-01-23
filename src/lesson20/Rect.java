package lesson20;

import lesson20.shape.Shape;

public class Rect extends Shape {

	public Rect(String color) {
		super(color);
	}

	@Override
	public void fill() {
		System.out.println("Fill rect with color " + color);
	}
}
