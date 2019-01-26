package edu.isu.cs.cs3308.structures.impl;

public class CircularlyLinkedList<E> extends SinglyLinkedList<E> {
	/**
	 * Ensure that whenever data is added to the list then the tail,
	 * will always point back to the head to keep it circular
	 */
	@Override
	public void verifyTail() {
		tail.setNext(head);
	}
}
