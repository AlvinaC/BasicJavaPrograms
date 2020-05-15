package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SUBSPLAY {
	public static void main(String[] args) {
		try {
			SUBSPLAY t = new SUBSPLAY();
			List<Integer> list = new ArrayList<Integer>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				Integer n = Integer.parseInt(reader.readLine().trim());
				String s = reader.readLine().trim();
				if (s.length() > n)
					list.add(0);
				else if (!t.checkIfLower(s)) {
					list.add(t.findDistance(s));
				} else
					list.add(0);
			}
			for (int i = 0; i < tc; i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private int findDistance(String s) {
		int min = 1000000;
		int index = -1;
		for (int i = 0; i < s.length(); i++) {
			if ((i + 1) < s.length()) {
				index = s.indexOf(s.charAt(i), i + 1);
			} else
				index = -1;
			if ((index - i) < min && index != -1)
				min = (index - i);
		}
		if (min != 1000000)
			return s.length() - min;
		return 0;
	}

	private Boolean checkIfLower(String s) {
		boolean hasUppercase = !s.equals(s.toLowerCase());
		return hasUppercase;
	}

	public int search(int L, int a, long modulus, int n, int[] nums) {
		// compute the hash of string S[:L]
		long h = 0;
		for (int i = 0; i < L; ++i)
			h = (h * a + nums[i]) % modulus;

		// already seen hashes of strings of length L
		HashSet<Long> seen = new HashSet();
		seen.add(h);
		// const value to be used often : a**L % modulus
		long aL = 1;
		for (int i = 1; i <= L; ++i)
			aL = (aL * a) % modulus;

		for (int start = 1; start < n - L + 1; ++start) {
			// compute rolling hash in O(1) time
			h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
			h = (h + nums[start + L - 1]) % modulus;
			if (seen.contains(h))
				return start;
			seen.add(h);
		}
		return -1;
	}

	public int longestDupSubstring(String S) {
		int n = S.length();
		// convert string to array of integers
		// to implement constant time slice
		int[] nums = new int[n];
		for (int i = 0; i < n; ++i)
			nums[i] = (int) S.charAt(i) - (int) 'a';
		// base value for the rolling hash function
		int a = 26;
		// modulus value for the rolling hash function to avoid overflow
		long modulus = (long) Math.pow(2, 32);

		// binary search, L = repeating string length
		int left = 1, right = n;
		int L;
		while (left != right) {
			L = left + (right - left) / 2;
			if (search(L, a, modulus, n, nums) != -1)
				left = L + 1;
			else
				right = L;
		}

		int start = search(left - 1, a, modulus, n, nums);
		int value = start != -1 ? S.substring(start, start + left - 1).length() : 0;
		return value;

	}

	static int longestRepeatedSubSeq(String str) {
		// THIS PART OF CODE IS SAME AS BELOW POST.
		// IT FILLS dp[][]
		// https://www.geeksforgeeks.org/longest-repeating-subsequence/
		// OR the code mentioned above.
		int n = str.length();
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++)
				dp[i][j] = 0;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				if (str.charAt(i - 1) == str.charAt(j - 1) && i != j)
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

		// THIS PART OF CODE FINDS
		// THE RESULT STRING USING DP[][]
		// Initialize result
		String res = "";

		// Traverse dp[][] from bottom right
		int i = n, j = n;
		while (i > 0 && j > 0) {
			// If this cell is same as diagonally
			// adjacent cell just above it, then
			// same characters are present at
			// str[i-1] and str[j-1]. Append any
			// of them to result.
			if (dp[i][j] == dp[i - 1][j - 1] + 1) {
				res = res + str.charAt(i - 1);
				System.out.println("index:" + (i - 1) + " " + (j - 1));
				i--;
				j--;
			}

			// Otherwise we move to the side
			// that that gave us maximum result
			else if (dp[i][j] == dp[i - 1][j])
				i--;
			else
				j--;
		}

		// Since we traverse dp[][] from bottom,
		// we get result in reverse order.
		String reverse = "";

		for (int k = res.length() - 1; k >= 0; k--) {
			reverse = reverse + res.charAt(k);
		}
		System.out.println(reverse);
		return reverse.length();
	}

	public static int LRSLength(String X, int m, int n, Map<String, Integer> lookup) {
// return if we have reached the end of either string
		if (m == 0 || n == 0) {
			return 0;
		}

// construct a unique map key from dynamic elements of the input
		String key = m + "|" + n;

// if sub-problem is seen for the first time, solve it and
// store its result in a map
		if (!lookup.containsKey(key)) {
// if characters at index m and n matches and index is different
			if (X.charAt(m - 1) == X.charAt(n - 1)) {

				lookup.put(key, LRSLength(X, m - 1, n - 1, lookup) + 1);
			} else {
// else if characters at index m and n don't match
				lookup.put(key, Integer.max(LRSLength(X, m, n - 1, lookup), LRSLength(X, m - 1, n, lookup)));
			}
		}

// return the sub-problem solution from the map
		return lookup.get(key);
	}

}
