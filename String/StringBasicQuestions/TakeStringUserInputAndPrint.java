/*
 * Write a basic program to take input (String) from User and just print it.	
 */
package String.StringBasicQuestions;

import java.util.Scanner;

public class TakeStringUserInputAndPrint {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the string from the user : ");
		String getString = sc.nextLine();
		
		sc.close();

		System.out.println(getString + " ");
	}
}
