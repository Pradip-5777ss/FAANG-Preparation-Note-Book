/**
 * 169. Majority Element
 * 
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n/2⌋ times. You may assume that the majority element always exists in the array. 
 * 
 * Example 1:
 *  Input: nums = [3,2,3]
 *  Output: 3
 * 
 * Example 2:
 *  Input: nums = [2,2,1,1,1,2,2]
 *  Output: 2
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package LeetcodeTopInterviewQuestions.Array.EasyQuestions;

import java.util.Scanner;

public class Q169_MajorityElement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        int ans = findMajority(arr);

        System.out.println("The majority element is : " + ans);
    }

    // Method to find the majority element of the array
    private static int findMajority(int[] arr) {

        int count = 0;
        int number = 0;

        // Traverse the array
        for (int i : arr) {

            // When the count is 0 then the particular ith element is the majority element
            if (count == 0) {
                number = i;
            }

            /**
             * If the number and i value is same then update the count by 1 else update the
             * count by -1
             */
            count += (i == number) ? 1 : -1;
        }

        // Return the majority element
        return number;
    }
}