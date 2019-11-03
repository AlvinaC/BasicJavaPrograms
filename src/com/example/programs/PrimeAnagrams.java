package com.example.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrimeAnagrams {

	static long initProduct = Long.MAX_VALUE;
	static boolean[] primes;
	static int[] res;

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String s = reader.readLine().trim();
			int[] arr = primes(s);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	private static int[] primes(String a) {
		primes = genPrimes();
		String[] s = new String[a.length()];
		for (int i = 0; i < s.length; i++)
			s[i] = a.charAt(i) + "";
		permute(s, 0, s.length - 1);
		if (res != null && res.length > 0) {
			Arrays.sort(res);
			System.out.println(res[0] + " " + res[1] + " " + res[2]);
		}
		if (res == null) {
			res = new int[] {};
		}
		return res;
	}

	private static boolean[] genPrimes() {
		boolean[] primes = new boolean[999999 + 1];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		for (int i = 2; i * i <= primes.length - 1; i++) {
			if (primes[i]) {
				for (int j = 2 * i; j <= primes.length - 1; j += i) {
					primes[j] = false;
				}
			}
		}
		return primes;
	}

	static void permute(String[] s, int start, int end) {
		if (start == end) {
			String a = "";
			for (int i = 0; i < s.length; i++)
				a = a + s[i];
			for (int i = 1; i < a.length(); i++) {
				for (int j = i + 1; j < a.length(); j++) {
					String first = a.substring(0, i);
					String sec = a.substring(i, j);
					String third = a.substring(j, a.length());
					if (first.charAt(0) == '0' || sec.charAt(0) == '0' || third.charAt(0) == '0')
						continue;
					int f = Integer.parseInt(first);
					int se = Integer.parseInt(sec);
					int t = Integer.parseInt(third);
					if (primes[f] && primes[se] && primes[t] && (f * se * t) < initProduct) {
						initProduct = (f * se * t);
						res = new int[] { f, se, t };
					}
				}
			}

		} else {
			for (int i = start; i <= end; i++) {
				String temp = s[start];
				s[start] = s[i];
				s[i] = temp;
				permute(s, start + 1, end);
				temp = s[i];
				s[i] = s[start];
				s[start] = temp;
			}
		}
	}
}
