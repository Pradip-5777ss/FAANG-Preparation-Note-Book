/*
 * You	are	given	a	list	of	n-1	integers	and	these	integers	are	in	the	range	
	of	1	to	n.	There	are	no	duplicates	in	the	list.	One	of	the	integers	is	
	missing	in	the	list.	Write	an	efficient	code	to	find	the	missing	integer.
 */

package Array.ArrayIntermediateQuestions;

import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) {
		
		//create the scanner class to take user input
		Scanner sc = new Scanner(System.in);
		
		//Ask user to enter the size of the array. initialize the value in the variable name "size"
		System.out.println("Enter the size of the array : ");
		int size = sc.nextInt();
		
		//initialize the size value into the array
		int arr[] = new int[size];
		
		//Ask user to enter the array elements. iterate for loop to take user input
		System.out.println("Enter the array elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		//method call
		//declare a variable name "missNo" for store the missing number
		int missNo = missingNumber(arr, size);
		
		//printing statement
		//print the missing number
		System.out.println("The missing number is = "+missNo);
		
	}
	
	//define the method to find the missing number
	static int missingNumber(int arr[], int size)
	{
		//declare the variable
		int i, total;
		
		//find total of all the array elements
		total = (size+1)*(size+2)/2;
		
		//iterate for loop to find the missing number in the array
		for (i = 0; i < size; i++) {
			//we simply iterate the loop and when the condition is true then subtract the array element with total and store it in total for the next iteration.
			total = total - arr[i];
		}
		
		//return total to the main method.
		return total;
	}
}
