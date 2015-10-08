package com.amiyasahu.linkedlist.singly;

public interface SinglyLinkedList {

	/**
	 * Insert an element at the beginning of the linked list
	 * 
	 * @param node
	 */
	void insertAtBegin(ListNode node);

	/**
	 * Inserts an element at the end of the linked list
	 * 
	 * @param node
	 */
	void insertAtEnd(ListNode node);

	/**
	 * Insert an element at a specific position
	 * 
	 * @param node
	 * @param position
	 */
	void insert(ListNode node, int position);

	/**
	 * Remove an element from the beginning of the linked list
	 * 
	 * @return
	 */
	ListNode removeFromBegin();

	/**
	 * Remove an element from the End of the linked list
	 * 
	 * @return
	 */
	ListNode removeFromEnd();

	/**
	 * Remove an matched elemet from the linked list
	 * 
	 * @param node
	 */
	void removeMatched(ListNode node);

	/**
	 * Remove the particular node at the specific position
	 * 
	 * @param position
	 */
	void remove(int position);

	/**
	 * Returns the length of the linked list
	 * 
	 * @return
	 */
	int length();

}