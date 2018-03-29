package lesson40;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Finder {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Путь к файлу");
		String fileName = sc.nextLine();
		System.out.println("Слово");
		String word = sc.nextLine();
		
		FileInputStream fin = new FileInputStream(fileName);
		LineNumberReader reader = new LineNumberReader(
				new InputStreamReader(fin));
		
		String line = null;
		Map<Integer, List<Integer>> enters = new HashMap<>();
		while((line = reader.readLine()) != null) {
			int number = reader.getLineNumber();
			List<Integer> finds = find(line, word);
			if(finds.size() != 0)
				enters.put(number, finds);
		}
		
	}
	
	private static List<Integer> find(String line, String word) {
		List<Integer> positions = new ArrayList<>();
		String[] words = line.split(" ");
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(word))
				positions.add(i);
		}
		return positions;
	}
}
