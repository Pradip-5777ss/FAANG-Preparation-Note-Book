/**
 * @author Pradip Sahoo
 * Created on 25/08/2022
 * --------------------------
 * Value equal to index value.
 * Given an array Arr of N positive integers. Your task is to find the
 * elements whose value is equal to that of its index value.
 * 
 * Example 1:
 *  Input: N = 5
 *         Arr[] = {15, 2, 45, 12, 7}
 *  Output: 2
 *  Explanation: Only Arr[2] = 2 exists here.
 * 
 * Example 2:
 *  Input: N = 1
 *         Arr[] = {1}
 *  Output: 1
 *  Explanation: Here Arr[1] = 1 exists.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.SearchingAndSorting.Easy_Questions;

import java.util.ArrayList;
import java.util.Scanner;

public class Q02_ValueEqualToIndexValue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        // Method call to find the value equal to index and print the result
        ArrayList<Integer> ans = valueEqualToIndex(arr);
        System.out.println("Output : The " + ans + " position value is equal to the index");
    }

    /**
     * Method to find the value which is equal to the index
     * 
     * @param arr
     * @return
     */
    private static ArrayList<Integer> valueEqualToIndex(int[] arr) {

        // Declare an ArrayList
        ArrayList<Integer> res = new ArrayList<>();

        // Find the length of the array
        int n = arr.length;

        // Find the index
        for (int i = 0; i < n; i++) {
            if (i + 1 == arr[i]) {
                res.add(i + 1);
            }
        }

        // Return the result
        return res;
    }
}