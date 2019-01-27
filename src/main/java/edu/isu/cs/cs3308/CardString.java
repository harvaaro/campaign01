package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.impl.CircularlyLinkedList;

/**
 * Will convert a given string into a usable form
 * to de/encode with the Solitaire algorithm
 *
 * @author Aaron Harvey
 */
public class CardString {
	// linked list for use with the algorithm
	private CircularlyLinkedList<Integer> cardList = new CircularlyLinkedList<>();

	// return the list for use in other areas
	public CircularlyLinkedList<Integer> getCardList() {
		return cardList;
	}

	// bool for whether to show the debug output
	private boolean debugPrint = false;

	// Constructor to get the string to edit
	public CardString(String inputString) {
		cleanString(inputString);

		// DEBUG print log for seeing the changes
//		if (debugPrint) {
//			System.out.println("Check: " + numList2String(cardList));
//		}
	}

	/**
	 * Will convert a given string into a list where all letters
	 * are converted into their appropriate number range 1-26
	 * no symbols or other characters are converted.
	 *
	 * @param string4List string to convert to number list
	 */
	private void cleanString(String string4List) {
		// in a previous class to do the check for letters had
		// to convert to char array and compared ascii values
		char[] charString = string4List.toCharArray();

		// loop through string and add to list
		// only add letters and nothing else
		for (int i = 0; i < charString.length; i++) {
			// temp number to be used for inserting
			int letterNum = -1;

			// Check if it is only a letter based on ascii
			// https://ascii.cl/
			// if upper case letters
			if (charString[i] >= 65 && charString[i] <= 90) {
				letterNum = charString[i] - 64;
				cardList.addLast(letterNum);
			}
			// else if lower case letters
			else if (charString[i] >= 97 && charString[i] <= 122) {
				letterNum = charString[i] - 96;
				cardList.addLast(letterNum);
			}
		}

		// now ensure it is in a multiple of 5 otherwise add X as 24
		for (int i = 0; i < cardList.size() % 5; i++) {
			cardList.addLast(24);
		}

		// DEBUG print log for seeing the changes
		if (debugPrint) {
			System.out.println("Start: " + string4List);
			System.out.print("Ready: ");
			cardList.printList();
		}
	}
}
