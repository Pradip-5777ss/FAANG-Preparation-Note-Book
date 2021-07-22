/**
 * Count and Say problem
 */
package String.StringIntermediateQuestions;

import java.util.Scanner;

public class CountAndSay {

    public static void main(String[] args) {

        // Create Scanner class to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the value
        System.out.println("Enter the value of n : ");
        int n = sc.nextInt();

        sc.close();

        // print the result
        System.out.println("The result is : " + countandSay(n));
    }

    /**
     * Returns n'th term in look-and-say sequence
     */
    private static String countandSay(int n) {

        /**
         * base case.
         * return the string "1" when n==1
         */
        if (n == 1) {
            return "1";
        }

        // recursively calls countAndSay until n==1
        String s = countandSay(n - 1);

        StringBuffer sn = new StringBuffer();
        int len = s.length();

        // incrementing i inside the loop
        for (int i = 0; i < len;) {

            // j is used to count the same digit repeatedly
            int j = i + 1;

            // counter to count the repeated digit
            int count = 1;

            // check if j is less than the length of the string
            if (j < len) {

                // run as long as the contiguos characters are same
                while ((s.charAt(j) == s.charAt(i))) {
                    count += 1;
                    j++;

                    // check if j is greater than the length
                    if (!(j < len)) {
                        break;
                    }
                }
            }

            // append the count and the digit to the string
            sn.append(count).append(s.charAt(i));

            // update i to skip all the repeated digits
            i = j;
        }
        return sn.toString();
    }
}
