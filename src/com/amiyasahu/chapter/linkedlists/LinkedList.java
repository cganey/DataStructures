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

	public synchronized ListNode removeFromBegin() {
		ListNode node = head;

		if (node != null) {
			head = node.getNext();
			node.setNext(null);
		}

		return node;
	}

	public synchronized ListNode removeFromEnd(){
		
		if (head == null) {
			return null;
		}
		
		ListNode current = head , prev = null , next = head.getNext();
		
		if(next == null){
			//it has only 1 element 
			head = null ;
			return current ;
		}
		
		while((next = current.getNext()) != null){
			//reach to the and with having the current and previous reference 
			prev = current;
			current = next ;
		}
		
		//set the previous element next node to null 
		prev.setNext(null);
		
		return current ;
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

	public int length() {
		return length;
	}

}
