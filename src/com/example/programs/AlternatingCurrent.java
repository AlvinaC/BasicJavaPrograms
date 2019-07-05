package com.example.programs;

import java.util.Scanner;

//http://codeforces.com/contest/343/problem/B

public class AlternatingCurrent {

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

	public static void main(String[] args) throws Exception{
		try {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		AlternatingCurrent compiler = new AlternatingCurrent();
		AlternatingCurrent.StackLinkedList stack = compiler.new StackLinkedList();
		for (int i = 0; i < str.length(); i++) {
			if (stack.isEmpty())
				stack.push(str.charAt(i));
			else
			{
				if(stack.peek()==str.charAt(i))
					stack.pop();
				else
					stack.push(str.charAt(i));
			}
		}
		if(stack.isEmpty())
			System.out.println("Yes");
		else
			System.out.println("No");
		}
		catch (Exception e) { 
			// TODO: handle exception
		}
	}

}
