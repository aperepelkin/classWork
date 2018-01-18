package lesson15;

import java.util.Arrays;
import java.util.Scanner;

public class Work02 {

	public static void main(String[] args) {
		char[] uppers = new char['Z' - 'A' + 1];
		for (char c = 'A', i = 0; c <= 'Z'; c++, i++)
			uppers[i] = c;

		System.out.println(Arrays.toString(uppers));
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		String result = "";
		int lastFind = 0;
		for (int i = 0; i < str.length(); i++) {
			int index = Arrays.binarySearch(uppers, str.charAt(i));
			boolean find = index < uppers.length && index >= 0;
			if (find) {
				if (lastFind != i) {
					result += str.substring(lastFind, i);
					result += "_";
				}
				result += str.substring(i, i + 1).toLowerCase();
				lastFind = i + 1;
			}
		}
		result += str.substring(lastFind);
		result += "|";

		String[] parts = str.split("[A-ZÀ-ß¨]");
		int index = 0;
		for (String part : parts) {
			result += part;
			int next = index + part.length();
			if (next < str.length()) {
				if(next != 0)
					result += "_";
				result += str.substring(next, next + 1).toLowerCase();
			}
			index = next + 1;
		}

		System.out.println(result);
	}
}
