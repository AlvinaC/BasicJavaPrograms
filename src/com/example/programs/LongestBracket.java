package com.example.programs;

import java.util.Scanner;

public class LongestBracket {

	class StackLinkedList {

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

		boolean isEmpty() {
			if (root == null)
				return true;
			return false;
		}

		int pop() {
			if (root == null) {
				return ' ';
			} else {
				Node temp = root;
				root = temp.next;
				return temp.data;
			}
		}

		int peek() {
			if (root == null) {
				return ' ';
			} else {
				int val = pop();
				push(val);
				return val;
			}
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		LongestBracket compiler = new LongestBracket();
		LongestBracket.StackLinkedList stack = compiler.new StackLinkedList();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(')
				stack.push(i);
			else {
				int length = 0;
				if (!stack.isEmpty()) {
					int temp = i - stack.peek();
					length = length > temp ? length : temp;
					stack.pop();
					if (stack.isEmpty())
						stack.push(i);
				}
			}
		}
	}

}
