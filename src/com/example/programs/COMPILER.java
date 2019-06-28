package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//https://www.codechef.com/problems/COMPILER

public class COMPILER {
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
	}

	public static void main(String[] args) throws Exception {
		try {
			ArrayList<Integer> list = new ArrayList<Integer>();
			COMPILER compiler = new COMPILER();

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(reader.readLine().trim());

			for (int i = 0; i < tc; i++) {
				String p = reader.readLine().trim();
				COMPILER.StackLinkedList stack = compiler.new StackLinkedList();
				int count = 0;

				for (int j = 0; j < p.length(); j++) {
					if (p.charAt(j) == '<')
						stack.push('<');
					else {
						char popped = stack.pop();
						if (popped == ' ')
							break;
						if (stack.isEmpty())
							count = j + 1;
					}
				}
				list.add(count);
			}

			for (int i = 0; i < tc; i++)
				System.out.println(list.get(i));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
