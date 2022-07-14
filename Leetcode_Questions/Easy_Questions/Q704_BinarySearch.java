/**
 * @author Pradip Sahoo
 * Created on 14/07/2022
 * ------------------------
 * 704. Binary Search
 * Given an array of integers nums which is sorted in ascending order, and an
 * integer target, write a function to search target in nums. If target exists,
 * then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 *  Input: nums = [-1,0,3,5,9,12], target = 9
 *  Output: 4
 *  Explanation: 9 exists in nums and its index is 4
 * 
 * Example 2:
 *  Input: nums = [-1,0,3,5,9,12], target = 2
 *  Output: -1
 *  Explanation: 2 does not exist in nums so return -1
 * 
 * Time Complexity : O(log n)
 * Space Complexity : O(1)
 */
package Leetcode_Questions.Easy_Questions;

import java.util.Scanner;

public class Q704_BinarySearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the target to search : ");
        int target = sc.nextInt();

        sc.close();

        System.out.println("Output : " + search(arr, target));
    }

    /**
     * Method to find the element using binary search
     * 
     * @param arr
     * @param target
     * @return the index of the target or -1
     */
    private static int search(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}