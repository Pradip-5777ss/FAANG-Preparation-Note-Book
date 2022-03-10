/**
 * 66. Plus One
 * 
 * You are given a large integer represented as an integer array digits, where each digits[i] 
 * is the ith digit of the integer. The digits are ordered from most significant to least significant 
 * in left-to-right order. The large integer does not contain any leading 0's.
 * 
 * Increment the large integer by one and return the resulting array of digits. 
 * 
 * Example 1:
 *  Input: digits = [1,2,3]
 *  Output: [1,2,4]
 *  Explanation: The array represents the integer 123.
 *               Incrementing by one gives 123 + 1 = 124.
 *               Thus, the result should be [1,2,4].
 * 
 * Example 2:
 *  Input: digits = [4,3,2,1]
 *  Output: [4,3,2,2]
 *  Explanation: The array represents the integer 4321.
 *               Incrementing by one gives 4321 + 1 = 4322.
 *               Thus, the result should be [4,3,2,2].
 * 
 * Example 3:
 *  Input: digits = [9]
 *  Output: [1,0]
 *  Explanation: The array represents the integer 9.
 *               Incrementing by one gives 9 + 1 = 10.
 *               Thus, the result should be [1,0].
 * 
 * Space Complexity : O(N)
 * Time Complexity : O(1)
 */

package LeetcodeTopInterviewQuestions.Array.EasyQuestions;

import java.util.Scanner;

public class Q66_PlusOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array  : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        int[] answer = plusOne(arr);
        System.out.print("Output : ");

        for (int i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] plusOne(int[] arr) {

        // Find the length of the array
        int length = arr.length;

        // Traverse the array from last
        for (int i = length - 1; i >= 0; i--) {

            // If the last element is less then 9 then add 1 with it and break the loop
            if (arr[i] < 9) {
                arr[i]++;
                break;
            }

            // Else, update the ith array element by 0
            else {
                arr[i] = 0;
            }
        }

        /**
         * If the first/0th element of the array is 0 then create an new array to return
         * the result
         */
        if (arr[0] == 0) {
            int ans[] = new int[length + 1];

            // Initialize 1 at the first index of the array
            ans[0] = 1;

            // Return the new array
            return ans;
        }

        // Return the original array
        return arr;
    }
}