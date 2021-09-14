/**
 * Check if Linked List is Palindrome.
 * Given a singly linked list of size N of integers. The task is to check if the given linked list is palindrome or not..
 * 
 * Example 1:
 *      Input: N = 3
 *             value[] = {1,2,1}
 *      Output: 1
 * Explanation: The given linked list is 1 2 1 , which is a palindrome and Hence, the output is 1.
 * 
 * Example 2:
 *      Input: N = 4
 *             value[] = {1,2,3,4}
 *      Output: 0
 * Explanation: The given linked list is 1 2 3 4 , which is not a palindrome and Hence, the output is 0.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class CheckSinglyLLPalindrome {

    static Node headNode;
    static Node tailNode;
    static Node tempNode;

    // Node class for creating Linked list
    class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    public static void main(String[] args) {

        // Create Scanner class to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the length of the Linked list
        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        CheckSinglyLLPalindrome list = new CheckSinglyLLPalindrome();

        // Ask user to enter the elements of the linked list
        System.out.println("Enter the elements of the linked list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = list.new Node(val);
            createNewNode(hNode);
        }

        sc.close();

        // Method call to print the whole list
        printLL();

        // Method call to check wheather the list is palindrome or not
        if (is_palindrome(headNode) == true) {
            System.out.println("Is Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }

    // Method to create new nodes in linked list
    private static void createNewNode(Node node) {

        // First time when the list is empty then create the headNode
        if (headNode == null) {
            headNode = node;
            return;
        }

        // Make headNode as tempNode
        tempNode = headNode;

        // Add other nodes in the list
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
    }

    // Method to check wheather the list is palindrome or not
    private static boolean is_palindrome(Node head) {

        // Declare a variable and initialize by 0
        int size = 0;
        tempNode = head;

        // Finding the number of nodes in the list
        while (tempNode != null) {
            size++;
            tempNode = tempNode.nextNode;
        }

        /**
         * If the size of the linked list is less than 2 then the linked list is
         * palindrome
         */
        if (size < 2) {
            return true;
        }

        // Store the address of the head in temp node
        tempNode = head;

        /**
         * now, we split list into 2 halves. In case of odd number of elements, first
         * half will have the middle element.
         */
        int mid = (size - 1) / 2;

        // Using a pointer to get to middle element element to get second half of list
        while (mid > 0) {
            tempNode = tempNode.nextNode;
            mid--;
        }

        /**
         * temp now holds address of the last element of first half Storing the element
         * of second half separately in head2
         */
        Node head2 = tempNode.nextNode;
        tempNode.nextNode = null;

        // Reverse the second half of list
        head2 = reverse_list(head2);

        /**
         * We check wheather both halves are identical or not (For odd number of
         * elements first half will have one extra element)
         */
        boolean res = is_Identical(head, head2);

        // Again reverse the second list and connect it to first half
        head2 = reverse_list(head2);
        tempNode.nextNode = head2;

        // returning true if the list is palindrome else false
        return res;
    }

    // Method to check wheather two list are identical or not
    private static boolean is_Identical(Node head1, Node head2) {

        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                return false;
            }
            head1 = head1.nextNode;
            head2 = head2.nextNode;
        }

        return true;
    }

    // Method to reverse the list
    private static Node reverse_list(Node head) {

        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Method to print the linked list
    private static void printLL() {

        tempNode = headNode;

        System.out.print("The output LL is : ");

        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.nextNode;
        }
        System.out.println();
    }
}