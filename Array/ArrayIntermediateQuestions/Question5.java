/*
 * Find	duplicates in an array.
 */

package Array.ArrayIntermediateQuestions;

import java.util.Scanner;

public class Question5 {

	public static void main(String[] args) {
		
		//create scanner class to take user input
		Scanner sc = new Scanner(System.in);
		
		//Ask user to enter the size of the array & store it in variable name "size"
		System.out.println("Enter the size of the array : ");
		int size = sc.nextInt();
		
		//initialize the size value into the array
		int arr[] = new int[size];
		
		//Ask user to enter the array elements 
		System.out.println("Enter the array elements : ");
		{
			//iterate for loop to take the array elements from the user.
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
		}
		
		//Printing statement
		System.out.print("Duplicate elements are = ");
		
		//method call
		findDuplicate(arr, size);
	}
	
	//definition of the method to find the duplicates of the array
	static void findDuplicate(int arr[], int size)
	{
		//variable declaration
		int i;
		
		//run for loop to find duplicates
		for ( i = 0; i < size; i++) {
			int j = Math.abs(arr[i]);
			if (arr[j] >= 0) {
				arr[j] = -arr[j];
			}
			else {
				System.out.print(j+" ");
			}
		}
	}
	
}
		
