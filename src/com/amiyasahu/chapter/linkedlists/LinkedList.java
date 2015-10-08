package com.amiyasahu.chapter.linkedlists;

public class LinkedList {
	private ListNode head;
	private int length;

	public LinkedList() {
		length = 0;
		head = null;
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

	public void setLength(int length) {
		this.length = length;
	}

	public synchronized void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}

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

	public synchronized void insert(int data, int position) {
		// fix the position
		if (position < 0)
			position = 0;

		if (position > length)
			position = length;

		if (head == null) {
			// for a empty linked list
			head = new ListNode(data);
		} else if (position == 0) {
			// for inserting at the beginning
			ListNode temp = new ListNode(data);
			temp.setNext(head);
			head = temp;
		} else {
			ListNode temp = head;
			// TODO
		}

		length++;
	}

	@Override
	public String toString() {
		String result = "[";

		if (head == null) {
			return result + "]";
		}

		result = result + head.getData();
		ListNode temp = head.getNext();

		while (temp != null) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}

		return result;
	}

}
