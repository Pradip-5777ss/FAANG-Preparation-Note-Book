/**
 * @author Pradip Sahoo
 * Created on 03/04/2022
 * ------------------------------------
 * Minimum number of jumps. 
 * Given an array of N integers arr[] where each element represents the max number of steps 
 * that can be made forward from that element. 
 * Find the minimum number of jumps to reach the end of the array (starting from the first element). 
 * If an element is 0, then you cannot move through that element.
 * Note: Return -1 if you can't reach the end of the array.
 * 
 * Example:
 *  Input:  N = 11 
 *          arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} 
 *  Output: 3 
 *  Explanation: First jump from 1st element to 2nd element with value 3. Now, from here we jump to 
 *               5th element with value 9, and from here we will jump to last.
 * 
 * Example 2:
 *  Input : N = 6
 *          arr = {1, 4, 3, 2, 6, 7}
 *  Output: 2 
 *  Explanation: First we jump from the 1st to 2nd element and then jump to the last element.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */

package Love_Babbar_DSA_Sheet.Array.Medium_Questions;

import java.util.Scanner;

public class Q19_MinimumNoOfJumps {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        System.out.print("The minimum jump is : " + minJumps(arr));
    }

    // Method to find the minimum jumps
    private static int minJumps(int[] arr) {

        if (arr.length <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        // Start traversing array
        for (int i = 1; i < arr.length; i++) {

            // Check if we have reached the end of the array
            if (i == arr.length - 1) {
                return jump;
            }

            // updating maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            // we use a step to get to the current index
            step--;

            // If no further steps left
            if (step == 0) {

                // we must have used a jump
                jump++;

                /**
                 * Check if the current index/position or lesser index is the maximum reach
                 * point from the previous indexes
                 */
                if (i >= maxReach) {
                    return -1;
                }

                /**
                 * re-initialize the steps to the amount of steps to reach maxReach from
                 * position i.
                 */
                step = maxReach - i;
            }
        }
        return -1;
    }
}