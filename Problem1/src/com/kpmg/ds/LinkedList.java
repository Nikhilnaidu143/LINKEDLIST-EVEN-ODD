package com.kpmg.ds;

import java.util.Scanner;

public class LinkedList {

	Node head;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void addFirst(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void addLast(int data) {
		Node currNode = head;
		while (currNode.next != null) {
			currNode = currNode.next;
		}
		Node newNode = new Node(data);
		currNode.next = newNode;
	}

	public void printLinkedList() {
		Node currNode = head;
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}

	public void segregateEvenOdd() {
		Node evenStart = null;
		Node evenEnd = null;
		Node oddStart = null;
		Node oddEnd = null;
		Node currentNode = head;

		while (currentNode != null) {
			int value = currentNode.data;
			if (value % 2 == 0) {
				if (evenStart == null) {
					evenStart = currentNode;
					evenEnd = evenStart;
				} else {
					evenEnd.next = currentNode;
					evenEnd = evenEnd.next;
				}
			} else {
				if (oddStart == null) {
					oddStart = currentNode;
					oddEnd = oddStart;
				} else {
					oddEnd.next = currentNode;
					oddEnd = oddEnd.next;
				}
			}
			currentNode = currentNode.next;
		}
		if (evenStart == null || oddStart == null) {
			return;
		}
		evenEnd.next = oddStart;
		oddEnd.next = null;
		head = evenStart;
	}

	public void sortAscending() {
		Node currentNode = head, nextNode = null;
		int tempNode;
		if (currentNode == null) {
			return;
		} else {
			while(currentNode != null) {
				nextNode = currentNode.next;
				while(nextNode != null) {
					if(currentNode.data > nextNode.data) {
						tempNode = currentNode.data;
						currentNode.data = nextNode.data;
						nextNode.data = tempNode;
					}
					nextNode = nextNode.next;
				}
				currentNode = currentNode.next;
			}
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter length :- ");
		int length = input.nextInt();

		LinkedList linkedList = new LinkedList();

		for (int i = 0; i < length; i++) {
			System.out.println("Enter data :- ");
			if (i == 0) {
				linkedList.addFirst(input.nextInt());
			} else {
				linkedList.addLast(input.nextInt());
			}
		}
		input.close();
		System.out.println("Original Linked List :- ");
		linkedList.printLinkedList();
		
		System.out.println("\nModified Linked List :- ");
		linkedList.segregateEvenOdd();
		linkedList.printLinkedList();
		
		System.out.println("\nSorted Linked List in Ascending Order :- ");
		linkedList.sortAscending();
		linkedList.printLinkedList();
	}

}
