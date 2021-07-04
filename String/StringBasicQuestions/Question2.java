/* 
 * Write a program to count	the	number of occurrences of each character in the string and print it.	
 */

package String.StringBasicQuestions;

import java.util.Scanner;

public class Question2 {
	
	static final int MAX_CHAR = 256;

	static void getOccuringChar(String input)
	{
		
		// Create an array of size 256 
		// i.e. ASCII_SIZE
		int count[] = new int[MAX_CHAR];

		int len = input.length();

		// Initialize count array index
		for (int i = 0; i < len; i++) {
			count[input.charAt(i)]++;
		}

		// Create an array of given String size
		char ch[] = new char[len];
		for (int i = 0; i < len; i++) {
			ch[i] = input.charAt(i);
			int find = 0;
			for (int j = 0; j <= i; j++) {

				// If any matches found
				if (input.charAt(i) == ch[j])
					find++;
			}

			if (find == 1)
			{
				System.out.println("Number of Occurrence of "+ input.charAt(i) + " is:" + count[input.charAt(i)]);
			}
		}
	}

	// Driver Code
	public static void main(String[] args)
	{
		Scanner str = new Scanner(System.in);
		System.out.println("Enter the string from the user");
		String input = str.nextLine();
		getOccuringChar(input);
	}
	
}
