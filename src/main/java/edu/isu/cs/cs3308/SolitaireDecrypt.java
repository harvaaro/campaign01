package edu.isu.cs.cs3308;

public class SolitaireDecrypt {
	private String deckPath;

	public SolitaireDecrypt(String deck) {
		this.deckPath = deck;
	}

	String execute(String encString) {
		// test all manually
		System.out.println("Testing all Decode:");
		SolitaireAlgo m1 = new SolitaireAlgo("AALMORDZYOATQFGYQCJUAQSVG", "data/deck1.txt");
		m1.encode(false);
		SolitaireAlgo m2 = new SolitaireAlgo("MJUFROUIHNOAWHGEXMUXGFEVVAEUOOUOYYE", "data/deck1.txt");
		m2.encode(false);
		SolitaireAlgo m3 = new SolitaireAlgo("KQWACQERECNXVJMFEOGJYIRMZTZSZT", "data/deck1.txt");
		m3.encode(false);
		SolitaireAlgo m4 = new SolitaireAlgo("VRRCTOSNXZZPHBOWPYUDLYIQN", "data/deck1.txt");
		m4.encode(false);
		SolitaireAlgo m5 = new SolitaireAlgo("TBJYUOPSYJOYPGRNWXPFUQJSTMPUNYTXNEJVQFEFKJMVAHNMUSXVBQN", "data/deck1.txt");
		m5.encode(false);

		// create the needed setup for doing de/encoding
		SolitaireAlgo theDeck = new SolitaireAlgo(encString, deckPath);

		// testing decrypt
//		SolitaireAlgo theDeck = new SolitaireAlgo("UKTUMUXRMOSPGVWSADBUHPJSFCMQLR", "data/AAdeck01.txt");

		// testing decrypt
//		SolitaireAlgo theDeck = new SolitaireAlgo("KKIMEWEASPYNBDS", "data/AAdeck02.txt");

		// return the decoded string
		return theDeck.encode(false);
	}
}
