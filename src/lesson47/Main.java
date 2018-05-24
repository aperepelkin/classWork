package lesson47;

public class Main {
	
	static class Person {
		
	}
	
	static class PersonAdapter implements Comparable<PersonAdapter> {
		
		private Person adaptee;

		public PersonAdapter(Person adaptee) {
			this.adaptee = adaptee;
		}

		@Override
		public int compareTo(PersonAdapter o) {
			return adaptee.equals(o.adaptee) ? 0 : 1;
		}
		
	}

	public static void main(String[] args) {

		
		Person p1 = new Person();
		Person p2 = new Person();
		
		compare(new PersonAdapter(p1), new PersonAdapter(p2));
	}
	
	public static boolean compare(Comparable c1, Comparable c2) {
		return c1.compareTo(c2) == 0;
	}
}
