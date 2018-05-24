package lesson47;

import java.util.ArrayList;
import java.util.List;

public class RepositorySingleton {

	private static RepositorySingleton instance;
	
	private List<Person> persons = new ArrayList<>();
	
	private RepositorySingleton() {
		
	}
	
	public static RepositorySingleton getInstance() {
		if(instance == null)
			instance = new RepositorySingleton();
		return instance;
	}
	
	public void addPerson(Person p) {
		persons.add(p);
	}
	
	public List<Person> getPersons() {
		return persons;
	}
}
