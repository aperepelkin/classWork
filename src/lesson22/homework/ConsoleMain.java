package lesson22.homework;

import lesson20.Point;

public class ConsoleMain {

	public static void main(String[] args) {
		Painter painter = ConsoleMain::drawline;
		
		try {
			Square figure = new Square(new Point(0,0), new Point(6,7));
			figure.draw(painter);
		} catch (InvalidFigureException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	static void drawline(Point from, Point to) {
		
	}

}
