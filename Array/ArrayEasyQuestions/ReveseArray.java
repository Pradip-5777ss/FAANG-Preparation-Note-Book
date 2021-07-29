/*
 * Write a program to reverse the array.	
 */
package Array.ArrayEasyQuestions;

import java.util.Scanner;

public class ReveseArray {

	public static void main(String[] args) {

		// Create scanner class object to take user input
		Scanner sc = new Scanner(System.in);

		// ask user to enter the size of the array
		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();

		// Initialixe the size into the array
		int arr[] = new int[size];

		// Ask user to enter the array elements
		System.out.println("Enter the array elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		// initialize the size into the another array
		int rev[] = new int[size];

		// declare the variable and initialize it by 0
		int j = 0;

		/**
		 * another for loop to iterate the array into reverse iterate the for loop from
		 * "size-1" to 0 arr[i] value is save into rev[j] and increment the j value
		 */
		for (int i = size - 1; i >= 0; i--) {
			rev[j] = arr[i];
			j++;
		}

		// print the reverse array
		System.out.println("the reverse of the array is : ");
		for (int i = 0; i < size; i++) {
			System.out.print(rev[i] + " ");
		}
	}
}