package String.StringBasicQuestions;

import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {
		
		Scanner str = new Scanner(System.in);
		
		System.out.println("Enter the string from the user : ");
		String getInput = str.nextLine();
		
		char[] inp = getInput.toCharArray();
		System.out.println("Duplicate characters are : ");
		for (int i = 0; i < getInput.length(); i++) {
			for (int j = i+1; j < getInput.length(); j++) {
				if(inp[i] == inp[j]) {
					System.out.println(inp[j]);
					break;
				}
			}
		}
	}
}
