/**
 * @author Pradip Sahoo
 * Created on 09/04/2022
 * ---------------------------
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 *  Input: l1 = [2,4,3], l2 = [5,6,4]
 *  Output: [7,0,8]
 *  Explanation: 342 + 465 = 807.
 * 
 * Example 2:
 *  Input: l1 = [0], l2 = [0]
 *  Output: [0]
 * 
 * Example 3:
 *  Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 *  Output: [8,9,9,9,0,0,0,1]
 */
package Leetcode_Questions.Medium_Questions;

import java.util.Scanner;

public class Q2_AddTwoNumbers {

    static Node firstList;
    static Node secondList;
    static Node tail;

    // Class for creating node
    public class Node {

        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    static Q2_AddTwoNumbers addTwoNumbers = new Q2_AddTwoNumbers();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of first list : ");
        int len_1 = sc.nextInt();

        System.out.println("Enter the elements of first list : ");
        int val_1 = sc.nextInt();

        firstList = addTwoNumbers.new Node(val_1);
        tail = firstList;

        for (int i = 1; i < len_1; i++) {
            val_1 = sc.nextInt();
            tail.nextNode = addTwoNumbers.new Node(val_1);
            tail = tail.nextNode;
        }

        System.out.print("Enter the length of second list : ");
        int len_2 = sc.nextInt();

        System.out.println("Enter the elements of second list : ");
        int val_2 = sc.nextInt();

        secondList = addTwoNumbers.new Node(val_2);
        tail = secondList;

        for (int i = 1; i < len_2; i++) {
            val_2 = sc.nextInt();
            tail.nextNode = addTwoNumbers.new Node(val_2);
            tail = tail.nextNode;
        }

        sc.close();

        Node res = addTwoList(firstList, secondList);

        System.out.print("The new list is : ");
        printList(res);
    }

    private static Node addTwoList(Node firstList, Node secondList) {

        // creating an dummy list
        Node dummy = addTwoNumbers.new Node(0);

        // intialising an pointer
        Node curr = dummy;

        // intialising our carry with 0 intiall
        int carry = 0;

        /**
         * while loop will run, until l1 OR l2 not reaches null OR if they both reaches
         * null. But our carry has some value in it.
         * We will add that as well into our list
         */
        while (firstList != null || secondList != null || carry == 1) {

            // intialising our sum
            int sum = 0;

            // adding firstList to our sum & moving firstList
            if (firstList != null) {
                sum += firstList.data;
                firstList = firstList.nextNode;
            }

            // adding secondList to our sum & moving secondList
            if (secondList != null) {
                sum += secondList.data;
                secondList = secondList.nextNode;
            }

            // if we have carry then add it into our sum
            sum += carry;

            // if we get carry, then divide it by 10 to get the carry
            carry = sum / 10;

            /**
             * the value we'll get by moduloing it, will become as new node so. add it to
             * our list
             */
            Node node = addTwoNumbers.new Node(sum % 10);

            // curr will point to that new node if we get
            curr.nextNode = node;

            // update the current every time
            curr = curr.nextNode;
        }

        /**
         * return dummy.next bcz, we don't want the value we have consider in it
         * intially!!
         */
        return dummy.nextNode;
    }

    // Method to print the list
    private static void printList(Node node) {

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.nextNode;
        }
        System.out.println();
    }
}