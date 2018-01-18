package lesson16;

public class Work01 {

	public static void main(String[] args) {
		Glass g1 = new Glass();
		Glass g2 = new Glass();
		
		g1.fill(10);
		g2.fill(20);
		
		g2.reduce(3);

		g1.fill(5);
		
		defaultFill(g1);
		defaultFill(g2);
		
		g1.transferTo(g2);
		g2.transferTo(g2);
		
		System.out.println("Glass1: " + g1.level());
		System.out.println("Glass2: " + g2.level());
	}
	
	public static void defaultFill(Glass g) {
		g.fill(1);
	}
}
