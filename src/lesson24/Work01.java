package lesson24;

public class Work01 {
	public static void main(String[] args) {
		A a = new A();
		A.B var = a.new B("outer");
		A.B b1 = a.createB();
		
		var.inc();
		b1.inc();
		a.print();
		
		StaticA.StaticB sa = new StaticA.StaticB("outer static");
	}
}
