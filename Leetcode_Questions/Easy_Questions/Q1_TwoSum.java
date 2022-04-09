/**
 * @author Pradip Sahoo
 * Created On 09/04/2022
 * ------------------------------
 * 1. Two Sum
 * Given an array of integers nums[] and an integer 'target', return indices of
 * the two numbers such that they add up to 'target'.
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
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
package Leetcode_Questions.Easy_Questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q1_TwoSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the target : ");
        int target = sc.nextInt();

        int ans[] = twoSum(arr, target);

        sc.close();

        // Print the output
        System.out.print("output : ");
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Method to find the indices of the two numbers such that they add up to
     * 'target'
     * 
     * @param arr
     * @param target
     * @return indices of the array
     */
    private static int[] twoSum(int[] arr, int target) {

        // Declare a Hashmap
        Map<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            // Find the difference between target and the ith array element
            int result = (target - arr[i]);

            /**
             * If map contain the result then declare an array and store the key value of
             * result and the recent i index in the array. And return the array.
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