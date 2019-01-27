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
		deckKey.printList();
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
	 * Swap the number 27 with the number before it in the list
	 */
	private void step1Swap27() {
		// get the index of the number before 27
		int priorIdx = deckKey.indexOf(27)-1;

		// if that number is -1 then get the end of the list
		if (priorIdx == -1) {
			priorIdx = deckKey.size()-1;
		}

		// remove that prior number from the list
		// this moves the 27 to its spot
		int priorNum = deckKey.remove(priorIdx);

		// now insert the old number where the 27 was
		deckKey.insert(priorNum, priorIdx+1);
	}

	private void step2Move28() {

	}
}
