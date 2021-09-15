/**
 * Remove loop in Linked List.
 * Given a linked list of N nodes such that it may contain a loop. 
 * Remove the loop from the linked list, if it is present.
 * 
 * Example 1:
 *      Input:  N = 3
 *              value[] = {1,3,4}
 *              X = 2
 *      Output: 1
 * Explanation: The link list looks like 1 -> 3 -> 4, the nextNode of 4 is connected 
 * to 3 A loop is present. If you remove it successfully, the answer will be 1.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package LinkedList.IntermediateQuestions;

import java.util.HashSet;
import java.util.Scanner;

public class DeleteLoopInLL {

    static Node headNode;
    static Node tempNode;
    static Node tailNode;

    // Node class for creating Linked List
    class Node {

        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the length of the linked list
        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        DeleteLoopInLL dLoopInLL = new DeleteLoopInLL();

        // Ask user to enter the elements of the linked list
        System.out.println("Enter the elements of the linked list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = dLoopInLL.new Node(val);
            createNewNode(hNode);
        }

        // Ask user to enter the position of the node for create the loop
        System.out.print("Enter the position of the node : ");
        int pos = sc.nextInt();

        // Method call for make the loop in the linked list
        makeLoop(headNode, tailNode, pos);

        sc.close();

        // Method to remove the loop in the linked list
        if (deleteLoop(headNode)) {
            System.out.println("Loop deleted");
        } else {
            System.out.println("Loop not deleted");
        }
    }

    // Method to create new node in the list
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
        tailNode = tempNode.nextNode;
    }

    // Method to create the loop in the linked list
    private static void makeLoop(Node head, Node tail, int pos) {

        if (pos == 0) {
            return;
        }

        tempNode = head;

        for (int i = 1; i < pos; i++) {
            tempNode = tempNode.nextNode;
        }
        tail.nextNode = tempNode;
    }

    /**
     * Method to remove loop from the linked list
     * 
     * @param head
     * @return true if the loop is removed else @return false.
     */
    private static boolean deleteLoop(Node head) {

        // Create a new HashSet
        HashSet<Node> hs = new HashSet<>();
        Node prev = null;

        while (head != null) {

            /**
             * If we have already has this node in hashmap it means their is a cycle and we
             * need to remove this cycle so set the next of the previous pointer with null.
             */
            if (hs.contains(head)) {
                prev.nextNode = null;
                return true;
            }
            /**
             * If we see the node for the first time, insert it in HashSet
             */
            else {
                hs.add(head);
                prev = head;
                head = head.nextNode;
            }
        }
        return false;
    }
}