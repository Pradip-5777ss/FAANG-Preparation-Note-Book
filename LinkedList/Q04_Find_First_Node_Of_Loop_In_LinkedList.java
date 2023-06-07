/**
 * Given the head of a linked list, return the node where the cycle begins. If
 * there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer. Internally, pos
 * is used to denote the index of the node that tail's next pointer is connected
 * to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as
 * a parameter.
 * Do not modify the linked list.
 * 
 * Example 1:
 *  Input: head = [3,2,0,-4], pos = 1
 *  Output: tail connects to node index 1
 *  Explanation: There is a cycle in the linked list, where tail connects to the
 *  second node.
 * 
 * Example 2:
 *  Input: head = [1,2], pos = 0
 *  Output: tail connects to node index 0
 *  Explanation: There is a cycle in the linked list, where tail connects to the
 *  first node.
 * 
 * Example 3:
 *  Input: head = [1], pos = -1
 *  Output: no cycle
 *  Explanation: There is no cycle in the linked list.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * -------------------------------------------------
 * @author  Pradip Sahoo
 * @since   08/06/2023
 */
package LinkedList;

import java.util.Scanner;

public class Q04_Find_First_Node_Of_Loop_In_LinkedList {
    
    public class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    static Q04_Find_First_Node_Of_Loop_In_LinkedList findFirstNode = new Q04_Find_First_Node_Of_Loop_In_LinkedList();
    static Node headNode;
    static Node tempNode;
    static Node tailNode;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the list : ");
        int size = sc.nextInt();

        System.out.println("Enter the elements of the list: ");
        for (int i = 0; i < size; i++) {
            int val = sc.nextInt();
            Node hNode = findFirstNode.new Node(val);
            createNewNode(hNode);
        }

        System.out.print("Enter the position of the node : ");
        int pos = sc.nextInt();

        sc.close();

        makeLoop(headNode, tailNode, pos);

        Node result = detectFirstNode(headNode);

        if (result == null) {
            System.out.println("Output: No Loop is detected");
        } else {
            System.out.println("Output: first node of the loop is: " + result.data);
        }
    }

    /**
     * This method detects the first node of a loop in a linked list using the
     * Floyd's cycle-finding algorithm.
     * 
     * @param head The head of the linked list.
     * @return The first node of the loop if a loop exists, otherwise null.
     */
    private static Node detectFirstNode(Node head) {

        /**
         ** Step 1: If the list is empty or has only one node, there cannot be a loop, so
         ** return null
         */
        if (head == null || head.nextNode == null) {
            return null;
        }

        // * Step 2: Initialize two pointers: slow and fast, both starting from the head
        Node slow = head;
        Node fast = head;

        /**
         ** Step 3: Move the slow pointer by one step and the fast pointer by two steps.
         ** If a loop exists, they will eventually meet at some point inside the loop
         */
        while (fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;

            /**
             ** If the slow and fast pointers meet, break the loop to indicate the presence
             ** of a loop
             */
            if (slow == fast) {
                break;
            }
        }

        /**
         ** Step 4: If the slow and fast pointers didn't meet, there is no loop, so
         ** return null
         */
        if (slow != fast) {
            return null;
        }

        /**
         ** Step 5: Reset the fast pointer to the head and move both pointers at the same
         ** pace They will meet at the first node of the loop
         */
        fast = head;
        while (fast != slow) {
            fast = fast.nextNode;
            slow = slow.nextNode;
        }

        // * Step 6: Return the first node of the loop
        return slow;
    }

    /**
     * This method creates a loop in a linked list by connecting the tail node to a
     * specific position in the list.
     * 
     * @param head The head of the linked list.
     * @param tail The tail of the linked list.
     * @param pos  The position at which the tail node should be connected to create
     *             the loop.
     */
    private static void makeLoop(Node head, Node tail, int pos) {

        // If the position is -1, there is no need to create a loop, so return
        if (pos == -1) {
            return;
        }

        // Set a temporary node to the head of the list
        tempNode = head;

        // Traverse the list until the node at the specified position is reached
        for (int i = 0; i < pos; i++) {
            tempNode = tempNode.nextNode;
        }

        // Connect the tail node to the node at the specified position, creating a loop
        tail.nextNode = tempNode;
    }

    /**
     * This method adds a new node to the end of a linked list.
     * 
     * @param node The node to be added
     */
    private static void createNewNode(Node node) {

        // If the list is empty, set the new node as the head and return
        if (headNode == null) {
            headNode = node;
            return;
        }

        // Set a temporary node to the head of the list
        tempNode = headNode;

        // Traverse the list until the last node is reached
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }

        // Add the new node as the next node of the last node in the list
        tempNode.nextNode = node;

        // Make the last node as tail node of the list
        tailNode = tempNode.nextNode;
    }
}