package com.amiyasahu.chapter.linkedlists;

public class App {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		System.out.println(linkedList);
		linkedList.insertAtBegin(new ListNode(10));
		linkedList.insertAtBegin(new ListNode(20));
		linkedList.insertAtBegin(new ListNode(30));
		System.out.println(linkedList);
		linkedList.insert(new ListNode(100), 2);
		linkedList.insert(new ListNode(300), 3);
		System.out.println(linkedList);
	}
}
