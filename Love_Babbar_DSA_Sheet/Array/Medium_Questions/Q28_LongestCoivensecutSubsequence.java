/**
 * @author Pradip Sahoo
 * Created on 06/04/2022
 * ------------------------------------- 
 * Longest consecutive subsequence.
 * Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are 
 * consecutive integers, the consecutive numbers can be in any order.
 *  
 * Example 1:
 *  Input:  N = 7
 *          a[] = {2,6,1,9,4,5,3}
 *  Output: 6
 *  Explanation: The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.
 * 
 * Example 2:
 *  Input:  N = 7
 *          a[] = {1,9,3,10,4,20,2}
 *  Output: 4
 *  Explanation: 1, 2, 3, 4 is the longest consecutive subsequence.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N) 
 */
package Love_Babbar_DSA_Sheet.Array.Medium_Questions;

import java.util.HashSet;
import java.util.Scanner;

public class Q28_LongestCoivensecutSubsequence {

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
        System.out.println("The longest consecutive subsequence is : " + findLongestConsecutiveSubssequence(arr));
    }

    private static int findLongestConsecutiveSubssequence(int[] arr) {

        // Using a hashSet to store the elements
        HashSet<Integer> hs = new HashSet<>();
        int ans = 0;

        // Traverse the array, add all the array elements into the hashSet
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }

        // Checking each possible sequence from the start
        for (int i = 0; i < arr.length; i++) {

            /**
             * If the current element is starting element of a sequence then only we try to
             * find out the length of sequence
             */
            if (!hs.contains(arr[i] - 1)) {
                int j = arr[i];

                /**
                 * Then we keep checking wheather the next consecutive elements are present in
                 * HashSet and we keep incrementing the counter
                 */
                while (hs.contains(j)) {
                    j++;
                }

                // Storing the maximum count
                if (ans < j - arr[i]) {
                    ans = j - arr[i];
                }
            }
        }

        // Returning the length of longest subsequence
        return ans;
    }
}