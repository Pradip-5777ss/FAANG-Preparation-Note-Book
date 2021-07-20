/**
 * Java program to count the occurrences of each character.
 */
package String.StringBasicQuestions;

import java.util.Scanner;

public class CountOccurenceOfEachCharacter {

    static int Max_Char = 256;

    public static void main(String[] args) {

        // Create Scanner class to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the character string
        System.out.println("Enter the string");
        String str = sc.nextLine();

        sc.close();

        // Method call to count the Occurence
        countOccurence(str);
    }

    // Method to count the occurence
    private static void countOccurence(String str) {

        // Create an array of size 256, i.e. ASCII_SIZE
        int count[] = new int[Max_Char];

        // Find the length of the string
        int len = str.length();

        // count array index of every element
        for (int i = 0; i < len; i++) {
            count[str.charAt(i)]++;
        }

        // Create an array of given string size
        char ch[] = new char[str.length()];
        for (int i = 0; i < len; i++) {
            ch[i] = str.charAt(i);

            int find = 0;
            for (int j = 0; j <= i; j++) {

                // If matches found then increment the find value
                if (str.charAt(i) == ch[j]) {
                    find++;
                }
            }

            // Print the occurence of the character
            if (find == 1) {
                System.out.println("Number of Occurence of " + str.charAt(i) + " is : " + count[str.charAt(i)]);
            }
        }
    }
}
