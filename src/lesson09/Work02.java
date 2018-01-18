package lesson09;

import java.util.Scanner;

public class Work02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter m: ");
		int m = sc.nextInt();
		System.out.print("Enter n: ");
		int n = sc.nextInt();
		int[][] matrix = new int[m][n];

		for (int i = 0; i < m; i++) {
			int[] row = matrix[i];
			for (int j = 0; j < n; j++)
				row[j] = (int) (Math.random() * 100);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(String.format("%3d", matrix[i][j]));
			System.out.println();
		}

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n - 1; j+=2) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][j + 1];
				matrix[i][j + 1] = tmp;
			}

		System.out.println();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(String.format("%3d", matrix[i][j]));
			System.out.println();
		}
	}

}
