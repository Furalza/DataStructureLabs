import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of links with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
 */
public class Lab2<E> {
    // Node inner class representing a node in the linked list
    private class Node {
        public E data; // Data stored in the node
        public Node next; // Reference to the next node
        public Node prev; // Reference to the previous node (for doubly linked list)
    }

    private Node first; // Reference to the first node in the list
    private Node last; // Reference to the last node in the list (for queue operations)

    /**
     * Constructs an empty linked list.
     */
    public Lab2() {
        first = null;
        last = null;
    }

    /**
     * Adds an element to the front of the linked list.
     * 
     * @param element the element to add
     */
    public void addFirst(E element) {
        Node newLink = new Node();
        newLink.data = element;
        newLink.next = first; // Link new node to the current first node
        newLink.prev = null; // New first node has no previous node

        if (first != null) {
            first.prev = newLink; // Update previous first node's previous reference
        }

        first = newLink; // Update first to the new node

        if (last == null) { // If the list was empty
            last = newLink; // last should also point to the new node
        }
    }

    /**
     * Adds an element to the end of the linked list (for queue functionality).
     * 
     * @param element the element to add
     */
    public void addLast(E element) {
        Node newLink = new Node();
        newLink.data = element;
        newLink.next = null; // New last node has no next node

        if (last == null) { // If the list is empty
            first = newLink; // New node is now the first node
            newLink.prev = null; // No previous node
        } else {
            last.next = newLink; // Link the new node at the end
            newLink.prev = last; // Set the previous node
        }

        last = newLink; // Update last to new node
    }

    /**
     * Gets the first element in the linked list.
     * 
     * @return the first element
     * @throws NoSuchElementException if the list is empty
     */
    public E getFirst() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        return first.data;
    }

    /**
     * Removes the first element in the linked list.
     * 
     * @return the removed element
     * @throws NoSuchElementException if the list is empty
     */
    public E removeFirst() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        E element = first.data;
        first = first.next; // Move first to the next node
        if (first != null) {
            first.prev = null; // Set the previous of the new first node to null
        } else {
            last = null; // If the list is now empty, update last to null
        }
        return element;
    }

    /**
     * Calculates the size of the linked list.
     * 
     * @return the number of elements in the list
     */
    public int size() {
        int count = 0;
        Node current = first; // Start from the first node
        while (current != null) {
            count++;
            current = current.next; // Move to the next node
        }
        return count; // Return the total count
    }

    /**
     * Checks if the list contains a particular value.
     * 
     * @param value the value to check for
     * @return true if the value is found, false otherwise
     */
    public boolean contains(E value) {
        Node current = first; // Start from the first node
        while (current != null) {
            if (current.data.equals(value)) { // Check if the current node's data matches the value
                return true; // Value found
            }
            current = current.next; // Move to the next node
        }
        return false; // Value not found
    }

    /**
     * Outputs the data in the list.
     */
    public void print() {
        Node current = first; // Start from the first node
        while (current != null) {
            System.out.println(current.data); // Print the data of the current node
            current = current.next; // Move to the next node
        }
    }
}
