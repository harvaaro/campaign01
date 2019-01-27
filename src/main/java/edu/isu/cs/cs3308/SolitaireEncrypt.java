package edu.isu.cs.cs3308;

public class SolitaireEncrypt {
	private String deckPath;

	public SolitaireEncrypt(String deck) {
		this.deckPath = deck;
	}

	String execute(String decString) {
		// test all manually
		System.out.println("Testing all Encode:");
		SolitaireAlgo m1 = new SolitaireAlgo("PROFESSORGRIFFITHISCRAZYX", "data/deck1.txt");
		m1.encode(true);
		SolitaireAlgo m2 = new SolitaireAlgo("PLATYPUSPLATYPUSWHEREDIDYOUCOMEFROM", "data/deck1.txt");
		m2.encode(true);
		SolitaireAlgo m3 = new SolitaireAlgo("THEPASSWORDISSIMPLYPASSWORDXXX", "data/deck1.txt");
		m3.encode(true);
		SolitaireAlgo m4 = new SolitaireAlgo("WHATISYOURREALNAMEALBERTX", "data/deck1.txt");
		m4.encode(true);
		SolitaireAlgo m5 = new SolitaireAlgo("PAYINGMEFIFTYDOLLARSCOULDBEYOURNEWTHINGTODOFORTHATDAYXX", "data/deck1.txt");
		m5.encode(true);

		// create the needed setup for doing de/encoding
		SolitaireAlgo theDeck = new SolitaireAlgo(decString, deckPath);

		// This test works based off of the information from this page:
		// https://powcoder.com/2018/09/28/java%e4%bb%a3%e5%86%99-programming-assignment-1-solitaire-encryption/
//		SolitaireAlgo theDeck = new SolitaireAlgo("you'll never guess this message!", "data/AAdeck01.txt");

		// This test works based off of the information from this page:
		// http://csprojectedu.com/2018/02/03/CS112-Simplified-Solitaire-Encryption/
//		SolitaireAlgo theDeck = new SolitaireAlgo("DUDE, WHERE'S MY CAR?", "data/AAdeck02.txt");

		// return the encoded string
		return theDeck.encode(true);
	}
}
