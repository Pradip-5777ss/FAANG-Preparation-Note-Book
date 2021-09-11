/**
 * Count Pairs with given sum.
 * Given an array of N integers, and an integer K, find the number of pairs of 
 * elements in the array whose sum is equal to K.
 * 
 * Example :
 * Input: N = 4, K = 6
 *      arr[] = {1, 5, 7, 1}
 * Output: 2
 * Explanation: arr[0] + arr[1] = 1 + 5 = 6 and arr[1] + arr[3] = 5 + 1 = 6.
 */
package Array.ArrayEasyQuestions;

import java.util.HashMap;
import java.util.Scanner;

public class CountPairsWithGivenSum {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        int[] arr = new int[size];

        // Ask user to enter the array elements
        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Ask user to enter the sum to find pairs
        System.out.println("Enter the sum which we have to find pairs : ");
        int sum = sc.nextInt();

        sc.close();

        // Method call to count pairs and print the result
        System.out.println("The number of pairs on that given sum is = " + countPairs(arr, sum));
    }

    // Method to count pairs and print result4
    private static int countPairs(int[] arr, int sum) {

        int count = 0;

        // Create a Hashmap
        HashMap<Integer, Integer> map = new HashMap<>();

        System.out.print("The pairs are : ");

        for (int i = 0; i < arr.length; i++) {

            /**
             * If the key is matched then increment count. otherwise, put the value in
             * Hashmap.
             */
            if (map.containsKey(sum - arr[i])) {
                count += map.get(sum - arr[i]);
                System.out.print("(" + (sum - arr[i]) + "," + arr[i] + ")");
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println();

        // return count
        return count;
    }
}