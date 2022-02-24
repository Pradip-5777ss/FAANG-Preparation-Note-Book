/**
 * At least two greater elements 
 * 
 * Given an array of N distinct elements, the task is to find all elements in array except two greatest elements in sorted order.
 * 
 * Example 1:
 *  Input :     a[] = {2, 8, 7, 1, 5}
 *  Output :    1 2 5 
 *  Explanation :   The output three elements have two or more greater elements.   
 * 
 * Example 2:
 *  Input :     a[] = {7, -2, 3, 4, 9, -1}
 *  Output :    -2 -1 3 4
 * 
 * Time Complexity: O(N*Log(N))
 * Auxiliary Space: O(N)
 */
package Array.EasyQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class AtLeastTwoGreaterElements {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        int arr[] = new int[size];

        // Ask user to enter the array elements
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Method call to find the element
        int ans[] = findElements(arr);

        sc.close();
 
        // Print the result
        System.out.println("The resultant array is : ");
        for (int i : ans) {
            System.out.print(i+" ");
        }
    }

    // Method to find the elements
    private static int[] findElements(int[] arr) {

        // Find the length of the array
        int n = arr.length;

        // Sort the unsorted array
        Arrays.sort(arr);

        // Declare a new array
        int newArr[] = new int[n - 2];

        // Transfer the array elements
        for (int i = 0; i < n - 2; i++) {
            newArr[i] = arr[i];
        }

        // return the new array
        return newArr;
    }
}