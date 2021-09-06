/**
 * Given a sorted array arr containing n elements with possibly 
 * duplicate elements, the task is to find indexes of first and 
 * last occurrences of an element x in the given array.
 * 
 * Example :
 *      Input:  n=9, x=5
 *      arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
 *      
 *      Output:  [2, 5]
 * Explanation: First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5. 
 */
package SearchingAndSorting.EasyQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class FirstAndLastOccurenceOfx {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        int arr[] = new int[size];

        // Ask user to enter the array elements
        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Ask user to enter the element to find the occurance
        System.out.println("Enter the element : ");
        int x = sc.nextInt();

        sc.close();

        // Method call to find the occurence and print the result
        ArrayList<Integer> ans = findOccurence(arr, x);
        System.out.println("The output is : " + ans);
    }

    // Method to find the occurence
    private static ArrayList<Integer> findOccurence(int[] arr, int x) {

        // Declare the Arraylist
        ArrayList<Integer> res = new ArrayList<>();

        // Find the size of the array
        int n = arr.length;

        // Declare variables
        int low = 0, high = n - 1, mid = 0, temp = -1;

        // Add -1 to the arraylist
        res.add(-1);
        res.add(-1);

        /**
         * In this method we divide the array into 2 halfs. In first loop we check the
         * 1st half of the array and find the starting point of x.
         */
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == x) {
                temp = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Set the first position into the ArrayList
        res.set(0, temp);

        // Again initialize the variables
        low = 0;
        high = n - 1;
        temp = -1;

        /**
         * In this loop we check the 2nd part of the array and find the second part of
         * the array.
         */
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == x) {
                temp = mid;
                low = mid + 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Set the second position into the ArrayList
        res.set(1, temp);

        // Return the result
        return res;
    }
}