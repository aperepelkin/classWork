package lesson11;

import java.util.Scanner;

public class Work01 {
	
	public static void main(String[] args) {
		final String word = "cat";
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		int index = line.indexOf(word);
		int count = 0;
		
		while(index != -1){
			count++;
			index = line.indexOf(word, index + word.length());
		}
		
		System.out.println(count);
	}
}
