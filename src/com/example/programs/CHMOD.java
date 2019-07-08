package com.example.programs;

import java.util.ArrayList;
import java.util.Scanner;

public class CHMOD {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		CHMOD c = new CHMOD();
		int n = s.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = s.nextInt();
		int q = s.nextInt();
		Integer[] p = c.findPrimes(1, 100);
		int[][] cf = c.findCumulativeFrequency(p, a);
		for (int i = 0; i < q; i++) {
			int left = s.nextInt();
			int right = s.nextInt();
			int mod = s.nextInt();
			
		}
	}

	private int[][] findCumulativeFrequency(Integer[] p, int[] a) {
		int[][] cf = new int[a.length][p.length];
		for (int i = 0; i < a.length; i++) {
			int quotient = a[i];
			while (quotient != 1) {
				for (int j = 0; j < p.length; j++) {
					int temp = quotient % p[j];
					if (temp == 0) {
						cf[i][j]++;
						quotient = quotient / p[j];
						break;
					}
				}
			}
		}
		return cf;
	}

	private Integer[] findPrimes(int x, int y) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = x; i <= y; i++)
			if (isPrime(i))
				list.add(i);
		Integer[] a = list.toArray(new Integer[0]);
		return a;
	}

	private boolean isPrime(int no) {
		if (no == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(no); i++)
			if (no % i == 0)
				return false;
		return true;
	}
}
