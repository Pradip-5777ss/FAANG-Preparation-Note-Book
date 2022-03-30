/**
 * @author Pradip Sahoo
 * Created on 25/03/2022
 * -------------------------------------------------
 * Move all negative numbers to beginning and positive to end with constant extra space.
 * An array contains both positive and negative numbers in random order. Rearrange the array elements 
 * so that all negative numbers appear before all positive numbers.
 * 
 * Example : 
 * 	Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
 * 	Output: -12 -13 -5 -7 -3 -6 11 6 5
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Easy_Questions;

import java.util.Scanner;

public class Q4_MoveAllNegetiveElementsOneSide {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();

		int arr[] = new int[size];

		System.out.println("Enter the array elemrnts : ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		// Method call to rearrange the array
		rearrange(arr, size);

		System.out.print("The sorted array is : ");
		printArr(arr, size);
	}

	// method to rearrange the array elements
	static void rearrange(int arr[], int size) {

		int j = 0, temp;

		// Traverse the array
		for (int i = 0; i < size; i++) {

			/**
			 * If the ith element of the array is less than 0 and if the i & j value is not
			 * same then swap the values. and increment the j.
			 */
			if (arr[i] < 0) {
				if (i != j) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j++;
			}
		}
	}

	// method to print the array elements
	static void printArr(int arr[], int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}