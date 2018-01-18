package lesson12;

import java.util.Arrays;
import java.util.Random;

public class Work01BBSort {

	public static void main(String[] args) {
		final int N = 20;
		int[] array = new int[N];
		Random rnd = new Random();
		
		for(int i = 0; i < N; i++) {
			array[i] = rnd.nextInt(200);
		}
		
		System.out.println(Arrays.toString(array));
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - i - 1; j++) {
				if(array[j] > array[j+1]) {
					int tmp = array[j+1];
					array[j+1] = array[j];
					array[j] = tmp;
				}
			}
		}

		System.out.println(Arrays.toString(array));
	}

}
