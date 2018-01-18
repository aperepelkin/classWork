package lesson12;

import java.util.Arrays;
import java.util.Random;

public class Work02Select {

	public static void main(String[] args) {
		final int N = 20;
		int[] array = new int[N];
		Random rnd = new Random();
		
		for(int i = 0; i < N; i++) {
			array[i] = rnd.nextInt(200);
		}
		
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

		System.out.println(Arrays.toString(array));
	}

}
