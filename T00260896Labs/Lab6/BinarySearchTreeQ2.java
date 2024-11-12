import java.util.Deque;
import java.util.LinkedList;

public class BinarySearchTreeQ2<E extends Comparable<E>> {
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

    public BinarySearchTreeQ2() {
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

    // Preorder traversal (root, left, right)
    public void printPreorder() {
        printPreorder(root);
    }

    private void printPreorder(Node node) {
        if (node != null) {
            System.out.println(node.data); // Visit node
            printPreorder(node.left); // Visit left subtree
            printPreorder(node.right); // Visit right subtree
        }
    }

    // Postorder traversal (left, right, root)
    public void printPostorder() {
        printPostorder(root);
    }

    private void printPostorder(Node node) {
        if (node != null) {
            printPostorder(node.left); // Visit left subtree
            printPostorder(node.right); // Visit right subtree
            System.out.println(node.data); // Visit node
        }
    }

    // Non-recursive inorder traversal (left, root, right)
    public void inorderTraversal() {
        Deque<Node> stack = new LinkedList<>();
        Node current = root;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current); // Push current to stack
                current = current.left; // Move to left child
            }
            current = stack.pop(); // Pop from stack
            System.out.println(current.data); // Visit node
            current = current.right; // Move to right child
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeQ2<Integer> bst = new BinarySearchTreeQ2<>();
        bst.insertIterative(10);
        bst.insertIterative(5);
        bst.insertIterative(15);
        bst.insertIterative(3);
        bst.insertIterative(7);
        bst.insertIterative(12);
        bst.insertIterative(18);

        System.out.println("Preorder Traversal:");
        bst.printPreorder();

        System.out.println("Postorder Traversal:");
        bst.printPostorder();

        System.out.println("Inorder Traversal:");
        bst.inorderTraversal();
    }
}
