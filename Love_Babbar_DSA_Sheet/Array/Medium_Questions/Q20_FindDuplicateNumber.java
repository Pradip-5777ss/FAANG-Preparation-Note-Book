/**
 * @author Pradip Sahoo
 * Created on 03/04/2022
 * ----------------------------
 * Find the Duplicate Number
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * 
 * Example 1:
 *  Input: nums = [1,3,4,2,2]
 *  Output: 2
 * 
 * Example 2:
 *  Input: nums = [3,1,3,4,2]
 *  Output: 3
 * 
 * Time complexity : O(n)
 * space complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Medium_Questions;

import java.util.Scanner;

public class Q20_FindDuplicateNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int nums[] = new int[size];

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        int result = findDuplicate(nums);

        System.out.println("The duplicate number is : " + result);
    }

    // Method to find the duplicate number in an array
    private static int findDuplicate(int[] nums) {

        /**
         * Use two pointer method Fast and slow. Initially both are points to the 0th
         * index of the array
         */
        int fast = nums[0];
        int slow = nums[0];

        // If the length of the array is 1 then return -1
        if (nums.length == 1) {
            return -1;
        }

        /**
         * Phase 1 : Find the intersection point Run the loop till both first and slow
         * aren't same. Fast pointer increments by two node in each iteration and slow
         * pointer increments by one node
         */
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        /**
         * Phase 2 : After they are intersect, again initialize the slow pointer at 0th
         * index.
         */
        slow = nums[0];

        /**
         * At this point fast is point to the intersection point and slow point to the
         * starting point Run a loop till both are not same
         */
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        /**
         * When they are intersecting again the phase 2 is over and that element is the
         * repeting element
         */
        return slow;
    }
}