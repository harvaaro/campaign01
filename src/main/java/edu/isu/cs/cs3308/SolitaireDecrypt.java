package edu.isu.cs.cs3308;

public class SolitaireDecrypt {
	SolitaireAlgo theDeck;

	public SolitaireDecrypt(String deckPath) {
		// create the needed setup for doing de/encoding
		theDeck = new SolitaireAlgo(deckPath);
	}

	String execute(String encString) {
		// return the decoded string
		return theDeck.encode(false, encString);
	}
}
