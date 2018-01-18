package utils;

import java.util.Random;

public class Utils {
	
	public static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println();
	}

	public static int[] randomArray(int n) {
		return randomArray(n, 200);
	}

	public static int[] randomArray(int n, int upperBound) {
		int[] array = new int[n];
		Random rnd = new Random();
		
		for(int i = 0; i < n; i++) {
			array[i] = rnd.nextInt(upperBound);
		}
		return array;
	}
}
