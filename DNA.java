import java.util.NoSuchElementException;

////////////////FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
//Title:    DNA
//Course:   CS 300 Spring 2022
//
//Author:   Kolby Boesel
//Email:    kboesel@wisc.edu
//Lecturer: Mouna Kacem
//

//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
//Persons:   None
//Online Sources:  Piazza
//
/////////////////////////////////////////////////////////////////////////////// 

/**
 * This class uses a linked queue to implement DNA transcription
 * 
 * @author kolbyboesel
 *
 */
public class DNA extends Object {

	protected static String[][] mRNAtoProteinMap = { { "UUU", "F" }, { "UUC", "F" }, { "UUA", "L" }, { "UUG", "L" },
			{ "UCU", "S" }, { "UCC", "S" }, { "UCA", "S" }, { "UCG", "S" }, { "UAU", "Y" }, { "UAC", "Y" },
			{ "UAA", "STOP" }, { "UAG", "STOP" }, { "UGU", "C" }, { "UGC", "C" }, { "UGA", "STOP" }, { "UGG", "W" },
			{ "CUU", "L" }, { "CUC", "L" }, { "CUA", "L" }, { "CUG", "L" }, { "CCU", "P" }, { "CCC", "P" },
			{ "CCA", "P" }, { "CCG", "P" }, { "CAU", "H" }, { "CAC", "H" }, { "CAA", "Q" }, { "CAG", "Q" },
			{ "CGU", "R" }, { "CGC", "R" }, { "CGA", "R" }, { "CGG", "R" }, { "AUU", "I" }, { "AUC", "I" },
			{ "AUA", "I" }, { "AUG", "M" }, { "ACU", "T" }, { "ACC", "T" }, { "ACA", "T" }, { "ACG", "T" },
			{ "AAU", "N" }, { "AAC", "N" }, { "AAA", "K" }, { "AAG", "K" }, { "AGU", "S" }, { "AGC", "S" },
			{ "AGA", "R" }, { "AGG", "R" }, { "GUU", "V" }, { "GUC", "V" }, { "GUA", "V" }, { "GUG", "V" },
			{ "GCU", "A" }, { "GCC", "A" }, { "GCA", "A" }, { "GCG", "A" }, { "GAU", "D" }, { "GAC", "D" },
			{ "GAA", "E" }, { "GAG", "E" }, { "GGU", "G" }, { "GGC", "G" }, { "GGA", "G" }, { "GGG", "G" } }; // A
	// two-dimensional array containing the mRNA codons in index 0 and the
	// corresponding amino acid (or STOP)
	// in index 1

	protected LinkedQueue<Character> DNA;// The queue containing the original DNA sequence

	/**
	 * Creates the DNA queue from the provided String. Each Node contains a single
	 * Character from the sequence.
	 * 
	 * @param sequence - a String containing the original DNA sequence
	 */
	public DNA(String sequence) {
		DNA = new LinkedQueue<Character>();
		for (int i = 0; i < sequence.length(); ++i) {

			DNA.enqueue(sequence.charAt(i));

		}
	}

	/**
	 * Creates and returns a new queue of mRNA characters from the stored DNA. The
	 * transcription is done one character at a time, as (A->U, T->A, C->G, G->C).
	 * 
	 * @return the queue containing the mRNA sequence corresponding to the stored
	 *         DNA sequence
	 * 
	 */
	public LinkedQueue<Character> transcribeDNA() {
		LinkedQueue<Character> completedDNA = new LinkedQueue<Character>();
		Node<Character> current = DNA.front;

		for (int i = 0; i < DNA.size(); i++) {
			if (current.getData().equals('A')) {

				completedDNA.enqueue('U');
			}
			if (current.getData().equals('T')) {

				completedDNA.enqueue('A');
			}
			if (current.getData().equals('C')) {

				completedDNA.enqueue('G');
			}
			if (current.getData().equals('G')) {

				completedDNA.enqueue('C');
			}
			current = current.getNext();
		}
		return completedDNA;

	}

	/**
	 * Creates and returns a new queue of amino acids from a provided queue of mRNA
	 * characters. The translation is done three characters at a time, according to
	 * the static mRNAtoProteinMap provided above. Translation ends either when you
	 * run out of mRNA characters OR when a STOP codon is reached (i.e. the
	 * three-character sequence corresponds to the word STOP in the map, rather than
	 * a single amino acid character).
	 * 
	 * @param mRNA - a queue containing the mRNA sequence corresponding to the
	 *             stored DNA sequence
	 * 
	 * @return the queue containing the amino acid sequence corresponding to the
	 *         provided mRNA sequence
	 * 
	 */
	public LinkedQueue<String> mRNATranslate​(LinkedQueue<Character> mRNA) {
		LinkedQueue<String> aminoAcids = new LinkedQueue<String>();

		int mRNASize = mRNA.size();
		for (int i = 0; i < mRNASize; i++) {
			String sequence = "";
			for (int j = 0; j < 3; j++) {
				try {
					mRNA.peek();
				} catch (NoSuchElementException e) {
					return aminoAcids;

				}
				sequence = sequence + mRNA.dequeue();

			}
			for (int k = 0; k < mRNAtoProteinMap.length; k++) {
				if (sequence.equalsIgnoreCase(mRNAtoProteinMap[k][0])) {
					if (mRNAtoProteinMap[k][1].equalsIgnoreCase("STOP")) {

						return aminoAcids;

					}
					aminoAcids.enqueue(mRNAtoProteinMap[k][1]);
				}

			}
		}
		return aminoAcids;
	}

	/**
	 * A shortcut method that translates the stored DNA sequence to a queue of amino
	 * acids using the other two methods in this class
	 * 
	 * 
	 * @return the queue containing the amino acid sequence corresponding to the
	 *         stored DNA sequence, via its mRNA transcription
	 */
	public LinkedQueue<String> translateDNA() {
		LinkedQueue<String> aminoAcids = new LinkedQueue<String>();
		LinkedQueue<Character> transcribedDNA = this.transcribeDNA();
		aminoAcids = mRNATranslate​(transcribedDNA);

		return aminoAcids;

	}

}
