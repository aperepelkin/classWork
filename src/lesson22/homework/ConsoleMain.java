package lesson22.homework;

import lesson20.Point;

public class ConsoleMain {

	public static void main(String[] args) {
		Painter painter = ConsoleMain::drawline;
		
		Square figure = new Square(new Point(0,0), 6);
		figure.draw(painter);
	}
	
	static void drawline(Point from, Point to) {
		
	}

}
