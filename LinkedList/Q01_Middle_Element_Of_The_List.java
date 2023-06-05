/**
 ** Middle of the Linked List.
 * Write a program to find the middle element of a linked list. Given the head
 * of a singly linked list, return the middle node of the linked list. If there
 * are two middle nodes, return the second middle node.
 * 
 * Example 1:
 *  Input: head = [1->2->3->4->5]
 *  Output: 3
 *  Explanation: The middle node of the list is node 3.
 * 
 * Example 2:
 *  Input: head = [1->2->3->4->5->6]
 *  Output: 4
 *  Explanation: Since the list has two middle nodes with values 3 and 4, we
 *  return the second one.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * -----------------------------------------------------
 * @author  Pradip Sahoo
 * @since   05/06/2023
 */
package LinkedList;

import java.util.Scanner;

public class Q01_Middle_Element_Of_The_List {

    public class Node {

        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    static Q01_Middle_Element_Of_The_List midElement = new Q01_Middle_Element_Of_The_List();
    static Node headNode;
    static Node tempNode;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the list : ");
        int size = sc.nextInt();

        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < size; i++) {
            int data = sc.nextInt();
            Node hNode = midElement.new Node(data);
            createNewNode(hNode);
        }

        sc.close();

        System.out.println("The Middle element of the list is : " + findMiddleElement(headNode));
    }

    /**
     * Method to find the middle element of the linked list
     * 
     * @param head
     * @return the middle element of the list
     */
    private static int findMiddleElement(Node head) {

        /**
         ** Step 1: Create two pointers slow and fast and initialize them to a head
         ** pointer.
         */
        Node fast = head;
        Node slow = head;

        /**
         ** Step 2: Move slow ptr by one step and simultaneously fast ptr by two steps
         ** until fast ptr is NULL or next of fast ptr is NULL.
         */
        while (fast != null && fast.nextNode != null) {
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;
        }

        /**
         ** Step 3: When the above condition is met, we can see that the slow ptr is
         ** pointing towards the middle of the Linked List and hence we can return the
         ** slow pointer.
         */
        return slow.data;
    }

    /**
     * Method to create new node in the linked list
     * 
     * @param node
     */
    private static void createNewNode(Node node) {

        /**
         * Initially the list is empty. so, create the headnode
         */
        if (headNode == null) {
            headNode = node;
            return;
        }

        // Initialize the headnode as tempnode
        tempNode = headNode;

        /**
         * Add other nodes in the list
         */
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
    }
}