package backtracking;

import java.util.Scanner;

public class nQueen {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the value of n : ");
		int n = sc.nextInt();

		int board[][] = new int[n][n];

		if (queenSolver(board, 0, n) == false) {
			System.out.println("Solution does not exists");
		}

		printQueen(board, n);

	}

	static boolean isSafe(int board[][], int row, int col, int n) {

		int i, j;

		// check left side row
		for (i = 0; i < col; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}

		// check upper diagonal on left side
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		// check lower diagonal on left side
		for (i = row, j = col; j >= 0 && i < n; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		return true;
	}

	static boolean queenSolver(int board[][], int col, int n) {

		// base case
		if (col >= n) {
			return true;
		}

		// i = row, col = 0
		for (int row = 0; row < n; row++) {
			if (isSafe(board, row, col, n)) {
				board[row][col] = 1; // queen place

				if (queenSolver(board, col + 1, n) == true) {
					return true; // recursion line
				}
				board[row][col] = 0; // backtracking
			}
		}
		return false;
	}

	static void printQueen(int board[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
