/**
 * @author Pradip Sahoo
 * Created on 23/07/2022
 * -------------------------
 * Given a linked list of 0s, 1s and 2s, sort it.
 * Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s
 * only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros
 * segregate to head side, 2s at the end of the linked list, and 1s in the mid
 * of 0s and 2s.
 * 
 * Example:
 *  Input : N = 8
 *          value[] = {1,2,2,1,2,0,2,2}
 *  Output: 0 1 1 2 2 2 2 2
 *  Explanation: All the 0s are segregated to the left end of the linked list, 2s
 *  to the right end of the list, and 1s in between.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.LinkedList.Easy_Questions;

import java.util.Scanner;

public class Q16_SegregateZeroOneAndTwo {

    static Node headNode;
    static Node tempNode;

    // Node class for creating new nodes in Linked List
    class Node {

        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    // Create object of the class
    static Q16_SegregateZeroOneAndTwo sZeroOneAndTwo = new Q16_SegregateZeroOneAndTwo();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = sZeroOneAndTwo.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        // Method call to sort the list of 0s, 1s, 2s
        headNode = segregate(headNode);

        // Method call to print the linked list
        System.out.print("After sorting the list is : ");
        printList(headNode);
    }

    /**
     * Method to create new node in the list
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

    /**
     * Method to sort a linked list of 0s, 1s and 2s
     * 
     * @param head
     * @return
     */
    private static Node segregate(Node head) {

        if (head == null || head.nextNode == null) {
            return head;
        }

        // Create dummy nodes to point to the beginning of the linked list
        Node zeroD = sZeroOneAndTwo.new Node(0);
        Node oneD = sZeroOneAndTwo.new Node(0);
        Node twoD = sZeroOneAndTwo.new Node(0);

        // Initialize current pointers for three lists
        Node zero = zeroD, one = oneD, two = twoD;
        Node curr = head;

        // Traversing over the list with a pointer
        while (curr != null) {

            /**
             * We check data at current node and store the node in it's respective list and
             * update the link part of that list
             */
            if (curr.data == 0) {
                zero.nextNode = curr;
                zero = zero.nextNode;
                curr = curr.nextNode;
            } else if (curr.data == 1) {
                one.nextNode = curr;
                one = one.nextNode;
                curr = curr.nextNode;
            } else {
                two.nextNode = curr;
                two = two.nextNode;
                curr = curr.nextNode;
            }
        }

        // Attaching all three lists containing 0s, 1s, 2s respectively
        zero.nextNode = (oneD.nextNode != null) ? (oneD.nextNode) : (twoD.nextNode);
        one.nextNode = twoD.nextNode;
        two.nextNode = null;

        // Updataing the head of the list
        head = zeroD.nextNode;
        return head;
    }

    // Method to print the list
    private static void printList(Node head) {

        if (head == null) {
            return;
        }
        tempNode = head;

        while (tempNode != null) {
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.nextNode;
        }
        System.out.println("null");
    }
}