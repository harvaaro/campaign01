package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.KeyGeneration;

import java.io.IOException;

public class SolitaireEncrypt {
	private String deckPath;

	public SolitaireEncrypt(String deck) {
		this.deckPath = deck;
		System.out.println("deckPath: " + deckPath);
	}

	String execute(String decString) {
		KeyGeneration theKey = new KeyGeneration(deckPath);

		System.out.println("decString: " + decString);
		return decString;
	}
}
