/*
 * Given an array which consists of only 0, 1 and 2. Sort the array without using any sorting algorithm.	
 */

package Array.ArrayBasicQuestions;

import java.util.Scanner;

public class Question8 {

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

		//method call
		sortArr(arr, size);
		
		//output message
		System.out.print("After sorting the array is : ");
		
		//method call
		printArr(arr, size);
	}
	
	//method for sorting the array.
	static void sortArr(int arr[], int size)
	{
		//declare variable
		int i;
		
		//declare variables and initialize it
		int count0=0,count1=1,count2=2;
		
		//run a for loop to find the occurrence of the 0,1,2's in the array
		for (i = 0; i < size; i++) 
		{
			//define a switch statement with the parameter of "arr[i]" and increment all the count variables according to there case
			switch (arr[i]) 
			{
				//when case is 0 then increment the count0 value and break
				case 0:
						count0++;
						break;
				
				//when case is 1 then increment the count1 value and break
				case 1:
						count1++;
						break;
				
				//when case is 2 then increment the count2 value and break
				case 2:
						count2++;
						break;
			}
		}
		
		//now after the first loop iteration we initialize the i value as 0
		i=0;
		
		//if the count0 value is greater than 0 then we enter the while loop until the condition is false
		while(count0>0)
		{
			//we just increment the i value in the array & save the 0 value in that position. after that we just decrement the count0.
			arr[i++] = 0;
			count0--;
		}
		
		//if the count1 value is greater than 1 then we enter the while loop until the condition is false
		while(count1>1)
		{
			//we just increment the i value in the array & save the 1 value in that position. after that we just decrement the count1.
			arr[i++] = 1;
			count1--;
		}
		
		//if the count2 value is greater than 2 then we enter the while loop until the condition is false
		while(count2>2)
		{
			//we just increment the i value in the array & save the 2 value in that position. after that we just decrement the count2.
			arr[i++]=2;
			count2--;
		}
	}
	
	//printing statement
	//method for print the sorted array
	static void printArr(int arr[], int size)
	{
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
