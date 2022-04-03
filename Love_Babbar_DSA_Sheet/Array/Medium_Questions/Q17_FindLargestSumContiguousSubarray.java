/**
 * @author Pradip Sahoo
 * Created on 03/04/2022
 * ----------------------------------
 * Kadane's Algorithm
 * Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) 
 * which has the maximum sum and return its sum.
 * 
 * Example 1:
 *  Input:  N = 5
 *          Arr[] = {1,2,3,-2,5}
 *  Output: 9
 *  Explanation: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.
 * 
 * Example 2:
 *  Input:  N = 4
 *          Arr[] = {-1,-2,-3,-4}
 *  Output: -1
 *  Explanation: Max subarray sum is -1 of element (-1)
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Medium_Questions;

import java.util.Scanner;

public class Q17_FindLargestSumContiguousSubarray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        System.out.println("SubArray with the maximum sum is : " + maxSubArraySum(arr));
    }

    // Method to find the maximum subarray sum
    private static int maxSubArraySum(int[] arr) {

        // Declare two variable
        int runningTotal = arr[0];
        int maxSum = arr[0];

        // Traverse the array
        for (int i = 1; i < arr.length; i++) {

            // Find the maximum of current element
            runningTotal = Math.max(arr[i], arr[i] + runningTotal);

            /**
             * Find the maximum between running total and maxsum, and store the result in
             * maxsum
             */
            maxSum = Math.max(runningTotal, maxSum);
        }

        // Return the maximum sum
        return maxSum;
    }
}