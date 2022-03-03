/**
 * Two Sum
 * 
 * Given an array of integers nums[] and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * 
 * Example 1:
 *  Input: nums = [2,7,11,15], target = 9
 *  Output: [0,1]
 *  Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Example 2:
 *  Input: nums = [3,2,4], target = 6
 *  Output: [1,2]
 * 
 * Example 3:
 *  Input: nums = [3,3], target = 6
 *  Output: [0,1]
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package LeetcodeTopInterviewQuestions.Array.EasyQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        int arr[] = new int[size];

        // Ask user to enter the elements of the array
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Ask user to enter the target
        System.out.print("Enter the target : ");
        int target = sc.nextInt();

        // Method call to find the two sum
        int ans[] = twoSum(arr, target);

        sc.close();

        // Print the output
        System.out.print("output : ");
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Method to find the twoSum
    private static int[] twoSum(int[] arr, int target) {

        // Declare a Hashmap
        Map<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            /**
             * Find the difference between target and the particular array element and store
             * it in a variable result.
             */
            int result = (target - arr[i]);

            /**
             * If map contain the result value then declare an array and store that
             * particular key value and the recent i index in the array. And return the
             * array.
             */
            if (map.containsKey(result)) {
                int toReturn[] = { map.get(result), i };
                return toReturn;
            }

            // If element is not found in map then put it in map
            map.put(arr[i], i);
        }

        // If the target is not found then return null
        return null;
    }
}