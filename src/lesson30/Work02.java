package lesson30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Work02 {
	
	static class PersonComparator implements Comparator<Person> {
		@Override
		public int compare(Person o1, Person o2) {
			return o2.name.compareTo(o1.name);
		}
	}

	public static void main(String[] args) {
		
		Set<Person> set = new TreeSet<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o2.name.compareTo(o1.name);
			}
		});
		set.add(new Person("n3"));
		set.add(new Person("n3"));
		set.add(new Person("n1"));
		set.add(new Person("n2"));
		set.add(new Person("n2"));
		
		System.out.println(set.size());
		System.out.println(set);
	}

}
