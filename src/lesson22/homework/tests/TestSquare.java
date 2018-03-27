package lesson22.homework.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import lesson20.Point;
import lesson22.homework.InvalidFigureException;
import lesson22.homework.Painter;
import lesson22.homework.Square;

public class TestSquare {
	
	@Test
	public void createSquareByPointAndLength() {
		Square square = new Square(new Point(3, 3), 6);
		assertEquals(new Point(3, 3), square.getBottomLeft());
		assertEquals(new Point(9, 3), square.getBottomRight());
		assertEquals(new Point(3, 9), square.getTopLeft());
		assertEquals(new Point(9, 9), square.getTopRigth());
	}
	
	@Test(expected = InvalidFigureException.class)
	public void invalidPointForCreateSquare() 
			throws InvalidFigureException {
		new Square(new Point(3, 3), new Point(6, 23));
	}
	
	@Test
	public void draw() throws InvalidFigureException {
		List<Point> points = new ArrayList<>();
		List<Point> expected = new ArrayList<>();
		
		expected.add(new Point(3, 3));
		expected.add(new Point(3, 9));
		expected.add(new Point(3, 9));
		expected.add(new Point(9, 9));
		expected.add(new Point(9, 9));
		expected.add(new Point(9, 3));
		expected.add(new Point(9, 3));
		expected.add(new Point(3, 3));

		Painter mockPainter = new Painter() {

			@Override
			public void drawline(Point from, Point to) {
				points.add(from);
				points.add(to);
			}
		};
		
		Square square = new Square(new Point(3, 3), new Point(9, 9));
		square.draw(mockPainter);
		
		assertArrayEquals(expected.toArray(), points.toArray());
	}
}
