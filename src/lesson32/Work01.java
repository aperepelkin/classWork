package lesson32;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Work01 {

	public static void main(String[] args) {
		Map<String, Integer> numbers = new HashMap<>();
		
		numbers.put("One", 1);
		numbers.put("Two", 2);
		numbers.put("Three", 3);
		numbers.put("Один", 1);
		numbers.put("Два", 2);
		numbers.put("Три", 3);
		
		System.out.println("Size: " + numbers.size());
		
		System.out.println("Keys: " + numbers.keySet());
		System.out.println("Values: " + numbers.values());
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(numbers.entrySet());
		
		while(true) {
			String w = sc.nextLine();
			if(numbers.containsKey(w))
				System.out.println("maps to " + numbers.get(w));
			else
				System.err.println("maps to nothing");
		}
	}

}
