/**
 * @author Pradip Sahoo
 * Created on 07/04/2022
 * --------------------------------
 * Chocolate Distribution Problem.
 * Given an array A[] of positive integers of size N, where each value
 * represents the number of chocolates in a packet. Each packet can have a
 * variable number of chocolates. There are M students, the task is to
 * distribute chocolate packets among M students such that :
 *  1. Each student gets exactly one packet.
 *  2. The difference between maximum number of chocolates given to a student and
 *     minimum number of chocolates given to a student is minimum.
 * 
 * Example 1:
 *  Input : N = 8, M = 5
 *          A = {3, 4, 1, 9, 56, 7, 9, 12}
 *  Output: 6
 *  Explanation: The minimum difference between maximum chocolates and minimum
 *  chocolates is 9 - 3 = 6 by choosing following M packets : {3, 4, 9, 7, 9}.
 * 
 * Example 2:
 *  Input : N = 7, M = 3
 *          A = {7, 3, 2, 4, 9, 12, 56}
 *  Output: 2
 *  Explanation: The minimum difference between maximum chocolates and minimum
 *  chocolates is 4 - 2 = 2 by choosing following M packets : {3, 2, 4}.
 * 
 * Time Complexity : O(Nlogn)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Easy_Questions;

import java.util.Arrays;
import java.util.Scanner;

public class Q12_ChocklateDistribution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the number of students : ");
        int students = sc.nextInt();

        sc.close();

        System.out.print("Minimum Difference is : " + findMinDiff(arr, students));
    }

    private static int findMinDiff(int[] arr, int students) {

        // if there are no chocolates or number of students is 0
        if (students == 0 || arr.length == 0)
            return 0;

        // Sort the given packets
        Arrays.sort(arr);

        // Number of students cannot be more than number of packets
        if (arr.length < students) {
            return -1;
        }

        // Largest number of chocolates
        int min_diff = Integer.MAX_VALUE;

        /**
         * Find the subarray of size m such that difference between last (maximum in
         * case of sorted) and first (minimum in case of sorted) elements of subarray is
         * minimum.
         */

        for (int i = 0; i + students - 1 < arr.length; i++) {
            int diff = arr[i + students - 1] - arr[i];
            if (diff < min_diff) {
                min_diff = diff;
            }
        }
        return min_diff;
    }
}