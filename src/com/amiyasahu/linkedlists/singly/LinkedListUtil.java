package com.amiyasahu.linkedlists.singly;

public class LinkedListUtil {

	/**
	 * Checks the linked list length
	 * 
	 * @param headNode
	 * @return
	 */
	public int linkedListLength(ListNode headNode) {
		int length = 0;
		ListNode currentNode = headNode;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}
}
