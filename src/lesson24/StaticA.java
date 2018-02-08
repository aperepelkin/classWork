package lesson24;

public class StaticA {

	private int index = 0;

	static class StaticB {
		
		private String name;
		
		public StaticB(String name) {
			this.name = name;
		}
		
		public void inc() {
			System.out.println("Increment from " + name);
		}
	}
}
