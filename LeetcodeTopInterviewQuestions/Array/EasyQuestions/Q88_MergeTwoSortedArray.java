/**
 * 88. Merge Sorted Array
 * 
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, 
 * representing the number of elements in nums1 and nums2 respectively. 
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, 
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * 
 * Example 1:
 *  Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 *  Output: [1,2,2,3,5,6]
 *  Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 *               The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * 
 * Example 2:
 *  Input: nums1 = [1], m = 1, nums2 = [], n = 0
 *  Output: [1]
 *  Explanation: The arrays we are merging are [1] and []. The result of the merge is [1].
 * 
 * Example 3:
 *  Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 *  Output: [1]
 *  Explanation: The arrays we are merging are [] and [1]. The result of the merge is [1].
 *  Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 * 
 * Time Complexity :
 *     Worst Case: O(m + n), we iterate over each of m and n once.
 *     Best Case: O(n), we insert b's into a, and they all happen to fit exactly at the end.
 * Space Complexity : O(1)
 */

package LeetcodeTopInterviewQuestions.Array.EasyQuestions;

import java.util.Scanner;

public class Q88_MergeTwoSortedArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the first array : ");
        int size_1 = sc.nextInt();

        int arr1[] = new int[size_1];

        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size_1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter the number of elements present in arr1 : ");
        int m = sc.nextInt();

        System.out.print("Enter the size of the second array : ");
        int size_2 = sc.nextInt();

        int arr2[] = new int[size_2];

        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size_2; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.print("Enter the number of elements present in arr2 : ");
        int n = sc.nextInt();

        merge_Array(arr1, m, arr2, n);

        sc.close();

        System.out.print("Answer : ");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void merge_Array(int[] arr1, int m, int[] arr2, int n) {

        // Declare an Variable tail_1 to find the last element of arr1.
        int tail_1 = m - 1;

        // Declare an variable tail_2 to find the last element of arr2
        int tail_2 = n - 1;

        // Declare an variable finished to find the total length of the arr1
        int finished = m + n - 1;

        // Run a loop until the tail_1 and tail_2 is not 0
        while (tail_1 >= 0 && tail_2 >= 0) {

            /**
             * If tail_1 element of arr1 is greater than the tail_2 element of arr2 then put
             * that element in the position of finished. Decrement the tail_1 and finished.
             */
            if (arr1[tail_1] > arr2[tail_2]) {
                arr1[finished] = arr1[tail_1];
                tail_1--;
                finished--;
            }
            /**
             * Else, put the tail_2 element in the position of finished and decrement the
             * tail_2 and finished.
             */
            else {
                arr1[finished] = arr2[tail_2];
                tail_2--;
                finished--;
            }
        }

        // only need to combine with remaining arr2
        while (tail_2 >= 0) {
            arr1[finished--] = arr2[tail_2--];
        }
    }
}