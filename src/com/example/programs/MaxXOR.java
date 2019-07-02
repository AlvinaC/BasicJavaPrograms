package com.example.programs;

import java.util.Scanner;

//http://codeforces.com/problemset/problem/281/D

public class MaxXOR {

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

	public static void main(String[] args) throws Exception {
		try {
			Scanner s = new Scanner(System.in);
			MaxXOR compiler = new MaxXOR();
			int n = s.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = s.nextInt();
			}
			int max = 0;
			MaxXOR.StackLinkedList stack = compiler.new StackLinkedList();
			for (int i = 0; i < n; i++) {
				if (stack.isEmpty())
					stack.push(a[i]);
				else if (stack.peek() < a[i]) {
					while (!stack.isEmpty() && stack.peek() < a[i]) {
						int xor = a[i] ^ stack.peek();
						if (xor > max)
							max = xor;
						stack.pop();
					}
					int xor = a[i] ^ stack.peek();
					if (xor > max)
						max = xor;
					stack.push(a[i]);
				} else {
					int xor = a[i] ^ stack.peek();
					if (xor > max)
						max = xor;
					stack.push(a[i]);
				}
			}
			System.out.println(max);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
