package lesson20;

public class Work03 {

	public static void main(String[] args) {
		Point p1 = new Point(2,4);
		Point p2 = new Point(2,4);
		System.out.println("p1 == p2 " 
		+ (p1 == p2));
		System.out.println("p1 equals p2 " 
		+ p1.equals(p2));
		System.out.println(p1);
		System.out.println(p1.hashCode());
		System.out.println(p1.getClass().getName());
	}

}
