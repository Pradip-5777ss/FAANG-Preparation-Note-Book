/**
 * Delete without head pointer.
 * 
 * You are given a pointer/ reference to the node which is to be deleted from the linked list of N nodes. 
 * The task is to delete the node. Pointer/ reference to head node is not given. 
 * Note: No head reference is given to you. It is guaranteed that the node to be deleted is not a tail 
 * node in the linked list.
 * 
 * Example 1:
 *  Input:
 *      N = 2
 *      value[] = {1,2}
 *      node = 1
 *  Output: 2
 *  Explanation: After deleting 1 from the linked list, we have remaining nodes as 2.
 * 
 * Example 2:
 *  Input:
 *      N = 4
 *      value[] = {10,20,4,30}
 *      node = 20
 *  Output: 10 4 30
 *  Explanation: After deleting 20 from the linked list, we have remaining nodes as 10, 4 and 30.
 * 
 * Time Complexity : O(1)
 * Auxilliary Space : O(1)
 */
package LinkedList.EasyQuestions;

import java.util.Scanner;

public class DeleteWithoutHeadPointer {

    static Node headNode;
    static Node tailNode;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Create obeject of the class
    static DeleteWithoutHeadPointer deleteWithoutHeadPointer = new DeleteWithoutHeadPointer();

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the length of the linked list
        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node node = deleteWithoutHeadPointer.new Node(val);
            createNewNode(node);
        }

        // Ask user to enter the key node which we want to delete from the list
        System.out.print("Enter the key node which we want to delete : ");
        int key = sc.nextInt();

        // Method call to find that the node is present in the list or not
        Node delNode = searchNodeForDelete(headNode, key);

        sc.close();

        // Method call to delete the node
        if (delNode != null && delNode.next != null) {
            deleteNode(delNode);
        }

        // Print the nodes after delete the key node
        System.out.print("The list after delete the key : ");
        printList(headNode);
    }

    // Method to print the list
    private static void printList(Node headNode) {

        Node current = headNode;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to delete the particular node from the list
    private static void deleteNode(Node delNode) {

        // Store the keyNode's nextNode data into the keyNode
        delNode.data = delNode.next.data;

        // Store the value of next of the next of keyNode into keyNode's nextNode
        delNode.next = delNode.next.next;
    }

    // Method to find that the given key node is present in the list or not
    private static Node searchNodeForDelete(Node headNode, int key) {

        Node current = headNode;

        while (current != null) {

            // If the data matches then break the loop
            if (current.data == key) {
                break;
            }
            current = current.next;
        }

        return current;
    }

    // Method to create new nodes in the list
    private static void createNewNode(Node node) {

        /**
         * If the headNode of the list is null then make the newNode as the headNode and
         * return it.
         */
        if (headNode == null) {
            headNode = node;
            return;
        }

        // Store the headNode value in tailNode
        tailNode = headNode;

        // Add other nodes in the list
        while (tailNode.next != null) {
            tailNode = tailNode.next;
        }
        tailNode.next = node;
    }
}