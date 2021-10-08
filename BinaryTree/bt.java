package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BTNode {

    BTNode left, right;
    int data;

    public BTNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

class Operations {

    private BTNode root;

    public Operations() {
        this.root = null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private BTNode insert(BTNode node, int data) {

        if (node == null) {
            node = new BTNode(data);
        } else {
            if (data < node.getData()) {
                node.left = insert(node.left, data);
            } else if (data > node.getData()) {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(BTNode root) {

        int count = 1;
        if (root == null) {
            return 0;
        } else {
            count += countNodes(root.getLeft());
            count += countNodes(root.getRight());
        }
        return count;
    }

    public boolean searchNode(int data) {
        return searchNode(root, data);
    }

    private boolean searchNode(BTNode root, int data) {
        if (root.getData() == data) {
            return true;
        }
        if (root.getLeft() != null) {
            if (searchNode(root.getLeft(), data)) {
                return true;
            }
        }
        if (root.getRight() != null) {
            if (searchNode(root.getRight(), data)) {
                return true;
            }
        }
        return false;
    }

    public BTNode deleteNode(int data) {
        return deleteNode(root, data);
    }

    private BTNode deleteNode(BTNode root, int data) {

        if (root == null) {
            return null;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            if (root.getData() == data) {
                return null;
            } else {
                return root;
            }
        }

        BTNode key_node = null;
        BTNode temp = null;
        BTNode last = null;
        Queue<BTNode> q = new LinkedList<BTNode>();
        q.add(root);

        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.getData() == data) {
                key_node = temp;
            }
            if (temp.getLeft() != null) {
                last = temp;
                q.add(temp.left);
            }
            if (temp.getRight() != null) {
                last = temp;
                q.add(temp.right);
            }
        }

        if (key_node != null) {
            key_node.data = temp.data;
            if (last.right == temp) {
                last.right = null;
            } else {
                last.left = null;
            }
            deleteNode(temp, data);
        }
        return root;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(BTNode root) {
        if (root != null) {
            inorder(root.getLeft());
            System.out.print(root.getData() + " ");
            inorder(root.getRight());
        }
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(BTNode root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(BTNode root) {
        if (root != null) {
            postorder(root.getLeft());
            postorder(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }
}

public class bt {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the no of nodes : ");
        int n = sc.nextInt();

        // bt b = new bt();
        Operations op = new Operations();

        for (int i = 0; i < n; i++) {
            op.insert(sc.nextInt());
        }

        System.out.println("The nodes are present in the tree are : " + op.countNodes());

        System.out.print("Enter the element to find in the tree : ");
        if (op.searchNode(sc.nextInt()) == true) {
            System.out.println("The node is found");
        } else {
            System.out.println("The node is not found");
        }

        System.out.print("Inorder traversal : ");
        op.inorder();

        System.out.print("\nPreorder traversal : ");
        op.preorder();

        System.out.print("\nPostorder traversal : ");
        op.postorder();

        System.out.println("Enter the node which want to delete : ");
        int key = sc.nextInt();
        op.deleteNode(key);

        System.out.print("Inorder traversal after delete : ");
        op.inorder();

        sc.close();
    }
}
