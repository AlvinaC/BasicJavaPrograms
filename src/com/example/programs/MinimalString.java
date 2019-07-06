package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinimalString {

	class StackLinkedList {

		Node root = null;

		class Node {
			char data;
			Node next = null;

			Node(char val) {
				this.data = val;
			}
		}

		boolean push(char val) {
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

		char pop() {
			if (root == null) {
				return ' ';
			} else {
				Node temp = root;
				root = temp.next;
				return temp.data;
			}
		}

		char peek() {
			if (root == null) {
				return ' ';
			} else {
				char val = pop();
				push(val);
				return val;
			}
		}
	}

	boolean shouldPop(char ele, char[] c) {
		int index = ele - 'a';
		for (int i = 0; i < index; i++) {
			if (c[i] != 0)
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = null;
			while (st == null || !st.hasMoreElements()) {
				st = new StringTokenizer(reader.readLine());
			}
			String str = st.nextToken();
			String result = "";
			char[] c = new char[26];
			MinimalString compiler = new MinimalString();
			MinimalString.StackLinkedList stack = compiler.new StackLinkedList();
			for (int i = 0; i < str.length(); i++)
				c[str.charAt(i) - 'a']++;
			for (int i = 0; i < str.length(); i++) {
				stack.push(str.charAt(i));
				c[str.charAt(i) - 'a']--;
				while (!stack.isEmpty() && compiler.shouldPop(stack.peek(), c) == false) {
					result = result + stack.pop();
				}
			}
			while (!stack.isEmpty())
				result = result + stack.pop();
			System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
