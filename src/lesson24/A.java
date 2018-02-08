package lesson24;

public class A {
	
	private int index = 0;

	public class B {
		
		private String name;
		
		public B(String name) {
			this.name = name;
		}
		
		public void inc() {
			System.out.println("Increment from " + name);
			index++;
		}
	}
	
	public B createB() {
		return new B("inner");
	}
	
	public void print() {
		System.out.println(index);
	}
}
