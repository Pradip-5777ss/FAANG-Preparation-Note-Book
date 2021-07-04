/*
 * 	Move all the negative elements to one side of the array.
 */

package Array.ArrayBasicQuestions;

import java.util.Scanner;

public class Question10 {

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
		System.out.println("Enter the array elemrnts : ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		//method call
		rearrange(arr, size);
		
		//printing statement
		System.out.print("The sorted array is : ");
		printArr(arr, size);
		
	}
	
	//method for find the rearrange array
	static void rearrange(int arr[], int size)
	{
		int i,j=0,temp;
		for(i=0;i<size;i++)
		{
			if(arr[i]<0)
			{
				if(i!=j)
				{
					temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
				j++;
			}
		}
	}
	
	//method for print the array elements
	static void printArr(int arr[], int size)
	{
		for(int i=0;i<size;i++)
		{
			System.out.print(arr[i] +" ");
		}
	}

}
