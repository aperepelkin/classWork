package lesson38;

class A {
	public A() {
		System.out.println("A");
	}
}

class B {
	public B() {
		System.out.println("B");
	}
}

class C {
	public static A a = new A();	
}

public class Work01 {
	
	private static C c = new C();
	private B b = new B();
	
	static {
		new B();
	}
	
	{
//		new A();
	}
	
	Work01() {
		System.out.println("Test");
	}

	public static void main(String[] args) {
		System.out.println("Main");
		new Work01();
		new C();
	}
}
