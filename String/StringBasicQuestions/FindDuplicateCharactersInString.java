/**
 *  Find Duplicate characters in a string.	
 */
package String.StringBasicQuestions;

import java.util.Scanner;

public class FindDuplicateCharactersInString {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the string
        System.out.print("Enter the string : ");
        String str = sc.nextLine();

        sc.close();

        // Declare an array and convert the string to an array
        char arr[] = str.toCharArray();

        System.out.print("The duplicate characters are : ");

        // Iterate 2 loops to find duplicate characters in a string
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (arr[i] == arr[j]) {
                    System.out.print(arr[j] + " ");
                    break;
                }
            }
        }
    }
}
