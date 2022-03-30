/**
 * @author Pradip Sahoo
 * Created on 30/03/2022
 * ----------------------------------
 * Cyclically rotate an array by one
 * Given an array, rotate the array by one position in clock-wise direction.
 * 
 * Example 1:
 *  Input:  N = 5
 *          A[] = {1, 2, 3, 4, 5}
 *  Output: 5 1 2 3 4
 *  
 * Example 2:
 *  Input:  N = 8
 *          A[] = {9, 8, 7, 6, 4, 2, 1, 3}
 *  Output: 3 9 8 7 6 4 2 1
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Easy_Questions;

import java.util.Scanner;

public class Q6_CyclicallyRotateArrayByOne {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        int res[] = rotateCyclically(arr);
        System.out.print("After rotation the array is : ");
        printResult(res);
    }

    // Method to cyclically rotate the array by one
    private static int[] rotateCyclically(int[] arr) {

        // Store the last element of the array
        int last_elem = arr[arr.length - 1];

        /**
         * Traverse the array from end & right shift the elements [store the arr[i-1]
         * element in the position of arr[i]].
         */
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        // Initialize the last element of the array at the position of arr[0].
        arr[0] = last_elem;

        // Return the array
        return arr;
    }

    // Method to print the result
    private static void printResult(int[] res) {
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}