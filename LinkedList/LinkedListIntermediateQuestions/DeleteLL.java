/**
 * Write a function to delete the Linked List.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class DeleteLL {
    
   static Node headNode;
   static Node tempNode;

    public class Node {
    
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    public static void main(String[] args) {
        
        //  Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        //  Ask user to enter the length of the linked list
        System.out.println("Enter the length of the linked list : ");
        int length = sc.nextInt();

        //  Create the object of the class
        DeleteLL dLl = new DeleteLL();

        //  Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = dLl.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        //  Print the general list
        System.out.print("The general list is : ");
        printList();

        //  Method call to delete the list
        System.out.println("Deleting the list...");
        deleteList();        
    }

    //  Method to delete the list
    private static void deleteList() {

        //  Assign the null value in headnode & the list will be deleted
        headNode = null;

        System.out.println("List deleted");
    }

    //  Method to print the list
    private static void printList() {

        tempNode = headNode;

        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.nextNode;
        }
        System.out.println();
    }

    //  Method to add elements in the list
    private static void createNewNode(Node node) {
        if (headNode == null) {
            headNode = node;
            return;
        }

        tempNode = headNode;

        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
    }
}
