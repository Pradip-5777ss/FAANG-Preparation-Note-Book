/**
 * 53. Maximum Subarray
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) 
 * which has the largest sum and return its sum.
 * 
 * A subarray is a contiguous part of an array.
 * 
 * Example 1:
 *  Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 *  Output: 6
 *  Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * Example 2:
 *  Input: nums = [1]
 *  Output: 1
 * 
 * Example 3:
 *  Input: nums = [5,4,-1,7,8]
 *  Output: 23
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package LeetcodeTopInterviewQuestions.Array.EasyQuestions;

import java.util.Scanner;

public class Q53_MaximumSubarray {

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

        int ans = maximum_Subarray(arr);

        System.out.print("Output : " + ans);
    }

    private static int maximum_Subarray(int[] arr) {

        // Declare an variavle and initialize it by MIN_VALUE
        int maxSum = Integer.MIN_VALUE;

        // Declare another variable
        int runningTotal = 0;

        // Traverse the array
        for (int i : arr) {

            /**
             * Add the particular array element with runningTotal and store the result into
             * runningTotal
             */
            runningTotal += i;

            /**
             * If the runningTotal value is greater than the previous maxSum then update the
             * maxSum value by runningTotal
             */
            if (runningTotal > maxSum) {
                maxSum = runningTotal;
            }

            // If the current runningTotal is less than 0 then update the runningTotal by 0
            if (runningTotal < 0) {
                runningTotal = 0;
            }
        }

        // Return the maxSum
        return maxSum;
    }
}