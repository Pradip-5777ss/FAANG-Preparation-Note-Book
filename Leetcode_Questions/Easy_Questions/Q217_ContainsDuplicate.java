/**
 * @author Pradip Sahoo
 * Created on 14/07/2022
 * ------------------------
 * 217. Contains Duplicate
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 * 
 * Example 1:
 *  Input: nums = [1,2,3,1]
 *  Output: true
 * Example 2:
 *  Input: nums = [1,2,3,4]
 *  Output: false
 * Example 3:
 *  Input: nums = [1,1,1,3,3,4,3,2,4,2]
 *  Output: true
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package Leetcode_Questions.Easy_Questions;

import java.util.HashSet;
import java.util.Scanner;

public class Q217_ContainsDuplicate {

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

        boolean result = checkContainsDuplicate(arr);

        System.out.print("Output : ");
        if (result) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    /**
     * Method to check wheather an array contains duplicate or not
     * 
     * @param arr
     * @return true or false
     */
    private static boolean checkContainsDuplicate(int[] arr) {

        // Declare an HashSet
        HashSet<Integer> set = new HashSet<>();

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            // If set contains the duplicate elements then return true else return false
            if (set.contains(arr[i])) {
                return true;
            } else {
                set.add(arr[i]);
            }
        }
        return false;
    }
}