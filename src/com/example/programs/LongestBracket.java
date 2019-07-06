package com.example.programs;

import java.util.Scanner;

//https://codeforces.com/contest/5/problem/C

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

	public static void main(String[] args) throws Exception {
		try {
			Scanner s = new Scanner(System.in);
			String str = s.next();
			int length = 0;
			int count = 0;
			LongestBracket compiler = new LongestBracket();
			LongestBracket.StackLinkedList stack = compiler.new StackLinkedList();
			LongestBracket.StackLinkedList number = compiler.new StackLinkedList();
			stack.push(-1);
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(')
					stack.push(i);
				else {
					if (!stack.isEmpty()) {
						stack.pop();
						if (stack.isEmpty())
							stack.push(i);
						else {
							int temp = i - stack.peek();
							if (number.isEmpty()) {
								number.push(temp);
							} else if (!number.isEmpty() && number.peek() > temp) {

							} else {
								while (!number.isEmpty() && number.peek() != temp) {
									number.pop();
								}
								number.push(temp);
							}
						}
					}
				}
			}
			if (!number.isEmpty()) {
				length = number.peek();
				while (!number.isEmpty()) {
					count = count + 1;
					number.pop();
				}
				System.out.println(length + " " + count);
			} else {
				System.out.println(length + " " + "1");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
