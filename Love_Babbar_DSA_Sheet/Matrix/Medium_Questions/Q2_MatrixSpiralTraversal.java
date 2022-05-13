/**
 * @author Pradip Sahoo
 * Created on 13/05/2022
 * -------------------------------
 * Spirally traversing a matrix.
 * Given a matrix of size r*c. Traverse the matrix in spiral form.
 * Example 1:
 *  Input: r = 4, c = 4
 *         matrix[][] = {{1, 2, 3, 4},
 *                      {5, 6, 7, 8},
 *                      {9, 10, 11, 12},
 *                      {13, 14, 15,16}}
 *  Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 * 
 * Example 2:
 *  Input: r = 3, c = 4
 *         matrix[][] = {{1, 2, 3, 4},
 *                      {5, 6, 7, 8},
 *                      {9, 10, 11, 12}}
 *  Output: 1 2 3 4 8 12 11 10 9 5 6 7
 * 
 * Time Complexity : O(r*c)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Matrix.Medium_Questions;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2_MatrixSpiralTraversal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the row : ");
        int row = sc.nextInt();
        System.out.print("Enter the size of the column : ");
        int col = sc.nextInt();

        int matrix[][] = new int[row][col];

        System.out.println("Enter the elements of the matrix : ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        sc.close();
        ArrayList<Integer> result = spiralTraversal(matrix);

        System.out.print("output : ");
        for (Integer val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    private static ArrayList<Integer> spiralTraversal(int[][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;

        int columnBegin = 0;
        int columnEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {

            // Traverse right
            for (int i = columnBegin; i <= columnEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            // Traverse down
            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][columnEnd]);
            }
            columnEnd--;

            // Traverse left
            if (rowBegin <= rowEnd) {
                for (int i = columnEnd; i >= columnBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            // Traverse up
            if (columnBegin <= columnEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][columnBegin]);
                }
            }
            columnBegin++;
        }
        return res;
    }
}