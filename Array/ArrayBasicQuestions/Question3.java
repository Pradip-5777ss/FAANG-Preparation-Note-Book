/*
 * Find	the	minimum	and	maximum	element	in an array.	
 */

package Array.ArrayBasicQuestions;

import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) {
		
		//create scanner class to take user input
		Scanner sc = new Scanner(System.in);
		
		//ask user to enter the size of the array
		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();
		
		//enter the size into the array
		int arr[] = new int[size];
		
		//for loop to take enter the array elements from the user
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		//declare the variable
		int min, max;
		
		//initialize the variable by arr[0]
		min = max = arr[0];
		
		//for loop to find the maximum and minimum element.
		//if arr[i] is greater than max then the element is maximum.
		//if arr[i] is lower than max then the element is minimum.
		for (int i = 0; i < size; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		
		//printing statement
		System.out.println("The minimum element is : "+min);
		System.out.println("The maximum element is : "+max);
	}
}
