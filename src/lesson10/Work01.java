package lesson10;

import java.util.Arrays;

public class Work01 {

	public static void main(String[] args) {
		
		final int N = 12;
		int[] array = new int[N];

		int i = 0;
		int negativeCount = 0;
		int positiveCount = 0;
		while(i<N){
			int rnd = (int) (Math.random() * 21 - 10);
			if(rnd == 0)
				continue;
			
			if(rnd < 0)
				if(negativeCount < N/2) 
					negativeCount++;
				else
					continue;
			
			if(rnd > 0)
				if(positiveCount < N/2)
					positiveCount++;
				else
					continue;
			
			array[i] = rnd;
			i++;
		}
		
		System.out.println(Arrays.toString(array));
	}

}
