/**
 * Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head.
 * 
 * Example 1:
 *  Input: head = [1->2->3->4->5], n = 2
 *  Output: [1->2->3->5]
 * 
 * Example 2:
 *  Input: head = [1], n = 1
 *  Output: []
 * 
 * Example 3:
 *  Input: head = [1->2], n = 1
 *  Output: [1]
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * ------------------------------------
 * @author  Pradip Sahoo
 * @since   08/06/2023
 */
package LinkedList;

import java.util.Scanner;

public class Q06_Remove_Nth_Node_From_End_Of_List {

    public class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    static Q06_Remove_Nth_Node_From_End_Of_List removeNthNode = new Q06_Remove_Nth_Node_From_End_Of_List();
    static Node headNode;
    static Node tempNode;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the list : ");
        int size = sc.nextInt();

        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < size; i++) {
            int val = sc.nextInt();
            Node hNode = removeNthNode.new Node(val);
            createNewNode(hNode);
        }

        System.out.print("Enter the position where you want to delete : ");
        int pos = sc.nextInt();

        System.out.print("The original list is : ");
        printList(headNode);

        removeNthNode(headNode, pos);

        sc.close();

        System.out.print("After removing the node the list is : ");
        printList(headNode);
    }

    /**
     * This method prints the elements of a linked list.
     * 
     * @param head The head of the linked list to be printed.
     */
    private static void printList(Node head) {

        // Set a temporary node to the head of the list
        tempNode = head;

        // Traverse the list and print each element
        while (tempNode != null) {
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.nextNode;
        }
        System.out.println("null");
    }

    /**
     * This method removes the node at the specified position in a linked list.
     * 
     * @param head The head of the linked list.
     * @param pos  The position of the node to remove.
     * @return The head of the updated linked list after removing the node.
     */
    private static Node removeNthNode(Node head, int pos) {

        /**
         ** Step 1: Check if the list is empty or the position is 0, indicating no
         ** removal needed
         */
        if (head == null || pos == 0) {
            return head;
        }

        /**
         ** Step 2: Initialize two pointers, 'fast' and 'slow', both starting from the
         ** head of the list
         */
        Node fast = head;
        Node slow = head;

        // * Step 3: Move the 'fast' pointer to the node at the specified position
        for (int i = 1; i <= pos; i++) {
            fast = fast.nextNode;
        }

        /**
         ** Step 4: If the 'fast' pointer becomes null, it means the position exceeds the
         ** list length. In this case, remove the fast node by updating the head and
         ** return it
         */
        if (fast == null) {
            return head.nextNode;
        }

        /**
         ** Step 5: Move both pointers until the 'fast' pointer reaches the end of the
         ** list
         */
        while (fast.nextNode != null) {
            fast = fast.nextNode;
            slow = slow.nextNode;
        }

        /**
         ** Step 6: Remove the node at the specified position by updating the 'slow'
         ** pointer's next node
         */
        slow.nextNode = slow.nextNode.nextNode;

        // * Step 7: Return the head of the updated linked list
        return head;
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
    }
}