package lesson43;

public class MultiMatrixThreds extends Thread {
	
	private int startRow, endRow;
    private int[][] a, b, result;
    private int n;

    public MultiMatrixThreds(
    		int[][] a, 
    		int[][] b, 
    		int[][] result, 
    		int startRow, 
    		int endRow) {
        this.a = a;
        this.b = b;
        this.result = result;
        this.startRow = startRow;
        this.endRow = endRow;
        this.n = b.length;
    }

    @Override
    public void run() {
        System.out.println("Read string from " + startRow + " to " + endRow + " including");
        for (int row = startRow; row <= endRow ; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = calcSingleValue(row, col);
            }
        }
    }
    // перемножение
    private int calcSingleValue(int row, int col) {
        int c = 0;
        for (int i = 0; i < n; i++) {
            c += a[row][i] * b[i][col];
        }
        return c;
    }

    public static int[][] multiply(int[][] a, int[][] b, int threadsCount) {

    	//определяем размеры результирующей матрицы
    	int m = a.length;
    	int q = b[0].length;
    	int[][] result = new int[m][q];
    	//если количество потоков больше чем количество строк - уменьшим кол-во потоков
	    if (threadsCount > m)
	        threadsCount = m;
	    //посчитаем сколько строк результирующей матрицы будет считать каждый поток
	    int count = m / threadsCount;
	    int additional = m % threadsCount; //если не делиться на threadsCount, то добавим к первому потоку
	    //создаем и запускаем потоки
	    Thread[] threads = new Thread[threadsCount];
	    int start = 0;
	    for (int i = 0; i < threadsCount; i++) {
	        int cnt = ((i == 0) ? count + additional : count);
	        threads[i] = new MultiMatrixThreds(a, b, result, start, start + cnt - 1);
	        start += cnt;
	        threads[i].start();
	    }
	    //ждем завершения
	    try {
	        for (Thread thread : threads) {
	            thread.join();
	        }
	    } catch (InterruptedException e) {
	        System.out.println("Interrupted");
	    }
	    return result;
	}

	public static void main(String[] args) {
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