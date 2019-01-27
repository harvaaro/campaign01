package edu.isu.cs.cs3308;

/**
 * Handles decrypting a file of text using a provided deck file
 *
 * @author Aaron Harvey
 */
public class SolitaireDecrypt {
	// class to handle the creation and execution of coding
	SolitaireAlgo theDeck;

	/**
	 * Constructor to setup the initial algorithm path for the deck
	 * @param deckPath The file path to the deck to use
	 */
	public SolitaireDecrypt(String deckPath) {
		// output that I am starting the decryption
		System.out.println("\n" +
				"#################\n" +
				"Decryption Start:\n" +
				"#################\n");

		// create the needed setup for doing de/encoding
		theDeck = new SolitaireAlgo(deckPath);
	}

	/**
	 * Encrypts a given string using the deck already loaded
	 * @param encString The string to encrypt
	 * @return The string encoded
	 */
	String execute(String encString) {
		// return the decoded string
		return theDeck.encode(false, encString);
	}
}
