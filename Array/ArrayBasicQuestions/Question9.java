/*
 * Find	the	range of the array.	Range means	the	difference between the maximum and minimum element in the array.	
 */

package Array.ArrayBasicQuestions;

import java.util.Scanner;

public class Question9 {

	public static void main(String[] args) {
		
		//create scanner class to take user input
		Scanner sc = new Scanner(System.in);
		
		//Ask user to enter the size of the array
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
		sc.close();

		//method call
		System.out.print("The range of the array is : ");
		findRange(arr, size);
	}
	
	//method for find the range of the array
	static void findRange(int arr[], int size)
	{
		//declare variables
		int min, max;
		
		//initialize both the variable by arr[0]
		min = max = arr[0];
		
		//run this for loop to find the minimum & maximum of the array
		for (int i = 0; i < size; i++) {
			if (arr[i]<min) {
				min = arr[i];
			}
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		
		//declare a variable 
		int range;
		
		//find range which is the difference between max & min
		range = max - min;

		//printing statement
		System.out.println(range);
		
		
	}

}
