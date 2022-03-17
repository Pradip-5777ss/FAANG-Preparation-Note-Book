/**
 * 217. Contains Duplicate
 * 
 * Given an integer array nums, return true if any value appears at least twice in the array, 
 * and return false if every element is distinct. 
 * 
 * Example 1:
 *  Input: nums = [1,2,3,1]
 *  Output: true
 * 
 * Example 2:
 *  Input: nums = [1,2,3,4]
 *  Output: false
 * 
 * Example 3:
 *  Input: nums = [1,1,1,3,3,4,3,2,4,2]
 *  Output: true
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package LeetcodeTopInterviewQuestions.Array.EasyQuestions;

import java.util.HashMap;
import java.util.Scanner;

public class Q217_ContainsDuplicate {

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

        boolean ans = containsDuplicate(arr);
        System.out.println("Output : " + ans);
    }

    // Method to find contain duplicates in an array
    private static boolean containsDuplicate(int[] arr) {

        // Declare a hashmap
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            // If the map already contains any particular value of an array then return true
            if (map.containsKey(arr[i])) {
                return true;
            }
            /**
             * Else, put that value into the map, where the key is "ith" value and the value
             * is "arr[i]" value
             */
            else {
                map.put(i, arr[i]);
            }
        }

        // If the value is not found return false
        return false;
    }
}