/**
 * @author Pradip Sahoo
 * Created on 06/04/2022
 * ---------------------------------
 * Given an array of size n and a number k, find all elements that appear more than n/k times.
 * 
 * Example :
 *  Input : n = 8
 *          arr[] = {3,1,2,2,1,2,3,3}
 *          k = 4
 *  Output : [2,3]
 *  Explaination : Size of the array is 8, and k = 4, so we need to find all the elements that appear 
 *                 more than 2(or 8/4) times. There are two elements that appear more than two times, 2 and 3.
 * 
 * Time complexity : O(N)
 * Space complexity : O(N)
 */
package Love_Babbar_DSA_Sheet.Array.Medium_Questions;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Q29_MoreThanNdk {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k : ");
        int k = sc.nextInt();

        sc.close();

        System.out.print("The elements are : ");
        findElements(arr, k);
    }

    private static void findElements(int[] arr, int k) {

        // Calculating n/k
        int x = arr.length / k;

        // Declare a Treemap
        TreeMap<Integer, Integer> tmap = new TreeMap<>();

        // Counting frequency of every element using counter
        for (int i = 0; i < arr.length; i++) {
            tmap.put(arr[i], tmap.getOrDefault(arr[i], 0) + 1);
        }

        /**
         * Traverse the map and print all the elements with concurrence more than n/k
         * times
         */
        for (Map.Entry<Integer, Integer> m : tmap.entrySet()) {
            if (m.getValue() > x) {
                System.out.print(m.getKey() + " ");
            }
        }
    }
}