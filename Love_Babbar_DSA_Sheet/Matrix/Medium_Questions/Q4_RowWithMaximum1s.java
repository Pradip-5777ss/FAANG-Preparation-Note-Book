/**
 * @author Pradip Sahoo
 * Created on 18/07/2022
 * --------------------------
 * Row with max 1s
 * Given a boolean 2D array of n x m dimensions where each row is sorted. Find
 * the 0-based index of the first row that has the maximum number of 1's.
 * 
 * Example 1:
 *  Input : N = 4 , M = 4
 *          Arr[][] = {{0, 1, 1, 1},
 *                    {0, 0, 1, 1},
 *                    {1, 1, 1, 1},
 *                    {0, 0, 0, 0}}
 *  Output : 2
 *  Explanation: Row 2 contains 4 1's (0-based indexing).
 * 
 * Example 2:
 *  Input : N = 2, M = 2
 *          Arr[][] = {{0, 0}, 
 *                    {1, 1}}
 *  Output: 1
 *  Explanation: Row 1 contains 2 1's (0-based indexing).
 * 
 * Time Complexity : O(n+m)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Matrix.Medium_Questions;

import java.util.Scanner;

public class Q4_RowWithMaximum1s {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the row : ");
        int row = sc.nextInt();
        System.out.print("Enter the size of the column : ");
        int col = sc.nextInt();

        int matrix[][] = new int[row][col];

        System.out.println("Enter the elements of the matrix : ");
        for (int i = 0; i < row; i++) {
            System.out.println("Enter the elements for row : " + i);
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        sc.close();

        int res = rowWithMax1s(matrix, row, col);

        System.out.println("Output : " + res);
    }

    /**
     * Method to find the row with maximum number of 1's.
     * 
     * @param matrix
     * @param row
     * @param col
     * @return the row with maximum no of 1's
     */
    private static int rowWithMax1s(int[][] matrix, int row, int col) {

        // Declare variable
        int i = 0, j = col - 1, ans = -1;

        /**
         * Starting from top right corner and "go left if encounter 1" and "go down if
         * encounter 0"
         */
        while (i < row && j >= 0) {
            if (matrix[i][j] == 1) {
                ans = i;
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }
}