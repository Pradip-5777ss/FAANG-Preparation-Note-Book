/**
 * Write a program to check wheather a array is palindromic or not.
 * 
 * Example : 
 *      size = 5
 *      arr[] = 111 222 333 444 555
 * 
 * Output : The array is palindromic
 */
package Array.EasyQuestions;

import java.util.Scanner;

public class PalindromicAarray1 {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        int arr[] = new int[size];

        // Ask user to enter the elements of the array
        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        // Method call to check the array is palindromic or not
        int res = palindromeArray(arr);

        // Print the result
        if (res == 1) {
            System.out.println("The array is palindromic");
        } else {
            System.out.println("The array is not palindromic");
        }

    }

    // Method to check the array is palindromic or not
    private static int palindromeArray(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            StringBuffer str = new StringBuffer(String.valueOf(arr[i]));

            str.reverse();
            String temp1 = new String(str.toString());
            String temp2 = new String(String.valueOf(arr[i]));

            if (!temp1.equals(temp2)) {
                return 0;
            }
        }
        return 1;
    }
}
