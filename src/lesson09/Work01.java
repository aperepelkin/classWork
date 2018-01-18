package lesson09;

import java.util.Scanner;

public class Work01 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter m: ");
		int m = sc.nextInt();
		System.out.print("Enter n: ");
		int n = sc.nextInt();
		int[][] matrix = new int[m][n];
		
		for(int i = 0; i < m; i++){
			int[] row = matrix[i];
			for(int j = 0; j < n; j++)
				row[j] = (int) (Math.random() * 100);
		}

		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++)
				System.out.print(String.format("%3d", matrix[i][j]));
			System.out.println();
		}
		
		int[] array = new int[m*n];
		for(int i = 0, k = 0; i < m; i++)
			for(int j = 0; j < n; j++, k++){
				array[k] = matrix[i][j];
			}
		
		System.out.println();
		for(int item: array)
			System.out.print(String.format(" %d", item));

		for(int i = 0, k = 0; i < n; i++)
			for(int j = 0; j < m; j++, k++){
				array[k] = matrix[j][i];
		}

		System.out.println();
		for(int item: array)
			System.out.print(String.format(" %d", item));
	}
}
