package lesson19;

import java.util.Arrays;

import utils.Utils;

/*
if you see something unreadable, switch encoding to UTF-8
DefaultArray - класс для хранения массива. Если при создании объекта массив не задан - то используется массив по умолчанию 0, 1, 2, ...
*/
public class Work01 {

	public static void main(String[] args) {
		// Создаем массив случайных чисел
		int[] array = Utils.randomArray(10);
		// Выводится то что создано
		System.out.println(Arrays.toString(array)); 
		//Создаем класс который будет содержать наш вышесозданый массив
		DefaultArray array1 = new DefaultArray(array);
		// Вывод массива со случайными числами
		// Совпадает с выводом выше
		array1.print(); 
		// Проверяем что в поле класса правильный массив
		// Совпадает с выводом выше
		System.out.println(Arrays.toString(array1.array)); 

		DefaultArray array2 = new DefaultArray();
		// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
		array2.print();
		// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
		System.out.println(Arrays.toString(array2.array)); 
		// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
		System.out.println(Arrays.toString(array2.defaultArray)); 
		// Проверяем что массив содержащийся в первом экземпляре не испортился
		// Совпадает с первым выводом
		array1.print(); 
	}
}
