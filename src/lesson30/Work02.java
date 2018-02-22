package lesson30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Work02 {

	public static void main(String[] args) {

		Set<Person> set = new TreeSet<>();
		set.add(new Person("n3"));
		set.add(new Person("n3"));
		set.add(new Person("n1"));
		set.add(new Person("n2"));
		set.add(new Person("n2"));
		
		System.out.println(set.size());
		System.out.println(set);
	}

}
