package lesson20;

import lesson20.shape.Shape;

public class Work01 {

	public static void main(String[] args) {
		Rect r = new Rect("yellow");
		Shape s = new Shape("red");
		Shape r2s = r;
		Rect s2r = (Rect) r2s;
		System.out.println("r is Rect " + (r instanceof Rect));
		System.out.println("r is Shape " + (r instanceof Shape));
		System.out.println("s is Rect " + (s instanceof Rect));
		System.out.println("s is Shape " + (s instanceof Shape));
	}

}
