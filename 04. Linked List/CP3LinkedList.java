import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of links with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
 */
public class CP3LinkedList<E> {

	private static class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node<E> head;
	private int size;

	/**
	 * Constructs an empty linked list.
	 */
	public CP3LinkedList() {
		head = null;
		size = 0;
	}

	/**
	 * Adds an element to the front of the linked list.
	 * 
	 * @param element the element to add
	 */
	public void addFirst(E element) {
		Node<E> newNode = new Node<>(element);
		newNode.next = head;
		head = newNode;
		size++;
	}

	/**
	 * Retrieves the first element in the list.
	 * 
	 * @return the first element
	 * @throws NoSuchElementException if the list is empty
	 */
	public E getFirst() {
		if (head == null)
			throw new NoSuchElementException("List is empty");
		return head.data;
	}

	/**
	 * Removes the first element in the list.
	 * 
	 * @return the removed element
	 * @throws NoSuchElementException if the list is empty
	 */
	public E removeFirst() {
		if (head == null)
			throw new NoSuchElementException("List is empty");
		E element = head.data;
		head = head.next;
		size--;
		return element;
	}

	/**
	 * Prints all elements in the linked list.
	 */
	public void print() {
		Node<E> current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	/**
	 * Checks if the list is empty.
	 * 
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Gets the size of the linked list.
	 * 
	 * @return the number of elements in the list
	 */
	public int size() {
		return size;
	}

	/**
	 * Clears all elements from the list.
	 */
	public void clear() {
		head = null;
		size = 0;
	}
}
