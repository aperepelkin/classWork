package lesson19;

import utils.Utils;

public class Work01 {

	public static void main(String[] args) {
		int[] array = Utils.randomArray(10);
		DefaultArray array1 = new DefaultArray(array);
		// случайный массив
		array1.print(); 
		// совпадает со строчкой выше
		System.out.println(array1.array); 
		// совпадает со строчкой выше
		System.out.println(array); 

		DefaultArray array2 = new DefaultArray();
		array2.print(); // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
		System.out.println(array2.array); // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
	}
}
