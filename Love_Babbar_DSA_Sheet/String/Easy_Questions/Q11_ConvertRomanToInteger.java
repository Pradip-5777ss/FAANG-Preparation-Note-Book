/**
 * @author Pradip Sahoo
 * Created on 06/09/2022
 * -------------------------------
 * Given a string in roman no format (s) your task is to convert it to an
 * integer . Various symbols and their values are given below.
 *  I 1
 *  V 5
 *  X 10
 *  L 50
 *  C 100
 *  D 500
 *  M 1000
 * 
 * Example 1:
 *  Input:   s = V
 *  Output: 5
 * 
 * Example 2:
 *  Input:  s = III
 *  Output: 3
 * 
 * Time Complexity : O(|S|), |S| = length of String S
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.String.Easy_Questions;

import java.util.HashMap;
import java.util.Scanner;

public class Q11_ConvertRomanToInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Roman No : ");
        String str = sc.nextLine();

        sc.close();
        System.out.println("The given Roman no to Integer is : " + romanToInteger(str));
    }

    /**
     * Method to convert the roman no to integer
     * 
     * @param str
     * @return the integer
     */
    private static int romanToInteger(String str) {

        // Declare a Map to store the Roman numbers
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        /**
         * Declare an result variable to store the result and initialize it by the last
         * element of the string.
         */
        int result = map.get(str.charAt(str.length() - 1));

        // Traverse the string from 2nd last element
        for (int i = str.length() - 2; i >= 0; i--) {

            /**
             * If the (i+1) element is greater than the ith element then substract ith
             * element from result.
             * 
             * Else, add it with result.
             */
            if (map.get(str.charAt(i)) < map.get(str.charAt(i + 1))) {
                result -= map.get(str.charAt(i));
            } else {
                result += map.get(str.charAt(i));
            }
        }

        // Finally, return the result
        return result;
    }
}