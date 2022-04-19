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
import java.util.NoSuchElementException;

/**
 * A generic implementation of a linked queue
 * 
 * @author kolbyboesel
 *
 * @param <T> The type of data to be contained in the queue
 */
public class LinkedQueue<T> implements QueueADT<T> {
	private int n; // The number of elements in the queue

	protected Node<T> front; // The node at the front of the queue, added LEAST recently

	protected Node<T> back; // The node at the back of the queue, added MOST recently

	public LinkedQueue() {
		front = null;
		back = null;
		n = 0;
	}

	/**
	 * Adds the given data to this queue; every addition to a queue is made at the
	 * back
	 * 
	 * @param data - the data to add
	 */
	public void enqueue(T data) {
		Node<T> temp = new Node<T>(data);

		if (this.back == null && this.front == null) {
			this.front = temp;
			this.back = temp;
			n++;
			return;
		}

		this.back.setNext​(temp);
		this.back = temp;

		n++;
	}

	/**
	 * Removes and returns the item from this queue that was least recently added
	 * 
	 * @return the item from this queue that was least recently added
	 * @throws NoSuchElementException - if this queue is empty
	 * 
	 * 
	 */
	public T dequeue() {
		if (this.front == null)
			throw new NoSuchElementException();

		Node<T> temp = this.front;
		this.front = this.front.getNext();

		if (this.front == null)
			this.back = null;

		n--;

		return temp.getData();

	}

	/**
	 * Returns the item least recently added to this queue without removing it
	 * 
	 * @return the item from this queue that was least recently added
	 * @throws NoSuchElementException - if this queue is empty
	 * 
	 */
	public T peek() {
		if (isEmpty() == true) {
			throw new NoSuchElementException();
		}
		return front.getData();

	}

	/**
	 * Checks whether the queue contains any elements
	 * 
	 * @return true if this queue is empty; false otherwise
	 * 
	 * 
	 */
	public boolean isEmpty() {
		return front == null;

	}

	/**
	 * Returns the number of items in this queue
	 * 
	 * @return the number of items in this queue
	 * 
	 * 
	 */
	public int size() {
		return n;

	}

	/**
	 * Returns a string representation of this queue, beginning at the front (least
	 * recently added) of the queue and ending at the back (most recently added). An
	 * empty queue is represented as an empty string; otherwise items in the queue
	 * are represented using their data separated by spaces
	 *
	 * @return the sequence of items in FIFO order, separated by spaces
	 */
	@Override
	public String toString() {
		String queueToString = "";
		if (n == 0) {
			return queueToString;
		}
		Node<T> current = front;

		if (current == front) {
			queueToString = queueToString + current.getData();
		}

		while (current.getNext() != null) {
			current = current.getNext();

			queueToString = queueToString + " " + current.getData();
		}

		return queueToString;

	}

}
