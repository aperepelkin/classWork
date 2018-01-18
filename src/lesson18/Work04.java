package lesson18;

public class Work04 {

	public static void main(String[] args) {
		printer(new Trang());
		printer(new Rect());
	}
	
	public static void printer(Shape s) {
		s.print();
	}
}
