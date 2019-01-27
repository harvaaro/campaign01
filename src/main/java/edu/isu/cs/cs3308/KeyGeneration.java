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

	/**
	 * Contrcustor to do all the appropriate methods
	 * to get the needed generated key for de/encrypt
	 * @param deckLocation the deck file path
	 */
	public KeyGeneration(String deckLocation) {
		deckSplit(deckLocation);
		step1Swap27();
		step2Move28();
		deckKey.printList();
		System.out.println("Size: " + deckKey.size());
		System.out.println("First: " + deckKey.first());
		System.out.println("Last: " + deckKey.last());
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
	private void deckSplit(String deckPath) {
		// read from the file provided by deckPath
		try {
			// get the string of numbers line from the deck txt
			List<String> deckList = Files.readAllLines(Paths.get(deckPath));

			// split out the values into a Circularly Linked List
			for (String deckNum: deckList.get(0).split(" ")) {
				deckKey.addLast(Integer.parseInt(deckNum));
			}
		}
		// catch any IO exceptions thrown
		catch (IOException ex){
			System.out.println("IOExcption: " + ex);
		}
	}

	/**
	 * Swap an element with the one following it in the list
	 * @param lookup what int to lookup in the list
	 */
	private void swapWithNext(int lookup) {
		// if a valid number then process
		if (lookup >= 0 && lookup <= 28) {
			// get the index of the found number
			int indexLookup = deckKey.indexOf(lookup);

			// check if following as at end of the list
			if (indexLookup+1 == deckKey.size()) {
				// remove both values
				int dataBegin = deckKey.removeFirst();
				int dataLookup = deckKey.removeLast();

				// insert in opposite spots
				deckKey.addLast(dataBegin);
				deckKey.addFirst(dataLookup);
			}
			// else not the end so can just move one
			else {
				// remove the number from the list
				int dataLookup = deckKey.remove(indexLookup);

				// insert back at the following position
				deckKey.insert(dataLookup, indexLookup+1);
			}
		}
	}

	/**
	 * Swap the number 27 with the number before it in the list
	 */
	private void step1Swap27() {
		swapWithNext(27);
	}

	private void step2Move28() {
		swapWithNext(28);
		swapWithNext(28);
	}
}
