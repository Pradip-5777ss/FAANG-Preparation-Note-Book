/**
 * Write a program to reverse a string.
 */
package String.StringBasicQuestions;

import java.util.Scanner;

public class ReveseString {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the string
        System.out.print("Enter the string : ");
        String str = sc.nextLine();

        //  Convert the string into array
        char s[] = str.toCharArray();

        sc.close();

        // Method call to reverse the string
        reverseString(s);
    }

    // Method to reverse the string
    private static void reverseString(char[] s) {

        /**
         * Use two pointer method. set start pointer to 0 and end pointer to the
         * previous of last element
         */
        int start = 0;
        int end = s.length - 1;

        while (end > start) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }

        // Print the reverse list
        System.out.print("The reverse string is : ");
        System.out.println(s);
    }
}