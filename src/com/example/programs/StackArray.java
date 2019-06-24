package com.example.programs;

public class StackArray {

	int top;
	int MAX = 1000;
	int[] a = new int[1000];

	StackArray() {
		top = -1;
	}

	boolean push(int val) {

		if (top > MAX) {
			System.out.println("overflow");
			return false;
		} else {
			a[++top] = val;
		}
		return true;
	}

	int pop() {
		if (top < 0) {
			System.out.println("underflow");
			return -1;
		} else {
			return a[top--];
		}
	}

	public static void main(String[] args) {
		StackArray s = new StackArray();
		s.push(1);
		s.push(2);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());

	}

}
