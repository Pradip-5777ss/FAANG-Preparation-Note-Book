/**
 * @author Pradip Sahoo
 * Created on 08/04/2022
 * -------------------------
 * Write a program to check wheather a array is palindromic or not.
 * 
 * Example:
 *  Input : size = 5
 *          arr[] = {111, 222, 333, 444, 555}
 *  Output : The array is palindromic
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Easy_Questions;

import java.util.Scanner;

public class Q14_PalindromicAarray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int res = palindromeArray(arr);

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