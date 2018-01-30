package lesson22.homework;

import lesson20.Point;

public class TextPainter implements Painter {

	@Override
	public void drawline(Point from, Point to) {
		System.out.println("Draw line from " + from + " to " + to);
	}
}
