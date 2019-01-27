package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.impl.CircularlyLinkedList;

/**
 * Method to process everything needed for the Solitaire Algorithm
 *
 * @author Aaron Harvey
 */
public class SolitaireAlgo {
	// the generator for the coding key
	private KeyGeneration theKey;

	// get the linked list from that to use for keygen
	private CircularlyLinkedList<Integer> codeMessage = new CircularlyLinkedList<>();

	// get the linked list from the keygen
	private CircularlyLinkedList<Integer> codeKey = new CircularlyLinkedList<>();

	// final list that will store the coded message
	private CircularlyLinkedList<Integer> finalCode = new CircularlyLinkedList<>();

	// bool for whether to show the debug output
	private boolean debugPrint = true;

	/**
	 * Constructor for setting up the generator for the Solitaire Algorithm
	 *
	 * @param deckPath The path to the file that has the deck key
	 */
	public SolitaireAlgo(String deckPath) {
		// generate the key needed for coding
		theKey = new KeyGeneration(deckPath);
	}

	/**
	 * Create all of the necesarry lists to process the coding
	 *
	 * @param codeString The original message string to de/encode
	 */
	private void prepareCode(String codeString) {
		// parse the message as needed for coding
		CardString theMessage = new CardString(codeString);

		// get the linked list from that to use for keygen
		codeMessage = theMessage.getCardList();

		// generate the key needed for coding
		theKey.generateCodeKey(codeMessage.size());

		// get the linked list from the keygen
		codeKey = theKey.getCodeKey();

		// DEBUG print log for seeing the changes
		if (debugPrint) {
			System.out.println("strMessage:  " + numList2String(codeMessage));
			System.out.print("codeMessage: ");
			codeMessage.printList();
			System.out.print("codeKey:     ");
			codeKey.printList();
		}
	}

	/**
	 * Will do the encryption of the decryption
	 * Using the code message and key
	 *
	 * @param doEncode True = Encrypt and False = Decrypt
	 */
	public String encode(boolean doEncode, String codeString) {
		// prepare all the necessary lists and values
		prepareCode(codeString);

		// temp number to add to the final list
		int tempNum = -1;

		// size of the list to code
		int listSize = codeKey.size();

		// iterate for the list size until all values have been coded
		for (int i = 0; i < listSize; i++) {
			if (doEncode) {
				tempNum = codeMessage.removeFirst() + codeKey.get(i);
				if (tempNum > 26) {
					tempNum -= 26;
				}
			}
			else {
				// get the two numbers to do compare
				int tempUpper = codeMessage.removeFirst();
				int tempLower = codeKey.get(i);

				// do adjustment to upper number if needed
				if (tempUpper <= tempLower) {
					tempUpper += 26;
				}

				// now subtract to get value
				tempNum = tempUpper - tempLower;
			}

			finalCode.addLast(tempNum);
		}

		// the final string of coded number
		String strCode = numList2String(finalCode);

		// DEBUG print log for seeing the changes
		if (debugPrint) {
			System.out.print("finalCode:   ");
			finalCode.printList();
			System.out.println("strCode:     " + strCode + "\n");
		}

		// return the string of code
		return strCode;
	}

	/**
	 * Converts a given number list into a string of letters
	 * @param numList A list of integers to convert to letters
	 * @return The string of all the letters representing the numbers
	 */
	public String numList2String(CircularlyLinkedList<Integer> numList) {
		// string of list to return
		String converted = "";

		// size of the list provided
		int listSize = numList.size();

		// iterate until all numbers have been converted
		for (int i = 0; i < listSize; i++) {
			// char of the int as letter
			char numLetter = (char)(numList.get(i) + 64);

			// put that letter into the string
			converted += numLetter;
		}

		// return the converted string
		return converted;
	}
}
