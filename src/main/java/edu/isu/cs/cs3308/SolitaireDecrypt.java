package edu.isu.cs.cs3308;

public class SolitaireDecrypt {
	private String deckPath;

	public SolitaireDecrypt(String deck) {
		this.deckPath = deck;
	}

	String execute(String encString) {
		// create the needed setup for doing de/encoding
//		SolitaireAlgo theDeck = new SolitaireAlgo(encString, deckPath);

		// test 2nd
		SolitaireAlgo theDeck = new SolitaireAlgo("AUXAIOFDWTJEJPSXFBVJNTBAHLSWAFDFHGO", "data/deck1.txt");

		// testing decrypt
//		SolitaireAlgo theDeck = new SolitaireAlgo("UKTUMUXRMOSPGVWSADBUHPJSFCMQLR", "data/AAdeck01.txt");

		// testing decrypt
//		SolitaireAlgo theDeck = new SolitaireAlgo("KKIMEWEASPYNBDS", "data/AAdeck02.txt");

		// return the decoded string
		return theDeck.encode(false);
	}
}
