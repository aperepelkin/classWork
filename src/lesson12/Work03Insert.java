package lesson12;

import java.util.Arrays;
import java.util.Random;

public class Work03Insert {

	public static void main(String[] args) {
		final int N = 20;
		int[] array = randomArray(20);
		
		System.out.println(Arrays.toString(array));

		for(int j = 1; j < N; j++) { // начинаем с 1 так как считаем что элемент 0 входит в отсортированную часть массива 
		    int key = array[j]; // берем следующий элемент массива
		    int i = j - 1; // конечный индекс отсортированной части массива 
		    while (i >= 0 && array[i] > key){ // проверяем что элемент больше чем тот который мы распределяем
		        array[i + 1] = array[i]; // если это так, то перемещаем этот элемент на 1 позицию дальше 
		        i = i - 1; // сдвигаем наш курсор на 1 к началу отсортированного массива
		    }
		    array[i+1] = key;  // вставляем элемент в найденую позицию
		}
				
		System.out.println(Arrays.toString(array));

		array = randomArray(20);
		System.out.println(Arrays.toString(array));
		
		for(int i = 0; i < N; i++) {
			int min = array[i];
			int index = i;
			for(int j = i; j < N; j++) {
				if(array[j] < min){
					min = array[j];
					index = j;
				}
			}
			if(i != index) {
				int tmp = array[i];
				array[i] = array[index];
				array[index] = tmp;
			}
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
