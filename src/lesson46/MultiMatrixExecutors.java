package lesson46;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiMatrixExecutors {
	
    public static int[][] multiply(int[][] a, int[][] b, int threadsCount) throws InterruptedException {

    	//определяем размеры результирующей матрицы
    	int m = a.length;
    	int q = b[0].length;
    	int[][] result = new int[m][q];
	    
	    ExecutorService pool = Executors.newFixedThreadPool(threadsCount);
	    for (int i = 0; i < m; i++) {
	    	int finalI = i;
	        pool.execute(() -> {
	            for (int col = 0; col < result[finalI].length; col++) {
	                int c = 0;
	                for (int j = 0; j < result[finalI].length; j++) {
	                    c += a[finalI][j] * b[j][col];
	                }
	                result[finalI][col] =  c;
	            }
	        }); 
	    }
	    pool.shutdown();
	    pool.awaitTermination(10, TimeUnit.MINUTES);
	    return result;
	}

	public static void main(String[] args) throws InterruptedException {
    int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    int[][] b = {{2, 1, 2, 1, 2, 1, 2}, {1, 2, 1, 2, 1, 2, 1}, {2, 1, 2, 1, 2, 1, 2}, {1, 2, 1, 2, 1, 2, 1}};
    int[][] c = multiply(a, b, 2);

    	for (int[] ints : c) {
    		for (int anInt : ints) {
    			System.out.print(anInt + " ");
    		}
    		System.out.println();
    	}
	}
}