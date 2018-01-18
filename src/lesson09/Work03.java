package lesson09;

import java.util.Scanner;

public class Work03 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = sc.nextInt();
		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			int[] row = matrix[i];
			for (int j = 0; j < n; j++)
				row[j] = (int) (Math.random() * 100);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(String.format("%3d", matrix[i][j]));
			System.out.println();
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				int tmp = matrix[i][j];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = tmp;
			}

		System.out.println();
		for (int[] row: matrix) {
			for (int item: row)
				System.out.print(String.format("%3d", row));
			System.out.println();
		}
	}
}
