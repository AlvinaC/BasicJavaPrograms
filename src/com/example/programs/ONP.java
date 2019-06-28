package com.example.programs;

import java.util.ArrayList;
import java.util.Scanner;

import com.example.programs.STPAR.StackLinkedList;
import com.example.programs.STPAR.StackLinkedList.Node;

public class ONP {

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

	private boolean isLetterOrDigit(char c) {
		return (c >= 'a' && c <= 'z');
	}

	private int precedence(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		try {
			Scanner s = new Scanner(System.in);
			ArrayList<String> list = new ArrayList<String>();
			ONP compiler = new ONP();
			int tc = s.nextInt();
			for (int i = 0; i < tc; i++) {
				String exp = s.next();
				String result = "";
				ONP.StackLinkedList stack = compiler.new StackLinkedList();
				for (int j = 0; j < exp.length(); j++) {
					char mychar = exp.charAt(j);
					if (compiler.isLetterOrDigit(mychar))
						result = result + mychar;
					else if (mychar == '(')
						stack.push(mychar);
					else if (mychar == ')') {
						while (!stack.isEmpty() && stack.peek() != '(')
							result = result + stack.pop();
						if (!stack.isEmpty() && stack.peek() == '(')
							stack.pop();
						else
							return;

					} else {
						while (!stack.isEmpty() && compiler.precedence(mychar) <= compiler.precedence(stack.peek())) {
							if (stack.peek() == '(')
								return;
							result = result + stack.pop();
						}
						stack.push(mychar);
					}
				}
				while (!stack.isEmpty()) {
					if (stack.peek() == '(')
						return;
					result = result + stack.pop();
				}
				list.add(result);
			}
			for (int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
