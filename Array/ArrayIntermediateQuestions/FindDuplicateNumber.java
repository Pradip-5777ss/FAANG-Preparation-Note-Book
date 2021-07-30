/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * Time complexity of this problem is O(n) & space complexity is O(1).
 */
package Array.ArrayIntermediateQuestions;

import java.util.Scanner;

public class FindDuplicateNumber {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        int arr[] = new int[size];

        // Ask user to enter the array elements
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        // Method call to find the duplicate number
        int result = findDuplicate(arr);

        // Print the duplicate number
        System.out.println("The duplicate number is : " + result);
    }

    // Method to find the duplicate number in an array
    private static int findDuplicate(int[] arr) {

        /**
         * Use two pointer method Fast and slow. Initially both are points to the 0th
         * index of the array
         */
        int fast = arr[0];
        int slow = arr[0];

        // If the length of the array is 1 then return -1
        if (arr.length == 1) {
            return -1;
        }

        /**
         * Phase 1 : Find the intersection point Run the loop till both first and slow
         * aren't same. Fast pointer increments by two node in each iteration and slow
         * pointer increments by one node
         */
        do {
            fast = arr[arr[fast]];
            slow = arr[slow];
        } while (fast != slow);

        /**
         * Phase 2 : After they are intersect, again initialize the slow pointer at 0th
         * index.
         */
        slow = arr[0];

        /**
         * At this point fast is point to the intersection point and slow point to the
         * starting point Run a loop till both are not same
         */
        while (fast != slow) {
            fast = arr[fast];
            slow = arr[slow];
        }

        /**
         * When they are intersecting again the phase 2 is over and that element is the
         * repeting element
         */
        return slow;
    }
}
