import java.util.Deque;
import java.util.LinkedList;

public class BinarySearchTreeQ1<E extends Comparable<E>> {
    private class Node {
        public E data;
        public Node left;
        public Node right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTreeQ1() {
        root = null;
    }

    // Iterative insert method
    public void insertIterative(E element) {
        Node newNode = new Node(element);

        if (root == null) {
            root = newNode; // If tree is empty, set root to newNode
        } else {
            Node current = root;
            Node parent = null;

            while (true) {
                parent = current;
                int result = newNode.data.compareTo(current.data);

                if (result < 0) {
                    current = current.left; // Go left
                    if (current == null) {
                        parent.left = newNode; // Insert newNode as left child
                        return;
                    }
                } else {
                    current = current.right; // Go right
                    if (current == null) {
                        parent.right = newNode; // Insert newNode as right child
                        return;
                    }
                }
            }
        }
    }

    // Check if the tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Check if the tree contains a specific element
    public boolean contains(E element) {
        Node current = root;
        while (current != null) {
            int result = element.compareTo(current.data);
            if (result == 0) {
                return true; // Element found
            } else if (result < 0) {
                current = current.left; // Search left
            } else {
                current = current.right; // Search right
            }
        }
        return false; // Element not found
    }

    // Preorder traversal
    private void printPreorder(Node node) {
        if (node != null) {
            System.out.println(node.data); // Visit node
            printPreorder(node.left); // Visit left subtree
            printPreorder(node.right); // Visit right subtree
        }
    }

    // Postorder traversal
    private void printPostorder(Node node) {
        if (node != null) {
            printPostorder(node.left); // Visit left subtree
            printPostorder(node.right); // Visit right subtree
            System.out.println(node.data); // Visit node
        }
    }

    // Method to start preorder traversal
    public void preorder() {
        printPreorder(root);
    }

    // Method to start postorder traversal
    public void postorder() {
        printPostorder(root);
    }

    public static void main(String[] args) {
        BinarySearchTreeQ1<Integer> bst = new BinarySearchTreeQ1<>();
        bst.insertIterative(10);
        bst.insertIterative(5);
        bst.insertIterative(15);

        System.out.println("Preorder Traversal:");
        bst.preorder();

        System.out.println("Postorder Traversal:");
        bst.postorder();
    }
}
