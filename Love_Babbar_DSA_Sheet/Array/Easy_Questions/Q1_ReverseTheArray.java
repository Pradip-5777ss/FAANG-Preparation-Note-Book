/**
 * Write a program to reverse an array or string.
 * Given an array (or string), the task is to reverse the array/string.
 * 
 * Example 1:
 *  Input  : arr[] = {1, 2, 3}
 *  Output : arr[] = {3, 2, 1}
 * 
 * Example 2:
 *  Input :  arr[] = {4, 5, 1, 2}
 *  Output : arr[] = {2, 1, 5, 4}
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Easy_Questions;

import java.util.Scanner;

public class Q1_ReverseTheArray {
    
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

		reverseArr(arr);
		printArr(arr);
	}

	//	Method to print the array
	private static void printArr(int[] arr) {

		System.out.print("The output array is : ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	//	Method to reverse the array
	private static void reverseArr(int[] arr) {
		
		// Declare two pointers
		int start = 0, end = arr.length - 1;

		// swap the array
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}