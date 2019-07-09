package com.example.programs;

import java.util.ArrayList;
import java.util.Scanner;

public class CHMOD {
	public static void main(String[] args) throws Exception {
		try {
			Scanner s = new Scanner(System.in);
			ArrayList<Long> list = new ArrayList<Long>();
			CHMOD c = new CHMOD();
			int n = s.nextInt();
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = s.nextLong();
			int q = s.nextInt();
			Integer[] p = c.findPrimes(1, 100);
			long[][] cf = c.findCumulativeFrequency(p, a);
			for (int i = 0; i < q; i++) {
				int left = s.nextInt();
				int right = s.nextInt();
				long mod = s.nextLong();
				long finalAns = 1;
				for (int j = 0; j < p.length; j++) {
					long re;
					if (left - 2 >= 0)
						re = cf[right - 1][j] - cf[left - 2][j];
					else
						re = cf[right - 1][j];
					long prod = c.pow(p[j], re, mod) % mod;
					finalAns = (finalAns * prod) % mod;
				}
				list.add(finalAns);
			}
			for (int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private long[][] findCumulativeFrequency(Integer[] p, long[] a) {
		long[][] cf = new long[a.length][p.length];
		for (int i = 0; i < a.length; i++) {
			if (i - 1 >= 0)
				System.arraycopy(cf[i - 1], 0, cf[i], 0, p.length);
			long quotient = a[i];
			while (quotient != 1) {
				for (int j = 0; j < p.length; j++) {
					long temp = quotient % p[j];
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

	private long pow(long base, long exp, long mod) {
		long ans = 1;
		while (exp > 0) {
			if (exp % 2 == 1)
				ans = (ans * base) % mod;
			exp = exp >> 1;
			base = (base * base) % mod;
		}
		return ans;
	}
}
