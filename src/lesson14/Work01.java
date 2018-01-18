package lesson14;

import java.util.Arrays;
import java.util.Scanner;

import utils.Utils;

public class Work01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Введите число элементов массива");
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(n);
		System.out.println(m);
		System.out.println(sc.nextLine());
		int[] array = Utils.randomArray(n);
		
		System.out.println("Введите слова");
		String[] strings = sc.nextLine().split(" ");
		
		System.out.println("Массив:");
		Utils.printArray(array);
		System.out.println("Максимальный элемент: " + max(array));
		
		System.out.printf("Самое длинное слово: %s\n", max(strings));

		int length = max(strings, 10) + 1;
		String template = "%"+ length + "s";
		
		for(int i = 0; i < strings.length; i++) {
			System.out.printf(template, strings[i]);
			if(i % 2 == 1)
				System.out.println();
		}
	}
	
	private static int max(int... array) {
		int max = array[0];
		for(int item: array)
			if(max < item)
				max = item;
		return max;
	}
	
	private static String max(String... array) {
		String max = array[0];
		for(String item: array)
			if(max.length() < item.length())
				max = item;
		return max;
	}

	private static int max(String[] array, int minMax) {
		return max(max(array).length(), 10);
	}

}
