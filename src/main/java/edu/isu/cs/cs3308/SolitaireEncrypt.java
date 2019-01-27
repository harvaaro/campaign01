package edu.isu.cs.cs3308;

/**
 * Handles encrypting a file of text using a provided deck file
 *
 * @author Aaron Harvey
 */
public class SolitaireEncrypt {
	// class to handle the creation and execution of coding
	SolitaireAlgo theDeck;

	/**
	 * Constructor to setup the initial algorithm path for the deck
	 * @param deckPath The file path to the deck to use
	 */
	public SolitaireEncrypt(String deckPath) {
		// output that I am starting the encryption
		System.out.println("\n" +
				"#################\n" +
				"Encryption Start:\n" +
				"#################\n");

		// create the needed setup for doing de/encoding
		theDeck = new SolitaireAlgo(deckPath);
	}

	/**
	 * Decrypts a given string using the deck already loaded
	 * @param decString The string to decrypt
	 * @return The string decoded
	 */
	String execute(String decString) {
		// return the encoded string
		return theDeck.encode(true, decString);
	}
}
