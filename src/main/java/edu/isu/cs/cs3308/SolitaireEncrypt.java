package edu.isu.cs.cs3308;

public class SolitaireEncrypt {
	private String deckPath;

	public SolitaireEncrypt(String deck) {
		this.deckPath = deck;
	}

	String execute(String decString) {
		CardString theMessage = new CardString(decString);
		KeyGeneration theKey = new KeyGeneration(deckPath);

		return decString;
	}
}
