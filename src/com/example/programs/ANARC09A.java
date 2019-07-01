package com.example.programs;

import java.util.ArrayList;
import java.util.Scanner;

//https://www.spoj.com/problems/ANARC09A/

public class ANARC09A {

	class StackLinkedList {

		Node root = null;
		int length = 0;

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
				++length;
				return true;
			} else {
				Node a = new Node(val);
				Node temp = root;
				root = a;
				root.next = temp;
				++length;
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
				--length;
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

		int length() {
			return length;
		}
	}

	public static void main(String[] args) throws Exception {
		try {
			Scanner s = new Scanner(System.in);
			ANARC09A compiler = new ANARC09A();
			ArrayList<Integer> list = new ArrayList<Integer>();
			String str;
			while (!s.hasNext("[-]*")) {
				str = s.next();
				ANARC09A.StackLinkedList stack = compiler.new StackLinkedList();
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '{') {
						stack.push('{');
					}
					if (str.charAt(i) == '}') {
						if (!stack.isEmpty() && stack.peek() == '{')
							stack.pop();
						else
							stack.push('}');
					}
				}
				if (stack.isEmpty())
					list.add(0);
				else {
					int sum = 0;
					while (!stack.isEmpty()) {
						char second = stack.pop();
						char first = stack.pop();
						if (first == second)
							sum = sum + 1;
						else if (first == '}' && second == '{')
							sum = sum + 2;
					}
					list.add(sum);
				}
			}
			for (int i = 0; i < list.size(); i++)
				System.out.println(i + 1 + ". " + list.get(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
