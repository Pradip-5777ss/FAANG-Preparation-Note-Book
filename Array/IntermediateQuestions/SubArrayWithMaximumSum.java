/**
 * Kadane's Algorithm.
 * Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
 * 
 * Example :
 * Input : 
 *      N = 5
 *      arr[] = {1,2,3,-2,5}
 * Output : 9
 */
package Array.IntermediateQuestions;

import java.util.Scanner;

public class SubArrayWithMaximumSum {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        int arr[] = new int[size];

        // Ask user to enter the array elements
        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        // Method call to find the maximum sum of a subarray and print the result
        System.out.println("The maximum sum is : " + subarrayMaxSum(arr));
    }

    // Method to find the maximum sum of a subarray
    private static int subarrayMaxSum(int[] arr) {

        // Declare two variables and both are initialize at 0th index of the array.
        int max = arr[0];
        int res = arr[0];

        // Run a loop from 1 to the rest of the array
        for (int i = 1; i < arr.length; i++) {

            // find the maximum
            max = Math.max(arr[i], arr[i] + max);
            res = Math.max(res, max);
        }

        return res;
    }
}