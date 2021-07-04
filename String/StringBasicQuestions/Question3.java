package String.StringBasicQuestions;

import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) {
		
		Scanner str = new Scanner(System.in);
		
		System.out.println("Enter the string from the user : ");
		String getInput = str.nextLine();
		
		getInput = getInput.replaceAll("\\s","");
		System.out.println(getInput);
	}
}
