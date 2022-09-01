/**
 * @author Pradip Sahoo
 * Created on 23/07/2022
 * ----------------------------
 * Check if Linked List is Palindrome.
 * Given a singly linked list of size N of integers. The task is to check if the
 * given linked list is palindrome or not.
 * 
 * Example 1:
 *  Input : N = 3
 *          value[] = {1,2,1}
 *  Output: 1
 *  Explanation: The given linked list is 1 2 1 , which is a palindrome and
 *  Hence, the output is 1.
 * 
 * Example 2:
 *  Input : N = 4
 *          value[] = {1,2,3,4}
 *  Output: 0
 *  Explanation: The given linked list is 1 2 3 4 , which is not a palindrome and
 *  Hence, the output is 0.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.LinkedList.Easy_Questions;

import java.util.Scanner;

public class Q11_PalindromicLinkedList {

    static Node headNode;
    static Node tailNode;
    static Node tempNode;

    // Node class for creating new nodes in linked list
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
        Q11_PalindromicLinkedList list = new Q11_PalindromicLinkedList();

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

    /**
     * Method to create new nodes in linked list
     * 
     * @param node
     */
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

    /**
     * Method to check wheather the list is palindrome or not
     * 
     * @param head
     * @return the result true/false
     */
    private static boolean is_palindrome(Node head) {

        /**
         * Base Case.
         * If single node present return true
         */
        if (head.nextNode == null) {
            return true;
        }

        // Store the content of head into a dummy node
        tempNode = head;

        // step - 1 [find the middle of the list]
        Node midNode = getMid(tempNode);

        // step -2 [reverse the next part of middle]
        Node temp = midNode.nextNode;
        midNode.nextNode = reverse_list(temp);

        // step -3 [compare both side]
        Node head1 = tempNode;
        Node head2 = midNode.nextNode;
        boolean res = is_Identical(head1, head2);

        // Step - 4 [Reverse the list to get its original form]
        temp = midNode.nextNode;
        midNode.nextNode = reverse_list(temp);

        // return the result
        return res;
    }

    /**
     * Method to find the middle of the list
     * 
     * @param head
     * @return the middle node
     */
    private static Node getMid(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.nextNode != null) {
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;
        }
        return slow;
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