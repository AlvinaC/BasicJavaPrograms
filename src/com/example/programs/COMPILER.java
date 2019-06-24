package com.example.programs;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

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

		char pop() {
			if (root == null) {
				// System.out.println("Empty");
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
			try (Scanner in = new Scanner(System.in)) {
				while (in.hasNextLine()) {
					try {
						String line = in.nextLine();
						Scanner lineScan = new Scanner(line);
						ArrayList<Integer> list = new ArrayList<Integer>();
						COMPILER compiler = new COMPILER();
						int tc = lineScan.nextInt();
						for (int i = 0; i < tc; i++) {
							COMPILER.StackLinkedList stack = compiler.new StackLinkedList();
							int count = 0;
							String st = lineScan.next();
							for (int j = 0; j < st.length(); j++) {
								if (st.charAt(j) == '<')
									stack.push('<');
								else {
									char popped = stack.pop();
									if (popped != ' ')
										count += 2;
								}
							}
							list.add(count);
						}
						for (int i = 0; i < tc; i++)
							System.out.println(list.get(i));
						// do something
					} catch (NoSuchElementException | IllegalStateException e) {

					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
