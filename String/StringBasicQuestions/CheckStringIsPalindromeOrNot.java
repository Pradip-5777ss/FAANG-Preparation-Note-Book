/**
 * Check whether the String is a palindrome or not.	
 */
package String.StringBasicQuestions;

import java.util.Scanner;

public class CheckStringIsPalindromeOrNot {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the string
        System.out.println("Enter the string : ");
        String str = sc.nextLine();

        sc.close();

        // Method call to check the string is palindrome or not
        int result = isPalindrome(str);

        if (result == 1) {
            System.out.println("The string is palindrome");
        } else {
            System.out.println("The stirng is not palindrome");
        }
    }

    // Method to check the string is palindrome or not
    private static int isPalindrome(String str) {

        // Use two pointer
        int start = 0;
        int end = str.length() - 1;
        int flag = 1;

        while (end > start) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                flag = 0;
                break;
            }
        }
        return flag;
    }
}
