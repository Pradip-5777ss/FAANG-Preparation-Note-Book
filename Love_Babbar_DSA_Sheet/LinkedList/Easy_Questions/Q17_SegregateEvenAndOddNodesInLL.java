/**
 * @author Pradip Sahoo
 * Created on 23/07/2022
 * -------------------------
 * Write a program to segregate even and odd nodes in a linked list.
 * Given a link list of size N, modify the list such that all the even numbers
 * appear before all the odd numbers in the modified list. The order of
 * appearance of numbers within each segregation should be same as that in the
 * original list.
 * 
 * Example:
 *  Input : N = 7
 *          Link List = 17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6 -> NULL
 *  Output : 8 2 4 6 17 15 9
 *  Explaination : 8,2,4,6 are the even numbers so they appear first and 17,15,9
 *  are odd so they appear after the even number.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.LinkedList.Easy_Questions;

import java.util.Scanner;

public class Q17_SegregateEvenAndOddNodesInLL {

    static Node headNode;
    static Node tempNode;

    // Node class for creating linked list
    class Node {

        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        Q17_SegregateEvenAndOddNodesInLL sEvenAndOdd = new Q17_SegregateEvenAndOddNodesInLL();

        // Ask user to enter the elements of the linked list
        System.out.println("Enter the elements of the linked list : ");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = sEvenAndOdd.new Node(val);
            createNewNode(hNode);
        }

        sc.close();

        // Method call to print the general list
        System.out.print("The general list is : ");
        printList();

        // Method call to arrange the linked list
        segregateEvenOdd();

        // Method call to print the linked list after arrangement
        System.out.print("After arranging the list is : ");
        printList();
    }

    /**
     * Method to create new nodes in the list
     * 
     * @param node
     */
    private static void createNewNode(Node node) {

        // First time when the list is empty then create the headNode
        if (headNode == null) {
            headNode = node;
            return;
        }

        // Make the headNode as tempNode
        tempNode = headNode;

        // Add other nodes in the list
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
    }

    // Method to segregate the list
    private static void segregateEvenOdd() {

        // Declare Nodes to store even numbers
        Node evenStart = null;
        Node evenEnd = null;

        // Declare Nodes to store odd numbers
        Node oddStart = null;
        Node oddEnd = null;

        // Declare Node to store the headNode
        Node curr = headNode;

        // Traverse through the whole list
        while (curr != null) {

            // Declare a variable to store the current node data
            int element = curr.data;

            // If the current node data is even then store that particular node in evenNode
            if (element % 2 == 0) {
                if (evenStart == null) {
                    evenStart = curr;
                    evenEnd = evenStart;
                } else {
                    evenEnd.nextNode = curr;
                    evenEnd = evenEnd.nextNode;
                }
            }

            // Else, store the particular node in oddNode
            else {
                if (oddStart == null) {
                    oddStart = curr;
                    oddEnd = oddStart;
                } else {
                    oddEnd.nextNode = curr;
                    oddEnd = oddEnd.nextNode;
                }
            }

            // Move the head pointer
            curr = curr.nextNode;
        }

        // If both the even and odd Node is null then return
        if (evenStart == null || oddStart == null) {
            return;
        }

        /**
         * Store the oddNode as the nextNode of evenNode and make the nextNode of
         * oddNode as null
         */
        evenEnd.nextNode = oddStart;
        oddEnd.nextNode = null;

        // Finally, make the evenNode as headNode.
        headNode = evenStart;
    }

    // Method to print the linked list
    private static void printList() {

        tempNode = headNode;

        while (tempNode != null) {
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.nextNode;
        }
        System.out.println("null");
    }
}