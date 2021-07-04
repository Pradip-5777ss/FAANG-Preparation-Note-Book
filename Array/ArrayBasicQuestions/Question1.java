 /*
  * Create an Array of size 10 of integers. Take input from the user for these 10 elements and print the entire array after that.
 */
package Array.ArrayBasicQuestions;

import java.util.Scanner;

public class Question1 {
	
	public static void main(String[] args) {
		
		//create scanner class for taking user input
		Scanner sc = new Scanner(System.in);
		
		//declare variable for taking user input
		System.out.println("Enter the size of the array");
		int size = sc.nextInt();
		
		//initialize the size into the array
		int arr[] = new int[size];
		
		//Ask user to enter the array elements
		System.out.println("Enter the array elements");
		for(int i = 0;i<size;i++)
		{
			arr[i] = sc.nextInt();
		}
		
		//Printing statement
		System.out.println("The array elemets are : ");
		for(int i=0;i<size;i++)
		{
			System.out.print(arr[i] +" ");
		}
	}
}