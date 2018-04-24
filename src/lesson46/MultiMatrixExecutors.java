package lesson46;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MultiMatrixExecutors {
	
    public static Integer[][] multiply(int[][] a, int[][] b, int threadsCount) throws InterruptedException, ExecutionException {

    	//определяем размеры результирующей матрицы
    	int m = a.length;
    	int q = b[0].length;
    	Integer[][] result = new Integer[m][q];
	    
	    ExecutorService pool = Executors.newFixedThreadPool(threadsCount);
	    List<Future<Integer[]>> futures = new ArrayList<>();
	    for (int row = 0; row < m; row++) {
	    	final int finalRow = row;
	        Future<Integer[]> f = pool.submit(() -> {
	        	Integer[] resultRow = new Integer[q];
	            for (int col = 0; col < q; col++) {
	                int c = 0;
	                for (int j = 0; j < a[finalRow].length; j++) {
	                    c += a[finalRow][j] * b[j][col];
	                }
	                resultRow[col] =  c;
	            }
	            return resultRow;
	        }); 
	        futures.add(f);
	    }
	    for(int i = 0; i < futures.size(); i++) {
	    	result[i] = futures.get(i).get();
	    }
	    pool.shutdown();
	    return result;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
    int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    int[][] b = {{2, 1, 2, 1, 2, 1, 2}, {1, 2, 1, 2, 1, 2, 1}, {2, 1, 2, 1, 2, 1, 2}, {1, 2, 1, 2, 1, 2, 1}};
    Integer[][] c = multiply(a, b, 2);

    	for (Integer[] ints : c) {
    		for (int anInt : ints) {
    			System.out.print(anInt + " ");
    		}
    		System.out.println();
    	}
	}
}