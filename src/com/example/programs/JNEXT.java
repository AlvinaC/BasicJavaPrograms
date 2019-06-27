package com.example.programs;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

//https://www.spoj.com/problems/JNEXT/

public class JNEXT {

	class StackLinkedList {

		Node root = null;

		class Node {
			BigInteger data;
			Node next = null;

			Node(BigInteger val) {
				this.data = val;
			}
		}

		boolean push(BigInteger val) {
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

		BigInteger pop() {
			if (root == null) {
				return BigInteger.valueOf(-1);
			} else {
				Node temp = root;
				root = temp.next;
				return temp.data;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		try {
			Scanner s = new Scanner(System.in);
			ArrayList<BigInteger> list = new ArrayList<BigInteger>();
			JNEXT compiler = new JNEXT();
			int tc = s.nextInt();
			for (int i = 0; i < tc; i++) {
				int n = s.nextInt();
				JNEXT.StackLinkedList stack = compiler.new StackLinkedList();
				for (int j = 0; j < n; j++)
					stack.push(s.nextBigInteger());
				boolean done = false;
				while (!stack.isEmpty()) {
					if (!done) {
						BigInteger first = stack.pop();
						BigInteger second = stack.pop();
						if (second == BigInteger.valueOf(-1)) {
							list.add(BigInteger.valueOf(-1));
							break;
						}
						String concatA = String.valueOf(first) + String.valueOf(second);
						BigInteger combinedA = new BigInteger(concatA);
						String concatB = String.valueOf(second) + String.valueOf(first);
						BigInteger combinedB = new BigInteger(concatB);
						if (combinedA.compareTo(combinedB) == 1) {
							stack.push(combinedA);
							done = true;
						} else
							stack.push(combinedB);
					} else {
						BigInteger first = stack.pop();
						BigInteger second = stack.pop();
						if (second == BigInteger.valueOf(-1)) {
							list.add(first);
							break;
						}
						String concat = String.valueOf(second) + String.valueOf(first);
						BigInteger combined = new BigInteger(concat);
						stack.push(combined);
					}
				}
			}
			for (int i = 0; i < tc; i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
