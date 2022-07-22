/**
 * @author Pradip Sahoo
 * Created on 21/07/2022
 * ---------------------------------
 * Detect Loop in linked list.
 * Write a program to detect loop in a linked list. Given a linked list of N
 * nodes.
 * The task is to check if the linked list has a loop. Linked list can contain
 * self loop.
 * 
 * Example 1:
 *  Input: N = 3
 *         value[] = {1,3,4}
 *         x = 2
 *  Output: True
 *  Explanation: In this example N = 3. The linked list with nodes N = 3 is
 *  given. Then value of x=2 is given which means last node is connected with xth
 *  node of linked list. Therefore, there exists a loop.
 * 
 * Example 2:
 *  Input: N = 4
 *         value[] = {1,8,3,4}
 *         x = 0
 *  Output: False
 *  Explanation: For N = 4 ,x = 0 means then lastNode->next = NULL, then the
 *  Linked list does not contains any loop.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.LinkedList.Easy_Questions;

import java.util.Scanner;

public class Q01_DetectLoopInLL {

    static Node headNode;
    static Node tempNode;
    static Node tailNode;

    // Node class for creating new nodes in Linked List
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
        Q01_DetectLoopInLL dLoopInLL = new Q01_DetectLoopInLL();

        System.out.println("Enter the elements of the linked list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = dLoopInLL.new Node(val);
            createNewNode(hNode);
        }

        // Ask user to enter the position of the node for create the loop
        System.out.print("Enter the position of the node : ");
        int pos = sc.nextInt();

        // Method call for make the loop on Linked List
        makeLoop(headNode, tailNode, pos);

        sc.close();

        /**
         * Method call to detect the loop in the linked list. If the loop is detected
         * then it returns true else false.
         */
        System.out.print("Output : ");
        if (detectLoop(headNode)) {
            System.out.println("Loop detected");
        } else {
            System.out.println("Loop not detected");
        }
    }

    // Method to create new nodes in the list
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

    /**
     * Method to create the loop in the linked list
     * 
     * @param head
     * @param tail
     * @param pos
     */
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
     * Method to check the loop in the linked list. We use Floyd's cycle finding
     * algorithm
     * 
     * @param head
     * @return true or false
     */
    private static boolean detectLoop(Node head) {

        // Using two pointer's initially both are pointed to the head node
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.nextNode != null) {

            /**
             * moving one pointer(slow) by one node and another pointer(fast) by two nodes
             * in each iteration.
             */
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;

            // If both nodes are at same position then returns true
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}