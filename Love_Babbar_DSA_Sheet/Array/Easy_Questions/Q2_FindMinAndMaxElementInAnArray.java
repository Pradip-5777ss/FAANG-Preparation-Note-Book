/**
 * Find minimum and maximum element in an array.
 * Given an array A of size N of integers. Your task is to find the minimum and maximum elements in the array.
 *  
 * Example 1:
 *  Input:
 *      N = 6
 *      A[] = {3, 2, 1, 56, 10000, 167}
 *  Output:
 *      min = 1, max =  10000
 *  
 * Example 2:
 *  Input:
 *      N = 5
 *      A[]  = {1, 345, 234, 21, 56789}
 *  Output:
 *      min = 1, max = 56789
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Easy_Questions;

import java.io.IOException;
import java.util.Scanner;

public class Q2_FindMinAndMaxElementInAnArray {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        // Method call to find the min and max of the array
        getMinMax(arr);
    }

    // Method to find the min and max of the array
    private static void getMinMax(int[] arr) {

        // Declare two variable and initialize by arr[0]
        int min = arr[0];
        int max = arr[0];

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            /**
             * If the ith element of the array is greater than the previous "max" value then
             * update "max"
             * 
             * If the ith element of the array is less than the previous "min" value then
             * update "min"
             */
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("The minimum of the array is : " + min);
        System.out.println("The maximum of the array is : " + max);
    }
}