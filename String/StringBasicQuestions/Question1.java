/*
 * Write a basic program to take input (String) from User and just print it.	
 */

package String.StringBasicQuestions;

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		
		Scanner str = new Scanner(System.in);
		
		System.out.println("Enter the string from the user : ");
		String getString = str.nextLine();
		
		System.out.println(getString + " ");
		
	}
}
