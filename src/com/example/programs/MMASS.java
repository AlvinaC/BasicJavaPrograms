package com.example.programs;

import java.util.Scanner;

//https://www.spoj.com/problems/MMASS/

public class MMASS {

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
				return -1;
			} else {
				Node temp = root;
				root = temp.next;
				return temp.data;
			}
		}

		int peek() {
			if (root == null) {
				return -1;
			} else {
				int val = pop();
				push(val);
				return val;
			}
		}
	}

	private int value(char mychar) {
		switch (mychar) {
		case 'H':
			return 1;
		case 'O':
			return 16;
		case 'C':
			return 12;
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		try {
			Scanner s = new Scanner(System.in);
			MMASS mass = new MMASS();
			MMASS.StackLinkedList stack = mass.new StackLinkedList();
			String formula = s.next();
			for (int i = 0; i < formula.length(); i++) {
				char mychar = formula.charAt(i);
				int value = mass.value(mychar);
				if (mychar == '(')
					stack.push(mychar);
				else if (mychar == ')') {
					int sum = 0;
					while (!stack.isEmpty() && stack.peek() != '(') {
						sum = sum + stack.pop();
					}
					if (!stack.isEmpty() && stack.peek() == '(')
						stack.pop();
					else
						return;
					stack.push(sum);
				} else if (value != -1) {
					stack.push(value);
				} else {
					int val = 0;
					if (!stack.isEmpty()) {
						val = stack.pop();
						stack.push(val * Character.getNumericValue(mychar));
					} else
						return;
				}
			}
			int sum = 0;
			while (!stack.isEmpty())
				sum = sum + stack.pop();
			System.out.println(sum);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
