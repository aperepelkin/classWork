package lesson32;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class HowManyWords {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		Map<String, Integer> line = new HashMap<>();
		// String[] words = sc.next().split(" ");
		System.out.println("Enter something");

		while (true) {
			String str = sc.next();
			if (str.equals("exit"))
				break;
			if (line.containsKey(str)) {
				line.put(str, line.get(str) + 1);
			} 
			else
				line.put(str, 1);
		}
		
		System.out.println(line);	
		
		Set<Entry<String, Integer>> set = line.entrySet();
		ArrayList<Entry<String, Integer>> al = new ArrayList<>(set);
		
		Comparator<Entry<String, Integer>> comp = new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {
				return arg1.getValue().compareTo(arg0.getValue());
			}
		};
		
		Collections.sort(al, comp);
		System.out.println(al);
	}
}