/**
 * Value equal to index value.
 * 
 * Given an array Arr of N positive integers. Your task is 
 * to find the elements whose value is equal to that of its index value.
 * 
 * Example:
 *      Input: N = 5
 *             Arr[] = {15, 2, 45, 12, 7}
 *      Output: 2
 * Explanation: Only Arr[2] = 2 exists here.
 */
package SearchingAndSorting.EasyQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class ValueEqualToIndexValue {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        int arr[] = new int[size];

        // Ask user to enter the array elements
        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        // Method call to find the value equal to index and print the result
        ArrayList<Integer> ans = valueEqualToIndex(arr);
        System.out.println("The " + ans + "position value is equal to the index");
    }

    // Method to find the value which is equal to the index
    private static ArrayList<Integer> valueEqualToIndex(int[] arr) {

        // Declare an ArrayList
        ArrayList<Integer> res = new ArrayList<>();

        // Find the length of the array
        int n = arr.length;

        // Find the index
        for (int i = 0; i < n - 1; i++) {
            if (i + 1 == arr[i]) {
                res.add(i + 1);
            }
        }

        // Return the result
        return res;
    }
}