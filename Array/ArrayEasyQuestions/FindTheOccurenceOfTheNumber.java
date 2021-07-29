/*
 * Given an	number n. Find the number of occurrences of	n in the array.	
 */
package Array.ArrayEasyQuestions;

import java.util.Scanner;

public class FindTheOccurenceOfTheNumber {

	public static void main(String[] args) {

		// create scanner class object to take user input
		Scanner sc = new Scanner(System.in);

		// ask user to enter the size of the array
		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();

		// initialize the size into the array
		int arr[] = new int[size];

		// Run a loop to take user input for the array elements
		System.out.println("Enter the array elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		// ask user to enter the number for find the occurrence in the array.
		System.out.print("Enter the number to find the occurrence : ");
		int n = sc.nextInt();
		sc.close();

		// declare a variable for count the occurrence and initialize it by 0
		int count = 0;

		/**
		 * Run a loop to find the occurence of the number. check how many times the
		 * number is equal to the array elements & count it.
		 */
		for (int i = 0; i < size; i++) {
			if (arr[i] == n) {
				count++;
			}
		}

		// print the count
		System.out.print("The occurrence of the number is : " + count);
	}
}
