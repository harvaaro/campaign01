package edu.isu.cs.cs3308;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import edu.isu.cs.cs3308.structures.impl.CircularlyLinkedList;
import edu.isu.cs.cs3308.structures.impl.SinglyLinkedList;

/**
 * A class to do all the keygeneration needed for
 * the Modified Solitaire Algorithm de/encrypt
 *
 * @author Aaron Harvey
 */
public class KeyGeneration {
	// create a new CLL to store the deck values that will be the key
	private CircularlyLinkedList<Integer> deckKey = new CircularlyLinkedList<>();

	// this will be the final key to use for de/encoding
	private CircularlyLinkedList<Integer> codeKey = new CircularlyLinkedList<>();

	// return the list for use in other areas
	public CircularlyLinkedList<Integer> getCodeKey() {
		return codeKey;
	}

	// bool for whether to show the debug output
	private boolean debugPrint = false;

	/**
	 * Contrcustor to do all the appropriate methods
	 * to get the needed generated key for de/encrypt
	 * @param deckLocation the deck file path
	 */
	public KeyGeneration(String deckLocation, int secretSize) {
		// split the file to a usable list
		deckSplit(deckLocation);

		// DEBUG print log for seeing the changes
		if (debugPrint) {
			System.out.println("Input: " + deckLocation);
			System.out.print("Prior: ");
			deckKey.printList();
		}

		// run all the steps to generate a code key
		generateCodeKey(secretSize);
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
	 * Move the number 27 up 1 place in the list
	 */
	private void step1Swap27() {
		swapWithNext(27);

		// DEBUG print log for seeing the changes
		if (debugPrint) {
			System.out.print("Step1: ");
			deckKey.printList();
		}
	}

	/**
	 * Move the number 28 up 2 places in the list
	 */
	private void step2Move28() {
		swapWithNext(28);
		swapWithNext(28);

		// DEBUG print log for seeing the changes
		if (debugPrint) {
			System.out.print("Step2: ");
			deckKey.printList();
		}
	}

	/**
	 * Will swap the group of number before the first joker
	 * and the ones after the second joker in the list
	 * Leaving whatever is inbetween the 2 jokers
	 */
	private void step3TripleCut() {
		// get the locations of both jokers
		int index27 = deckKey.indexOf(27);
		int index28 = deckKey.indexOf(28);

		// joker indices to use for the swap
		int joker1, joker2;

		// determine which is first in the list
		if (index27 < index28) {
			joker1 = index27;
			joker2 = index28;
		}
		else {
			joker1 = index28;
			joker2 = index27;
		}

		// bool for whether the jokers are at the ends
		boolean joker2end = false;
		boolean joker1top = false;

		// determine if the jokers are at either end
		if (joker2 == deckKey.size()-1) {
			joker2end = true;
		}
		if (joker1 == 0) {
			joker1top = true;
		}

		// temporary lists to store the sections that are to be swapped
		SinglyLinkedList<Integer> cut2End = new SinglyLinkedList<>();
		SinglyLinkedList<Integer> cut1Top = new SinglyLinkedList<>();

		// if joker2 is not at the end
		if (joker2end == false) {
			int deckSize = deckKey.size();
			// get the end cut first
			for (int i = joker2 + 1; i < deckSize; i++) {
				cut2End.addFirst(deckKey.removeLast());
			}
		}

		// if joker1 is not at the beginning
		if (joker1top == false) {
			// get the top cut next
			for (int i = 0; i < joker1; i++) {
				cut1Top.addLast(deckKey.removeFirst());
			}
		}

		// put the sections back in their correct spots
		// put end to top
		if (joker2end == false) {
			// get size needed for looping
			int cut2Size = cut2End.size();

			// add all of the old end to the top
			for (int i = 0; i < cut2Size; i++) {
				deckKey.addFirst(cut2End.removeLast());
			}
		}
		// put top to end
		if (joker1top == false) {
			// get size needed for looping
			int cut1Size = cut1Top.size();

			// add all of the old end to the top
			for (int i = 0; i < cut1Size; i++) {
				deckKey.addLast(cut1Top.removeFirst());
			}
		}

		// DEBUG print log for seeing the changes
		if (debugPrint) {
			System.out.print("Step3: ");
			deckKey.printList();
		}
	}

	/**
	 * Removes the bottom value and
	 * Shifts top values to the bottom
	 * In an amount matching the removed value
	 */
	private void step4Bottom() {
		// get the bottom value of the list
		int deckLast = deckKey.removeLast();

		// counter for the values to move
		int deckCount = deckLast;

		// if the last value is either joker set to 27
		if (deckCount == 28) {
			deckCount = 27;
		}

		// shift values from top to bottom in the
		// quantity of what was on the bottom
		for (int i = 0; i < deckCount; i++) {
			deckKey.addLast(deckKey.removeFirst());
		}

		// readd the original value back to the end
		deckKey.addLast(deckLast);

		// DEBUG print log for seeing the changes
		if (debugPrint) {
			System.out.print("Step4: ");
			deckKey.printList();
		}
	}

	// int to use for the step5 recursion
	int step5Num = -1;

	/**
	 * Will find a number in the list with index of first value
	 * That number cannot be a joker so will only be a 1-26 value
	 *
	 * @return the card to use for the keystream
	 */
	private void step5Card() {
		// get the first value of the list
		int deckFirst = deckKey.first();

		// counter for how many to search
		int deckCount = deckFirst;

		// if the first value is either joker set to 27
		if (deckCount == 28) {
			deckCount = 27;
		}

		// put that value back at the beginning
//		deckKey.addFirst(deckFirst);

		// value and counted position
		int countValue = deckKey.get(deckCount);

		// if it is a joker then repeat algorithm
		if (countValue == 27 || countValue == 28) {
			step1Swap27();
			step2Move28();
			step3TripleCut();
			step4Bottom();
			step5Card();
		}
		// else return the found number from the list
		else {
			step5Num = countValue;
		}
	}

	// get the list needed for the string size of the message
	private void generateCodeKey(int codeSize) {
		// iterate through calling step 5 until
		// the code list is big enough
		for (int i = 0; i < codeSize; i++) {
			step1Swap27();
			step2Move28();
			step3TripleCut();
			step4Bottom();
			step5Card();
			codeKey.addLast(step5Num);

			// DEBUG print log for seeing the changes
			if (debugPrint) {
				System.out.print("Step5: ");
				codeKey.printList();
			}
		}
	}
}
