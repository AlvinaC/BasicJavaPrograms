package com.example.programs;

import java.util.ArrayList;
import java.util.Scanner;

public class RecursiveCounting {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int length = s.nextInt();
			int[] a = new int[length];
			for (int i = 0; i < length; i++) {
				a[i] = s.nextInt();
			}
			int count = count(a, length - 1);
			System.out.print(count);
		} catch (Exception e) {

		}
	}

	private static int count(int[] a, int n) {
		if (n == -1)
			return 0;
		int c = count(a, n - 1);
		if (a[n] == 42)
			return c + 1;
		else
			return c;
	}

}
