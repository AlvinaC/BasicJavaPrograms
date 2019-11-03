package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GFG {
	public static int MAX = 100;
	public static int inf = 1000000;

	// Table used for memoization
	public static int[][] dp;

	// intialize
	static void initialize(int n, int k) {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < k; j++)
				dp[i][j] = -1;
	}

	// Function to find non-decreasing sequence
	// of size k with minimum sum
	static int solve(int arr[], int i, int k) {
		// If already computed
		if (dp[i][k] != -1)
			return dp[i][k];

		// Corner cases
		if (i < 0)
			return inf;
		if (k == 1) {
			int ans = inf;
			for (int j = 0; j <= i; j++) {
				ans = Math.min(ans, arr[j]);
			}
			return ans;
		}

		// Recursive computation
		int ans = inf;
		for (int j = 0; j < i; j++) {
			ans = Math.min(ans, Math.min(solve(arr, j, k), solve(arr, j, k - 1) + arr[i]));
		}

		dp[i][k] = ans;

		return dp[i][k];
	}

	static int countSubSeq(int i, int sum, int cnt, int a[], int n, int totSum, int k) {

		// Base case
		if (i == n) {
			// Check for the sum
			// and at least a single element
			// is in the sub-sequence
			if (sum == totSum && cnt == k) {
				return 1;
			} else {
				return 0;
			}
		}

		int ans = 0;

		// Do not take the number in
		// the current sub-sequence
		ans += countSubSeq(i + 1, sum, cnt, a, n, totSum, k);

		// Take the number in the
		// current sub-sequence
		ans += countSubSeq(i + 1, sum + a[i], cnt + 1, a, n, totSum, k);

		return ans;
	}

	public static void main(String[] args) throws Exception {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(reader.readLine().trim());
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < tc; i++) {
				String[] integersInString1 = reader.readLine().split(" ");
				int n = Integer.parseInt(integersInString1[0]);
				int k = Integer.parseInt(integersInString1[1]);
				int[] a = new int[n];
				String[] integersInString2 = reader.readLine().split(" ");
				for (int j = 0; j < integersInString2.length; j++) {
					a[j] = Integer.parseInt(integersInString2[j]);
				}
				dp = new int[n][k + 1];
				initialize(n, k + 1);
				int value = solve(a, n - 1, k);
				int count = countSubSeq(0, 0, 0, a, n, value, k);
				list.add(count);
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
			// e.printStackTrace();
		}
	}
}
