package lesson17;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Work02 {

	public static void main(String[] args) {
		Person.howManyPersons();

		Person[] persons = new Person[20];
		for(int i = 0; i < 20; i++) {
			persons[i] = new Person();
		}
		
		persons = shuffle(persons);
		
		for(Person p : persons)
			p.sayMyNumber();
		
		Person.howManyPersons();
	}
	
	public static Person[] shuffle(Person[] persons) {
		List<Person> list = Arrays.asList(persons);
		Collections.shuffle(list);
		return list.toArray(new Person[20]);
	}
}
