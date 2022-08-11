/**
 * @author Pradip Sahoo
 * Created on 11/08/2022
 * ------------------------------
 * Permutations of a given string
 * Given a string S. The task is to print all unique permutations of the given
 * string in lexicographically sorted order.
 * 
 * Example 1:
 *  Input: ABC
 *  Output: ABC ACB BAC BCA CAB CBA
 *  Explanation : Given string ABC has permutations in 6 forms as ABC, ACB, BAC, BCA, CAB and CBA .
 * 
 * Example 2:
 *  Input: ABSG
 *  Output : ABGS ABSG AGBS AGSB ASBG ASGB BAGS
 *           BASG BGAS BGSA BSAG BSGA GABS GASB
 *           GBAS GBSA GSAB GSBA SABG SAGB SBAG
 *           SBGA SGAB SGBA
 *  Explanation : Given string ABSG has 24 permutations.
 */
package Love_Babbar_DSA_Sheet.String.Medium_Questions;

import java.util.Scanner;

public class Q21_PermutationsOfGivenString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string : ");
        String str = sc.nextLine();
        sc.close();

        String answer = "";
        System.out.println("Permutations are : ");
        findPermutations(str, answer);
    }

    /**
     * Method to find the permutation of the given string
     * 
     * @param str
     * @param answer
     */
    private static void findPermutations(String str, String answer) {

        /**
         * Base case
         * When the string length is become 0, no new elements are there then return the
         * answer
         */
        if (str.length() == 0) {
            System.out.println(answer + " ");
            return;
        }

        // Traver the string
        for (int i = 0; i < str.length(); i++) {

            // Find the character of the ith position
            char ch = str.charAt(i);

            // Find all the left elements of the particular ith position character
            String str_LeftPart = str.substring(0, i);

            // Find all the right elements of the particular ith position character
            String str_RightPart = str.substring(i + 1);

            // Add both left and right part and this is the rest of the string
            String rest = str_LeftPart + str_RightPart;

            // Recursively call the method for rest of the elements
            findPermutations(rest, answer + ch);
        }
    }
}
