package com.example.programs;

import java.util.ArrayList;
import java.util.Scanner;

//https://www.spoj.com/problems/STPAR/

public class STPAR {

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
			ArrayList<String> list = new ArrayList<String>();
			STPAR compiler = new STPAR();
			int n;

			while ((n = s.nextInt()) != 0) {
				int[] a = new int[n];
				for (int j = 0; j < n; j++)
					a[j] = s.nextInt();
				STPAR.StackLinkedList stack = compiler.new StackLinkedList();
				int h = 1;
				int k = 0;
				while (h <= n) {
					int topVal = stack.peek();
					if (topVal != -1 && topVal == h) {
						stack.pop();
						h++;
					} else if (k < n) {
						int ele = a[k];
						if (ele == h)
							h++;
						else {
							stack.push(ele);
						}
						k++;
					} else {
						break;
					}

				}
				if (stack.isEmpty())
					list.add("yes");
				else
					list.add("no");
			}
			for (int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
