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
 * Test methods to verify your implementation of the methods for P08.
 */
public class DNATester {

	/**
	 * Tests the transcribeDNA() method
	 * 
	 * @return true if and only if the method works correctly
	 */
	public static boolean testTranscribeDNA() {
		DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
		String mRNA = "CCUCAGUCAAUUCGCUGGCCCUGUAUGACAGAACCAUUAGAGGCUCGAUCUUUCAGAGAC";
		if (testDNA.transcribeDNA().toString().replaceAll(" ", "").equals(mRNA)) {
			return true;
		}
		return false;
	}

	/**
	 * Tests the translateDNA() method
	 * 
	 * @return true if and only if the method works correctly
	 */
	public static boolean testTranslateDNA() {
		DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
		if (testDNA.translateDNA().toString().replaceAll(" ", "").equals("PQSIRWPCMTEPLEARSFRD")) {

			return true;
		}
		return false;
	}

	/**
	 * test adding and removing things from your queue
	 * 
	 * @return true if and only if the method works correctly
	 */
	public static boolean testEnqueueDequeue() {
		boolean checkEnqueue = false;
		boolean checkDequeue = false;
		LinkedQueue<String> testQueue = new LinkedQueue<String>();
		try {
			testQueue.enqueue("Word 1");
			testQueue.enqueue("Word 2");
			testQueue.enqueue("Word 3");
			if (testQueue.toString().replaceAll(" ", "").equals("Word1Word2Word3")) {
				checkEnqueue = true;
			}
		} catch (Exception e) {

			return false;
		}

		try {
			testQueue.dequeue();
			testQueue.dequeue();
			testQueue.dequeue();
			if (testQueue.isEmpty() == true) {
				checkDequeue = true;
			}
		} catch (Exception e) {

			return false;
		}

		if (checkEnqueue == true && checkDequeue == true) {
			return true;
		}

		return false;

	}

	/**
	 * test the queue’s size and isEmpty methods
	 * 
	 * @return true if and only if the method works correctly
	 */
	public static boolean testQueueSize() {
		boolean checkSize = false;
		boolean checkEmpty = false;
		LinkedQueue<String> testQueue = new LinkedQueue<String>();
		try {
			testQueue.enqueue("Word 1");
			testQueue.enqueue("Word 2");
			testQueue.enqueue("Word 3");
			if (testQueue.size() == 3) {
				checkSize = true;
			}
		} catch (Exception e) {
			System.out.println("Fail 1");
			return false;
		}

		LinkedQueue<String> testQueue1 = new LinkedQueue<String>();
		try {

			if (testQueue1.isEmpty() == true) {
				checkEmpty = true;
			}
		} catch (Exception e) {
			System.out.println("Fail 2");

			return false;
		}

		if (checkEmpty == true && checkSize == true) {
			return true;
		}

		System.out.println("Fail 3");

		return false;

	}

	/**
	 * 
	 * test the DNA class’ mRNATranslate method
	 * 
	 * @return true if and only if the method works correctly
	 * 
	 * 
	 */
	public static boolean testMRNATranslate() {
		DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
		LinkedQueue<Character> testQueue = testDNA.transcribeDNA();

		if (testDNA.mRNATranslate​(testQueue).toString().replaceAll(" ", "").equals("PQSIRWPCMTEPLEARSFRD")) {

			return true;
		}
		return false;

	}

	// TODO: verify the mRNATranslate() method

	/**
	 * Main method - use this to run your test methods and output the results
	 * (ungraded)
	 * 
	 * @param args unused
	 */
	public static void main(String[] args) {
		System.out.println("transcribeDNA: " + testTranscribeDNA());
		System.out.println("translateDNA: " + testTranslateDNA());
		System.out.println("MRNATranslate: " + testMRNATranslate());

		System.out.println("enqueueDequeue: " + testEnqueueDequeue());
		System.out.println("queueSize: " + testEnqueueDequeue());

	}

}