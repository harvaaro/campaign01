package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.impl.CircularlyLinkedList;

public class SolitaireEncrypt {
	private String deckPath;

	public SolitaireEncrypt(String deck) {
		this.deckPath = deck;
	}

	String execute(String decString) {
		// create the needed setup for doing de/encoding
		SolitaireAlgo theDeck = new SolitaireAlgo(decString, deckPath);

		// return the encoded string
		return theDeck.encode(true);
	}
}
