package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.impl.CircularlyLinkedList;

public class SolitaireEncrypt {
	private String deckPath;

	public SolitaireEncrypt(String deck) {
		this.deckPath = deck;
	}

	String execute(String decString) {
		// parse the message as needed for coding
		CardString theMessage = new CardString(decString);

		// get the linked list from that to use for keygen
		CircularlyLinkedList<Integer> codeMessage = theMessage.getCardList();

		// generate the key needed for coding
		KeyGeneration theKey = new KeyGeneration(deckPath, codeMessage.size());

		return decString;
	}
}
