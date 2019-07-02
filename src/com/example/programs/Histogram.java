package com.example.programs;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

//https://www.youtube.com/watch?v=VNbkzsnllsU
//https://www.spoj.com/problems/HISTOGRA/

public class Histogram {

	class StackLinkedList {

		Node root = null;

		class Node {
			long index;
			Node next = null;

			Node(long val) {
				this.index = val;
			}
		}

		boolean push(long val) {
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

		long pop() {
			if (root == null) {
				return -1;
			} else {
				Node temp = root;
				root = temp.next;
				return temp.index;
			}
		}

		long peek() {
			if (root == null) {
				return -1;
			} else {
				long val = pop();
				push(val);
				return val;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		try {
			Scanner s = new Scanner(System.in);
			Histogram compiler = new Histogram();
			ArrayList<Long> list = new ArrayList<>();
			Long n;
			while ((n = s.nextLong()) != 0) {
				Long[] a = new Long[n.intValue()];
				for (int i = 0; i < n; i++)
					a[i] = s.nextLong();
				Histogram.StackLinkedList stackPos = compiler.new StackLinkedList();
				Histogram.StackLinkedList stackHeight = compiler.new StackLinkedList();
				Long maxArea = 0L;
				int j = 0;
				while (j < n) {
					if (stackHeight.isEmpty() || a[j] > stackHeight.peek()) {
						stackHeight.push(a[j]);
						stackPos.push(j++);
					} else {
						Long h;
						Long pos = -1L;
						while (!stackHeight.isEmpty() && stackHeight.peek() > a[j]) {
							h = stackHeight.pop();
							pos = stackPos.pop();
							Long area = h * (j - pos);
							if (area > maxArea)
								maxArea = area;
						}
						if (pos != -1 && stackHeight.peek() != a[j]) {
							stackHeight.push(a[j]);
							stackPos.push(pos);
						}
						j++;
					}
				}
				while (!stackHeight.isEmpty()) {
					Long h = stackHeight.pop();
					Long pos = stackPos.pop();
					Long area = h * (j - pos);
					if (area > maxArea)
						maxArea = area;
				}
				list.add(maxArea);
			}
			for (int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
