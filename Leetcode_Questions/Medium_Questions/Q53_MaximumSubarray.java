/**
 * @author Pradip Sahoo
 * Created on 16/07/2022
 * -----------------------------
 * 53. Maximum Subarray
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
package Leetcode_Questions.Medium_Questions;

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

        int result = maxSubarray(arr);

        System.out.println("Output : " + result);
    }

    private static int maxSubarray(int[] arr) {

        // Declare two variables and initialize it by first element of the array
        int maximum = arr[0];
        int res = arr[0];

        // Traverse the array and find the maximum subarray
        for (int i = 1; i < arr.length; i++) {
            maximum = Math.max(arr[i], arr[i] + maximum);
            res = Math.max(res, maximum);
        }
        return res;
    }
}