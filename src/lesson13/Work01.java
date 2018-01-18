package lesson13;

import java.util.Arrays;
import java.util.Random;

public class Work01 {

	public static void main(String[] args) {
		int[] intArray = randomArray(10);
		
		printArray(intArray);
		
		Arrays.sort(intArray);

		printArray(intArray);
	}
	
	private static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
	}

	private static int[] randomArray(int n) {
		int[] array = new int[n];
		Random rnd = new Random();
		
		for(int i = 0; i < n; i++) {
			array[i] = rnd.nextInt(200);
		}
		return array;
	}
}
