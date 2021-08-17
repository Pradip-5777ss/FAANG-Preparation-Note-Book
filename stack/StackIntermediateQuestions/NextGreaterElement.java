/**
 * Write a program to find Next Greater Element in an array.
 * 
 * Given an array arr[ ] of size N having distinct elements, the task is to find
 * the next greater element for each element of the array in order of their appearance in the array.
 * Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
 * If there does not exist next greater of current element, then next greater element for current element is -1. 
 * For example, next greater of the last element is always -1.
 * 
 * Example :
 *      Input: N = 4, arr[] = [1 3 2 4]
 *      Output: 3 4 4 -1
 * 
 * Explanation: In the array, the next larger element to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? 
 * since it doesn't exist, it is -1.
 */
package stack.StackIntermediateQuestions;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {

        // Create scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        int arr[] = new int[size];

        // Ask user to enter the array elements
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        // Method call to find the next greater element in the array
        int ans[] = nextLargerElement(arr, size);

        // Method call to print the output array
        System.out.print("The output array is : ");
        printArr(ans);
    }

    private static void printArr(int[] ans) {

        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Method to find the next greater element for each element of the array
     * 
     * @param arr
     * @param size
     * @return the array with next greater element
     */
    private static int[] nextLargerElement(int[] arr, int size) {

        Stack<Integer> st = new Stack<>();
        int res[] = new int[size];

        // traversing the array from last element in backward direction
        for (int i = size - 1; i >= 0; i--) {

            if (!st.empty()) {

                /**
                 * while element at top of stack is less than or equal to current array element,
                 * we pop elements from the stack.
                 */
                while (!st.empty() && st.peek() < arr[i]) {
                    st.pop();
                }
            }

            /**
             * if stack becomes empty, we store -1 in the answer list else we store the top
             * element of the stack.
             */
            res[i] = st.empty() ? -1 : st.peek();

            // Pushing the current array element into the stack
            st.push(arr[i]);
        }

        // Return the list
        return res;
    }
}