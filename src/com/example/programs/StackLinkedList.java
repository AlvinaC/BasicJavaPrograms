package com.example.programs;

public class StackLinkedList {

	Node root = null;

	class Node {
		int data;
		Node next = null;

		Node(int val) {
			this.data = val;
		}
	}

	boolean push(int val) {
		if (root == null) {
			Node a = new Node(val);
			root = a;
			return true;
		} else {
			Node a = new Node(val);
			Node temp = root;
			root = a;
			root.next = temp;
			return true;
		}
	}

	int pop() {
		if (root == null) {
			System.out.println("Empty");
			return -1;
		} else {
			Node temp = root;
			root = temp.next;
			return temp.data;
		}
	}

	public static void main(String[] args) {
		StackLinkedList stack = new StackLinkedList();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(2);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
