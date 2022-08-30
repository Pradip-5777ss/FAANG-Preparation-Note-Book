/**
 * @author Pradip Sahoo
 * Created on 22/07/2022
 * ----------------------------
 * Add “1” to a number represented as a Linked List.
 * A number N is represented in Linked List such that each digit corresponds
 * to a node in linked list. You need to add 1 to it.
 * 
 * Example 1:
 *  Input: LinkedList: 4->5->6
 *  Output: 457
 * 
 * Example 2:
 *  Input: LinkedList: 1->2->3
 *  Output: 124
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.LinkedList.Easy_Questions;

import java.util.Scanner;

public class Q05_AddOneToRepresentLL {

    static Node tempNode;
    static Node headNode;

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
    static Q05_AddOneToRepresentLL aLl = new Q05_AddOneToRepresentLL();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = aLl.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        // Method call to add 1 with the list
        headNode = addOne(headNode);

        // Method call to print the list
        System.out.print("The list is : ");
        printList();
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

        // Make headNode as tempNode
        tempNode = headNode;

        // Add other nodes in the list
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
    }

    /**
     * Method to add one with the list
     * 
     * @param head
     * @return
     */
    private static Node addOne(Node head) {

        // Reverse the list to make addition easy
        head = reverse(head);

        // Initialize the head node value in temp
        tempNode = head;

        // Traverse through the list
        while (tempNode != null) {

            // Adding one to current node
            tempNode.data++;

            /**
             * If this condition is true, it means no carry present in the list. so, we can
             * reverse back the list and return it
             */
            if (tempNode.data < 10) {
                return reverse(head);
            }
            /**
             * else, we continue tracking carry for forward. Make the tempnode data as null.
             */
            else {
                tempNode.data = 0;
            }

            // If end of list, we break loop
            if (tempNode.nextNode == null) {
                break;
            }

            // else, we move to the next node
            else {
                tempNode = tempNode.nextNode;
            }
        }

        // Adding new node for carried 1
        tempNode.nextNode = aLl.new Node(1);
        return reverse(head);
    }

    /**
     * Method to reverse the list
     * 
     * @param head
     * @return the reverse list
     */
    private static Node reverse(Node head) {

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

    // Method to print the list
    private static void printList() {
        tempNode = headNode;

        while (tempNode != null) {
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.nextNode;
        }
        System.out.println("Null");
    }
}