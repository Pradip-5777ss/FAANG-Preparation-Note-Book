package String.StringBasicQuestions;

import java.util.Scanner;

public class TwoStringsAreAnagramOrNot {

    static int No_Of_Char = 256;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first string : ");
        String str1 = sc.nextLine();
        char ch1[] = str1.toCharArray();

        System.out.println("Enter the second string : ");
        String str2 = sc.nextLine();
        char ch2[] = str2.toCharArray();

        boolean isAnagram = checkAnagram(ch1, ch2);

        if (isAnagram) {
            System.out.println("these Two strings are anagram to each other");
        } else {
            System.out.println("These two strings are not anagram to each other");
        }
    }

    private static boolean checkAnagram(char[] ch1, char[] ch2) {

        int count[] = new int[No_Of_Char];
        int i;

        for ( i = 0; i < ch1.length; i++) {
            count[ch1[i] - 'a']++;
            count[ch2[i] - 'a']--;
        }

        if (ch1.length != ch2.length) {
            return false;
        }

        for ( i = 0; i < No_Of_Char; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
