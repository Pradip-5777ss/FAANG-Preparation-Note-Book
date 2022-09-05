/**
 * @author Pradip Sahoo
 * Created on 12/08/2022
 * -------------------------------
 * Print all the duplicates in the input string
 * Write an efficient program to print all the duplicates and their counts in
 * the input string.
 * 
 * Example:
 *  Input : test start
 *  Output : s - Count = 2
 *           t - Count = 4
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(K)
 */
package Love_Babbar_DSA_Sheet.String.Easy_Questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q04_PrintAllDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string : ");
        String str = sc.nextLine();

        sc.close();

        // Method call to find all the duplicate elements
        findDuplicate(str);
    }

    /**
     * Method to find the duplicates of the string with there count
     * 
     * @param str
     */
    private static void findDuplicate(String str) {

        // Declare a Map
        Map<Character, Integer> count = new HashMap<>();

        // Traverse the string
        for (int i = 0; i < str.length(); i++) {

            /**
             * If the Map contains the element of the string then increment count.
             * 
             * Else, Put the element of the string into the Map
             */
            if (count.containsKey(str.charAt(i))) {
                count.put(str.charAt(i), count.get(str.charAt(i)) + 1);
            } else {
                count.put(str.charAt(i), 1);
            }
        }

        // Traverse through the map and print the count of the duplicate elements
        for (Map.Entry<Character, Integer> mapElement : count.entrySet()) {
            if (mapElement.getValue() > 1) {
                System.out.println(mapElement.getKey() + " - Count = " + mapElement.getValue());
            }
        }
    }
}