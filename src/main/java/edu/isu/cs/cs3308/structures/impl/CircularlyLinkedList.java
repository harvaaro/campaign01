package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Node;

/**
 * A class to implement a circularly linked list by
 * extending the functionality of the singly linked list
 *
 * @author Aaron Harvey
 * @param <E> any type of list
 */
public class CircularlyLinkedList<E> extends SinglyLinkedList<E> {
	/**
	 * Ensure that whenever data is added to the list then the tail,
	 * will always point back to the head to keep it circular
	 */
	@Override
	protected void verifyTail() {
		tail.setNext(head);
	}

	/**
	 * Modified this to be the spaced version instead of the newline from SLL
	 * Each value in the list will be printed out with spaces between them
	 * and then a newline at the end of the list.
	 */
	@Override
	public void printList() {
		// if there are nodes in the list
		if (!isEmpty()) {
			// get the head as the starting point
			Node<E> printNode = head;

			// iterate though the list, until we reach the end
			for (int i = 0; i < size; i++) {
				// print the current nodes data with a space after it
				if (i < size-1) {
					System.out.print(printNode.getData() + " ");
				}
				// else on the last value
				else {
					System.out.println(printNode.getData());
				}

				// then get the next node to get data from
				printNode = printNode.getNext();
			}
		}
		// else there are no nodes in the list
		else {
			System.out.println("There is nothing in this list.");
		}
	}
}
