/*
 * Find	the	Kth	largest	and	Kth	smallest number	in an array.	
 */

package Array.ArrayBasicQuestions;

import java.util.Scanner;
import java.util.*;

public class Question6 {
	
	public static void main(String[] args) {
		
		//create scanner class to take user input
		Scanner sc = new Scanner(System.in);
		
		//ask user to enter the size of the array
		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();
		
		//initialize the size into the array
		int arr[] = new int[size];
		
		//ask user to enter the array elements & iterate for loop to take user input for the array
		System.out.println("Enter the array elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		//ask user to give the key value for finding the k-th largest/smallest element in the array
		//declare a variable "k" & store the key value
		System.out.print("Enter the key value : ");
		int k = sc.nextInt();
		sc.close();
		
		//printing statement
		
		//method call for print the k-th smallest element
		System.out.println("k-th smallest element is = "+kthSmallest(arr, size, k));
		
		//method call for print the k-th largest element
		System.out.println("k-th largest element is = "+kthLargest(arr, size, k));
	}
	
	//definition of the method of finding kth smallest element
	public static int kthSmallest(int arr[], int size, int k)
	{
		Arrays.sort(arr);
		
		return arr[k-1];
	}

	//definition of the method of finding kth largest element
	public static int kthLargest(int arr[], int size, int k)
	{
		Arrays.sort(arr);
		
		return arr[size-k];
	}
}
