package edu.isu.cs.cs3308;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import edu.isu.cs.cs3308.structures.impl.CircularlyLinkedList;

/**
 * A class to do all the keygeneration needed for
 * the Modified Solitaire Algorithm de/encrypt
 *
 * @author Aaron Harvey
 */
public class KeyGeneration {
	// create a new CLL to store the deck values that will be the key
	private CircularlyLinkedList<Integer> deckKey = new CircularlyLinkedList<>();

	public KeyGeneration(String deckLocation) {
		deckSplit(deckLocation);
	}

	/**
	 * Will read in the Deck list provided and split it into
	 * a Circularly Linked List for use later.
	 *
	 * based on the information here:
	 * https://www.tutorialspoint.com/java/java_files_io.htm
	 * https://www.journaldev.com/17794/java-files-nio-files-class
	 * @throws IOException
	 */
	public void deckSplit(String deckPath) {
		// temporary list of strings to then convert to my CLL
		List<String> deckList;

		// read from the file provided by deckPath
		try {
			// get the string of numbers line from the deck txt
			deckList = Files.readAllLines(Paths.get(deckPath));
		}
		// catch any IO exceptions thrown
		catch (IOException ex){
			System.out.println("IOExcption: " + ex);
		}



//		// variable for reading the deck file in
//		FileReader readDeck = null;
//
//		// try reading in the file and parsing
//		try {
//			readDeck = new FileReader(deckPath);
//
//			// temp string for the deck line;
//			String tempLine = readDeck.toString();
//
//			System.out.println(tempLine);
//		}
//		// catch exceptions that have occurred
//		catch (IOException ex){
//			System.out.println("IOExcption: " + ex);
//		}
//		// regardless close the file reading at end
//		finally {
//			readDeck.close();
//		}
	}
}
