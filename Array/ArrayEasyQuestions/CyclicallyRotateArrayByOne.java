/**
 * Write a program to cyclically rotate an array by one.
 */
package Array.ArrayEasyQuestions;

import java.util.Scanner;

public class CyclicallyRotateArrayByOne {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.println("Enter thr size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        int[] arr = new int[size];

        // Ask user to enter the array elements
        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        // Method call to rotate array cyclically
        int res[] = rotateCyclically(arr, size);

        // Method call to print the result
        System.out.print("The final array is : ");
        printArr(res, size);
    }

    // Method to print the array
    private static void printArr(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Method to rotate a array cyclically
    private static int[] rotateCyclically(int[] arr, int size) {

        // Store the last element of the array in a variable
        int temp = arr[size - 1];

        // Run a loop from the previous element of last element to 0
        for (int i = size - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        // Initialize the last element of the array into the first element
        arr[0] = temp;
        return arr;
    }
}
