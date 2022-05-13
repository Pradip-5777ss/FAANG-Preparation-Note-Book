/**
 * @author Pradip Sahoo
 * Created on 13/05/2022
 * -----------------------------
 * Search a 2D Matrix.
 * Write an efficient algorithm that searches for a value target in an m x n
 * integer matrix matrix. This matrix has the following properties:
 * => Integers in each row are sorted from left to right.
 * => The first integer of each row is greater than the last integer of the previous row.
 * 
 * Example 1:
 *  Input: matrix = [[1,3,5,7],
 *                   [10,11,16,20],
 *                   [23,30,34,60]]
 *         target = 3
 *  Output: true
 * 
 * Example 2:
 *  Input: matrix = [[1,3,5,7],
 *                   [10,11,16,20],
 *                   [23,30,34,60]]
 *         target = 13
 *  Output: false
 * 
 * Time Complexity : O(log(m*n))
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Matrix.Medium_Questions;

import java.util.Scanner;

public class Q3_SearchInMatrix {

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

        System.out.println("Enter the target : ");
        int target = sc.nextInt();

        sc.close();

        if (searchElement(matrix, target) == true) {
            System.out.println("Yes, Element is present in the matrix");
        } else {
            System.out.println("No, Element is not present in the matrix");
        }
    }

    /**
     * Method to find an element in matrix
     * 
     * @param matrix
     * @param target
     * @return
     */
    private static boolean searchElement(int[][] matrix, int target) {

        // If matrix is null, then return false
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // Find the total row present in a matrix
        int total_Row = matrix.length;

        // Find the total column present in a matrix
        int total_Column = matrix[0].length;

        /**
         * We use binary search for find the element, so we need start & end pointer
         */
        int start = 0;
        int end = (total_Row * total_Column) - 1;

        while (start <= end) {

            // Find mid
            int mid = start + (end - start) / 2;

            // Imaginary find row and column from the matrix
            int row = mid / total_Column;
            int col = mid % total_Column;

            // If the target matches then return true
            if (matrix[row][col] == target) {
                return true;
            }

            // If not match then update start and end pointer
            if (target < matrix[row][col]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}