/**
 * 26. Remove Duplicates from Sorted Array
 * 
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each 
 * unique element appears only once. The relative order of the elements should be kept the same.
 * 
 * Since it is impossible to change the length of the array in some languages, you must instead have the result 
 * be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, 
 * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * 
 * Return k after placing the final result in the first k slots of nums.
 * 
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * Example 1:
 *  Input: nums = [1,1,2]
 *  Output: 2, nums = [1,2,_]
 *  Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 *               It does not matter what you leave beyond the returned k (hence they are underscores).
 * 
 * Example 2:
 *  Input: nums = [0,0,1,1,1,2,2,3,3,4]
 *  Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 *  Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 *               It does not matter what you leave beyond the returned k (hence they are underscores).
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package LeetcodeTopInterviewQuestions.Array.EasyQuestions;

import java.util.Scanner;

public class Q26_RemoveDuplicatesFromSotedArray {

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

        int k = removeDuplicates(arr);
        System.out.print("Output : " + k);
    }

    private static int removeDuplicates(int[] arr) {

        // Declare an variable to point the index & initialize by 0
        int index = 0;

        // Traverse the array
        for (int i = 1; i < arr.length; i++) {

            /**
             * If the both index elements are not same then increment the index and update
             * the values
             */
            if (arr[i] != arr[index]) {
                index++;
                arr[index] = arr[i];
            }
        }

        // Return the value
        return index + 1;
    }
}