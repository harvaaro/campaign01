package edu.isu.cs.cs3308.structures.impl;

// Actually do not need a CLL for this campaign, it works with an SLL
// To test you can rem out the method below to see it works the same

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
	protected void verifyTail() { tail.setNext(head); }
}
