package lesson22.homework.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import lesson20.Point;
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
}
