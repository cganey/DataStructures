package com.amiyasahu.linkedlist.singly;

public class SinglyLinkedListImpl implements SinglyLinkedList {
	
	private ListNode head;
	private int length;

	public SinglyLinkedListImpl() {
		length = 0;
		head = null;
	}

	@Override
	public synchronized void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}

	@Override
	public synchronized void insertAtEnd(ListNode node) {
		if (head == null) {
			head = node;
		} else {
			ListNode current, next;

			for (current = head; (next = current.getNext()) != null; current = next)
				;

			current.setNext(node);
			length++;
		}
	}

	@Override
	public synchronized void insert(ListNode node, int position) {
		// fix the position
		if (position < 0)
			position = 0;

		if (position > length)
			position = length;

		if (head == null) {
			// for a empty linked list
			head = node;
		} else if (position == 0) {
			// for inserting at the beginning
			node.setNext(head);
			head = node;
		} else {
			ListNode temp = head;

			// find the correct position
			// 0 based positioning , so we have to stop one node before
			for (int i = 1; i < position; i++) {
				temp = temp.getNext();
			}

			node.setNext(temp.getNext());
			temp.setNext(node);
		}

		length++;
	}

	@Override
	public synchronized ListNode removeFromBegin() {
		ListNode node = head;

		if (node != null) {
			head = node.getNext();
			node.setNext(null);
		}
		length--;

		return node;
	}

	@Override
	public synchronized ListNode removeFromEnd() {

		if (head == null) {
			return null;
		}

		ListNode current = head, prev = null, next = head.getNext();

		if (next == null) {
			// it has only 1 element
			head = null;
			length--;
			return current;
		}

		while ((next = current.getNext()) != null) {
			// reach to the end with having the current and previous reference
			prev = current;
			current = next;
		}

		// set the previous element next node to null
		prev.setNext(null);
		length--;
		return current;
	}

	@Override
	public synchronized void removeMatched(ListNode node) {

		if (head == null) {
			// this is an empty list , No action required
			return;
		}

		if (node.equals(head)) {
			// if the node is the first element , just remove the first element
			head = head.getNext();
			length--;
			return;
		}

		ListNode current = head, next = null;

		while ((next = current.getNext()) != null) {

			if (node.equals(next)) {
				// if next node matches to the input node , remove it
				current.setNext(next.getNext());
				length--;
				return;
			}

			// get ready for the next node
			current = next;
		}
	}

	@Override
	public synchronized void remove(int position) {
		// fix the position
		if (position < 0)
			position = 0;

		if (position > length)
			position = length;

		if (head == null) {
			// empty list , Do nothing
			return;
		}

		if (position == 0) {
			// remove the first element
			head = head.getNext();
		} else {
			// go to the position first
			ListNode temp = head;
			for (int i = 1; i < position; i++) {
				temp = temp.getNext();
			}

			// suppose you need to remove 3rd element , you reached at 2nd
			// element ,
			// now you have to join 2nd element with fourth element
			temp.setNext(temp.getNext().getNext());
		}

		length--;

	}

	/**
	 * Return the position of an given element in the list returns -1 if the
	 * element is not found
	 * 
	 * @param node
	 * @return position
	 */
	public synchronized int getPosition(ListNode node) {
		ListNode temp = head;
		int position = 0;

		while (temp != null) {
			if (temp.equals(node)) {
				return position;
			}

			position++;

			// advance the pointer
			temp = temp.getNext();
		}

		// return -1 if the element is not found or the list is empty
		return -1;
	}

	@Override
	public String toString() {
		String result = "[ ";

		if (head == null) {
			return result + " ]";
		}

		result = result + head.getData();
		ListNode temp = head.getNext();

		while (temp != null) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}

		return result + " ]";
	}

	/* (non-Javadoc)
	 * @see com.amiyasahu.linkedlist.singly.LinkedListI#length()
	 */
	@Override
	public int length() {
		return length;
	}

	/**
	 * Clears the list
	 */
	public synchronized void clear() {
		head = null;
		length = 0;
	}

	public ListNode getHead() {
		return head;
	}

	public void setHead(ListNode head) {
		this.head = head;
	}

	public int getLength() {
		return length;
	}

}
