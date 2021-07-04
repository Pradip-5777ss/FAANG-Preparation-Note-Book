/*
 * Check whether n is present in an	array of size m	or not.	
 */

package Array.ArrayBasicQuestions;

import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		
		//create scanner class to take user input
		Scanner p = new Scanner(System.in);
		
		//ask user to enter the size of the array and initialize it in size variable
		System.out.print("Enter the size of the array : ");
		int size = p.nextInt(); 
		
		//declare variables
		int i;
				
		//initialize the size into the array
		int arr[] = new int[size];
		
		//ask user to enter the array elements
		System.out.println("Enter the array elements : ");
		for(i=0;i<size;i++)
		{
			arr[i] = p.nextInt();
		}
		
		//ask user to enter the element for find the occurrence
		System.out.print("Enter the element : ");
		int n = p.nextInt();
		
		//
		for (i = 0; i < size; i++) {
			if (n == arr[i]) {
				System.out.println("true! the element is present in the array");
				break;				
			} else {
				System.out.println("false! the element is not present in the array");
				break;
			}
		}
	}
}