/**
 * @author Pradip Sahoo
 * Created on 31/03/2022
 * ---------------------------
 * Count pairs with given sum
 * Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.
 * 
 * Example 1:
 *  Input:  N = 4, K = 6
 *          arr[] = {1, 5, 7, 1}
 *  Output: 2
 *  Explanation: arr[0] + arr[1] = 1 + 5 = 6 and arr[1] + arr[3] = 5 + 1 = 6.
 * 
 * Example 2:
 *  Input:
 *          N = 4, K = 2
 *          arr[] = {1, 1, 1, 1}
 *  Output: 6
 *  Explanation: Each 1 will produce sum 2 with any 1.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */

package Love_Babbar_DSA_Sheet.Array.Easy_Questions;

import java.util.HashMap;
import java.util.Scanner;

public class Q8_CountPairsWithGivenSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the sum which we have to find the pairs : ");
        int sum = sc.nextInt();

        sc.close();

        System.out.print("The number of pairs of that given sum is : " + countPairs(arr, sum));
    }

    // Method to count the pairs
    private static int countPairs(int[] arr, int sum) {

        int count = 0;

        // Declare an hashmap
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            // If the map contains the specific key then increment the count
            if (map.containsKey(sum - arr[i])) {
                count += map.get(sum - arr[i]);
            }

            // If key is not present in the hashmap then put it in the hashmap
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Return count
        return count;
    }
}