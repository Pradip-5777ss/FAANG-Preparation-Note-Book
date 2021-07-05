/*
 * Given an	number n. Find the number of occurrences of	n in the array.	
 */

package Array.ArrayBasicQuestions;

import java.util.Scanner;

public class Question7 {

	public static void main(String[] args) {
		
		//create scanner class to take user input
		Scanner sc = new Scanner(System.in);
		
		//ask user to enter the size of the array
		//declare a variable "size" to take the user input and initialize it.
		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();
		
		//initialize the size into the array
		int arr[] = new int[size];
		
		//iterate for loop to take user input for the array elements
		System.out.println("Enter the array elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		//ask user to enter the number for find the occurrence in the array.
		//declare a variable "n" for take the user input and initialize it
		System.out.print("Enter the number to find the occurrence : ");
		int n = sc.nextInt();
		sc.close();
		
		//declare a variable for count the occurrence and initialize it with 0
		int count = 0;
		
		//run the for loop to find the occurrence of the number
		//now check how many times the user given number is match with the array elements, then increment the count variable
		for (int i = 0; i < size; i++) {
			if (arr[i] == n) {
				count++;
			}
		}
		
		//printing statement
		//now, print the count variable for print the occurrence of the number 
		System.out.print("The occurrence of the number is : "+count);
	}
}
