package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.impl.CircularlyLinkedList;

public class SolitaireAlgo {
	// get the linked list from that to use for keygen
	private CircularlyLinkedList<Integer> codeMessage = new CircularlyLinkedList<>();

	// get the linked list from the keygen
	private CircularlyLinkedList<Integer> codeKey = new CircularlyLinkedList<>();

	// final list that will store the coded message
	private CircularlyLinkedList<Integer> finalCode = new CircularlyLinkedList<>();

	// bool for whether to show the debug output
	private boolean debugPrint = true;

	/**
	 * Constructor for setting everything up for the Solitaire Algorithm
	 * @param codeString The original message string to de/encode
	 * @param deckPath The path to the file that has the deck key
	 */
	public SolitaireAlgo(String codeString, String deckPath) {
		// parse the message as needed for coding
		CardString theMessage = new CardString(codeString);

		// get the linked list from that to use for keygen
		codeMessage = theMessage.getCardList();

		// generate the key needed for coding
		KeyGeneration theKey = new KeyGeneration(deckPath, codeMessage.size());

		// get the linked list from the keygen
		codeKey = theKey.getCodeKey();

		// DEBUG print log for seeing the changes
		if (debugPrint) {
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
	public String encode(boolean doEncode) {
		// temp number to add to the final list
		int tempNum = -1;

		// size of the list to code
		int listSize = codeKey.size();

		for (int i = 0; i < listSize; i++) {
			if (doEncode) {
				tempNum = codeMessage.removeFirst() + codeKey.removeFirst();
				if (tempNum > 26) { tempNum -= 26; }
			}
			else {
				// get the two numbers to do compare
				int tempUpper = codeMessage.removeFirst();
				int tempLower = codeKey.removeFirst();

				// do adjustment to upper number if needed
				if (tempUpper <= tempLower) {
					tempUpper += 26;
				}

				// now subtract to get value
				tempNum = tempUpper - tempLower;
			}

			finalCode.addLast(tempNum);
		}

		// DEBUG print log for seeing the changes
		if (debugPrint) {
			System.out.print("finalCode:   ");
			finalCode.printList();
		}

		return numList2String(finalCode);
	}


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
