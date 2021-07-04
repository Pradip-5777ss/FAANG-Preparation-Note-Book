package Array.ArrayIntermediateQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class Question10 {

		public static void main(String[] args) {
			
			//create scanner class to take user input
			Scanner sc = new Scanner(System.in);
			
			//ask user to enter the size of the array & initialize it in variable name size
			System.out.println("Enter the size of the array : ");
			int size = sc.nextInt();
			
			//initialize the size value into the array
			int arr[] = new int[size];
			
			//ask user to enter the array elements & iterate for loop to take user input
			System.out.println("Enter the array elements ");
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			
			//printing statement
			System.out.println("The three largest elements are = ");
			
			//method call
			threeLargestElement(arr, size);
		}
		
		//method definition to find the three largest element in the array
		static void threeLargestElement(int arr[], int size)
		{
			//java collection framework(sorting)
			//the unsorted array is already sorted
			Arrays.sort(arr);
			
			//declare the variable and initialize it with value
			int check = 0, count = 1;
			
			//iterate for loop to find the largest three element
			for (int i = 1; i <= size; i++) {
				
				//check the condition up to the count value is less than the the number of element to find.
				//i.e. if we are find three largest element then we check the count value less than 4
				if (count < 4) {
					//it checks the condition that the check variable value is not equal to the arr[size-i].
					//if this condition is true then it simply print the arr[size-i] value
					//after that check variable is initialized by arr[size-1] value
					//after that count variable value is incremented
					if (check != arr[size-i]) {
						System.out.println(arr[size-i]+" ");
						check = arr[size-i];
						count++;
					}						
				} else {
					break;
				}
			}
		}
	}
