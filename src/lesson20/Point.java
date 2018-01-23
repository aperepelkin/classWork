package lesson20;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point){
			Point p2 = (Point) obj;
			return p2.x == x && p2.y == y;
		} else
			return false; 
	}

	@Override
	public String toString() {
		return "(x: " + x + ", y: " + y + ")";
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(x) + Integer.hashCode(y) + 10;
	}
}
