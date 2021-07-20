/**
 * Write a program to remove all whitespaces in a given string.
 */
package String.StringBasicQuestions;

import java.util.Scanner;

public class RemoveWhiteSpacesFromString {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the string
        System.out.println("Enter the string : ");
        String str = sc.nextLine();

        sc.close();

        // Use replaceAll function to remove all white spaces
        str = str.replaceAll("\\s", "");

        // Print the string after delete all white spaces
        System.out.println(str);
    }
}