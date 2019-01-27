package edu.isu.cs.cs3308;

public class SolitaireEncrypt {
	SolitaireAlgo theDeck;

	public SolitaireEncrypt(String deckPath) {
		// create the needed setup for doing de/encoding
		theDeck = new SolitaireAlgo(deckPath);
	}

	String execute(String decString) {
		// return the encoded string
		return theDeck.encode(true, decString);
	}
}
