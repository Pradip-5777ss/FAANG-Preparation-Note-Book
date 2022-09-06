/**
 * @author Pradip Sahoo
 * Created on 07/08/2022
 * --------------------------
 * Second most repeated string in a sequence.
 * Given a sequence of strings, the task is to find out the second most repeated
 * (or frequent) string in the given sequence.
 * 
 * Note: No two strings are the second most repeated, there will be always a
 * single string.
 * 
 * Example 1:
 *  Input : N = 6
 *          arr[] = {aaa, bbb, ccc, bbb, aaa, aaa}
 *  Output: bbb
 *  Explanation: "bbb" is the second most occurring string with frequency 2.
 * 
 * Example 2:
 *  Input : N = 6
 *          arr[] = {geek, for, geek, for, geek, aaa}
 *  Output: for
 *  Explanation: "for" is the second most occurring string with frequency 2.
 * 
 * Time Complexity: O(N*max(|Si|).
 * Space Complexity: O(N*max(|Si|).
 */
package Love_Babbar_DSA_Sheet.String.Easy_Questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q14_SecondMostRepeatedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        String str[] = new String[size];
        System.out.println("Enter the strings : ");
        for (int i = 0; i < size; i++) {
            str[i] = sc.next();
        }

        sc.close();

        System.out.println("The second most repeated string is : " + secondRepeatedString(str));
    }

    /**
     * Method to find the second most repeating string
     * 
     * @param str
     * @return
     */
    private static String secondRepeatedString(String[] str) {

        // Declare a Map
        HashMap<String, Integer> hMap = new HashMap<>();

        // Declare variables
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        String output = "";

        // Traverse the string
        for (int i = 0; i < str.length; ++i) {

            // If Map does not contains the string
            if (!hMap.containsKey(str[i])) {
                hMap.put(str[i], 1);
            }
            // Else increment the count of the string
            else {
                hMap.put(str[i], hMap.get(str[i]) + 1);
            }

            // If the count of a string is greater then 1, it is the first.
            if (hMap.get(str[i]) > 1) {
                first = hMap.get(str[i]);
            }
        }

        // Iterate over the map
        for (Map.Entry<String, Integer> map : hMap.entrySet()) {
            if (map.getValue() > second && map.getValue() < first) {
                second = map.getValue();
                output = map.getKey().toString();
            }
        }

        // Return the output
        return output;
    }
}