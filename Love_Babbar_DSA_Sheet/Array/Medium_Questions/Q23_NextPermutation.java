/**
 * @author Pradip Sahoo
 * Created on 03/04/2022
 * --------------------------------
 * Next Permutation
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
 * 
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. 
 * More formally, if all the permutations of the array are sorted in one container according to their lexicographical order,
 * then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is 
 * not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 * 
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 * The replacement must be in place and use only constant extra memory.
 *  
 * Example 1:
 *  Input: nums = [1,2,3]
 *  Output: [1,3,2]
 * 
 * Example 2:
 *  Input: nums = [3,2,1]
 *  Output: [1,2,3]
 * 
 * Example 3:
 *  Input: nums = [1,1,5]
 *  Output: [1,5,1]
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Medium_Questions;

import java.util.Scanner;

public class Q23_NextPermutation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        nextPerutation(arr);

        System.out.print("The output array is : ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Method to find next permutation
    private static void nextPerutation(int[] arr) {

        // When the array is null or length is less than 1 then return that array
        if (arr == null || arr.length <= 1) {
            return;
        }

        int i = arr.length - 2;

        /**
         * We traverse the array from right side and check that the last element is
         * smaller than the previous of last element or not if condition true then
         * decrement the pointer
         */
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // Now we find the just greater element from the ith index element and swap them
        if (i >= 0) {
            int j = arr.length - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }

        // Finally reverse the array from (i+1) to last element
        reverse(arr, i + 1, arr.length - 1);
    }

    // Method to swap the elements of the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Method to reverse the array
    public static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }
}
