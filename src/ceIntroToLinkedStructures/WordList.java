package ceIntroToLinkedStructures;

/**
 * WordList is a singly-linked list of Strings.
 * It is designed as a practice opportunity to
 * learn how to manipulate linked structures.
 * 
 * @author ..........
 */
public class WordList {
	private Node head; // first node of the list or null
	private Node tail; // last node of the list or null
	private int n;     // number of words in the list

	/**
	 * Node of LinkedList that stores the item and a
	 * single reference to the next node.
	 */
	private class Node {
		private String item;
		private Node next;
	}
	
	/** 
	 * Adds a node containing the new item at the
	 * end of the list.
	 * 
	 * @param newItem
	 */
	public void append(String newItem) {
		// create a new node based on the word provided by the user
		Node newNode = new Node();
		newNode.item = newItem;
		
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
		n++;
	}
	
	/** 
	 * Adds a node containing the new item at the
	 * front of the list.
	 * 
	 * @param newItem
	 */
	public void prepend(String newItem) {
		Node newNode = new Node();
		newNode.item = newItem;
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		}
		else{
			//creates a holder for the old head for clarity.
			Node oldHead = head;
			//creates the link for the linked list,
			//pointing it to the old head
			// Imagine it like this drawing:
			// newNode -> oldHead (newNode.next = oldHead;)
			newNode.next = oldHead;
			//finally establishes the new node as the head.
			head = newNode;
			// The links look like this now newNode -> oldHead -> ...
		}
		n++;
	}
	
	/** 
	 * Returns the index of the first occurrence of the specified item.
	 * If the specified item in not part of the list
	 * the method indexOf returns -1
	 * 
	 * @param item
	 * @return index of the first occurrence of the item; -1 if the word was not found.
	 */
	public int indexOf(String item) {
		Node current = head;
		int indexLocation = 0;
		while(current != null) {
			if (current.item.compareTo(item) == 0) {
				return indexLocation;
			}
			indexLocation ++;
			current = current.next;
		}
		return -1;
	}
	
	/** 
	 * Checks whether the list contains the given item.
	 * 
	 * @param item
	 * @return true if the item is contained in the list; false otherwise.
	 */
	public boolean contains(String item) {
		Node current = head;
		int indexLocation = 0;
		while(current != null) {
			if (current.item.compareTo(item) == 0) {
				return true;
			}
			indexLocation ++;
			current = current.next;
		}
		return false;
	}
	
	/**
	 * Returns the number of elements in the list
	 * @return the number of elements
	 */
	public int size() {
		return n;
	}
	
	/** 
	 * Determines whether the list is empty or not.
	 * @return true if there are no elements in the list.
	 */
	public boolean isEmpty() {
		if (head == null){return true;}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head;
		
		while(current != null) {
			sb.append(current.item).append(" ");
			current = current.next;
		}
		
		return sb.toString();
	}
	
	/* * * * * * * * Test Client * * * * * * */
	public static void main(String[] args) {
		WordList list = new WordList();
		System.out.println("size: " + list.size());
		
		// CHALLENGE 1
		// Dynamically determine whether the list is empty. If so, print 
		// 'The list is empty.' otherwise print 'The list is not empty.'

		System.out.println("Q: is the list empty? A: "+ list.isEmpty() + ".");
		 
		list.append("ant");
		list.append("bat");
		list.append("cow");
		list.append("dog");
		//test
		list.prepend("chicken");
		System.out.println("updated list: " + list);

		System.out.println("Q: is the list empty? A: "+ list.isEmpty() + ".");
		System.out.println("Index location of dog: "+ list.indexOf("dog") + ".");
		System.out.println("'dog' is in this list: "+ list.contains("dog") + ".");
	}

}
