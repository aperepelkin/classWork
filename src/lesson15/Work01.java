package lesson15;

import java.util.Arrays;
import java.util.Scanner;

import utils.Utils;

public class Work01 {

	public static void main(String[] args) {
		final int BOUND = 10000000;
		Scanner sc = new Scanner(System.in);
		System.out.println("Размерность массива");
		int n = sc.nextInt();
		System.out.println("Число");
		int num = sc.nextInt();
		int[] array = Utils.randomArray(n, BOUND);

		Arrays.sort(array);

		long current = System.currentTimeMillis();
		for(int i = 0; i<100; i++)
			contains(array, 0, n, num);
		System.out.println((System.currentTimeMillis() - current) + " ms");

		array = Utils.randomArray(n, BOUND);
		current = System.currentTimeMillis();
		for(int i = 0; i<100; i++)
			contains(array, num);
		System.out.println((System.currentTimeMillis() - current) + " ms");
	}

	private static boolean contains(int[] array, int lower, int upper, int num) {
		if(lower>=upper)
			return false;
		int middle = lower + (upper - lower) / 2;
		if(array[middle] == num)
			return true;
		if(array[middle] > num)
			return contains(array, lower, middle - 1, num);
		else
			return contains(array, middle + 1, upper, num);
	}
	
	private static boolean contains(int[] array, int num) {
		for(int item : array)
			if(item == num)
				return true;
		return false;
	}
}
