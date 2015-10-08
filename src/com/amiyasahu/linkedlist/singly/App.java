package com.amiyasahu.linkedlist.singly;

public class App {
	public static void main(String[] args) {

		SinglyLinkedListImpl linkedList = new SinglyLinkedListImpl();
		System.out.println(linkedList); // [ ]

		linkedList.insertAtBegin(new ListNode(10));
		linkedList.insertAtBegin(new ListNode(20));
		linkedList.insertAtBegin(new ListNode(30));
		System.out.println(linkedList); // [ 30,20,10 ]

		linkedList.insert(new ListNode(100), 2);
		linkedList.insert(new ListNode(300), 3);
		linkedList.insert(new ListNode(50), 3);
		linkedList.insert(new ListNode(540), 3);
		System.out.println(linkedList); // [ 30,20,100,540,50,300,10 ]

		linkedList.remove(2);
		System.out.println(linkedList); // [ 30,20,540,50,300,10 ]

		linkedList.removeFromBegin();
		linkedList.removeFromEnd();
		System.out.println(linkedList); // [ 20,540,50,300 ]

		linkedList.removeMatched(new ListNode(540));
		System.out.println(linkedList);// [ 20,50,300 ]

		System.out.println(linkedList.length());// 3
		System.out.println(linkedList.getPosition(new ListNode(50)));// 1
		System.out.println(linkedList.getPosition(new ListNode(300)));// 2
	}
}
