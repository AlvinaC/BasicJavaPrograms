package com.example.programs;

import java.util.Scanner;

public class Series {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a no:");
		int n = s.nextInt();
		int[] arr = new int[n];
		int continueFromndex = 0;
		for (int i = n, j = 1; i > 0; i--, j = j + 2)
			arr[i - 1] = j;
		for (int i = n, j = 1, l = 0; i > 0 && l < arr.length; i--, j = j + 2, l++) {
			int start_index = ((1 + arr[l]) / 2) - 1;
			for (int h = 0; h < start_index; h++)
				System.out.print(" " + " ");
			for (int k = 1; k <= j; k++)
				System.out.print(i + " ");
			System.out.println();
			continueFromndex = j;
		}
		continueFromndex = continueFromndex - 2;
		for (int i = 2, j = continueFromndex, l = arr.length-2; i <= n && l < arr.length; i++, j = j - 2, l--) {
			int start_index = ((1 + arr[l]) / 2) - 1;
			for (int h = 0; h < start_index; h++)
				System.out.print(" " + " ");
			for (int k = 1; k <= j; k++)
				System.out.print(i + " ");
			System.out.println();
		}
	}
}
