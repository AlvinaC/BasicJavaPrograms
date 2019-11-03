package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CHEFINSQ {

	public static void main(String[] args) throws Exception {
		try {
			CHEFINSQ f = new CHEFINSQ();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(reader.readLine().trim());
			ArrayList<Long> list = new ArrayList<Long>();
			for (int i = 0; i < tc; i++) {
				String[] integersInString1 = reader.readLine().split(" ");
				int n = Integer.parseInt(integersInString1[0]);
				int k = Integer.parseInt(integersInString1[1]);
				int[] a = new int[n];
				String[] integersInString2 = reader.readLine().split(" ");
				for (int j = 0; j < integersInString2.length; j++) {
					a[j] = Integer.parseInt(integersInString2[j]);
				}
				// int value = MaxIncreasingSub(a, n, k);
				a = f.sort(a, 0, n - 1);
				int countZ = f.countZ(a, k);
				int countY = f.countY(a, k);
				long value = f.binomialCoeff(countZ, countY);
				list.add(value);
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	long binomialCoeff(int n, int k) {
		long C[][] = new long[n + 1][k + 1];
		int i, j;

		// Calculate value of Binomial Coefficient in bottom up manner
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= Math.min(i, k); j++) {
				// Base Cases
				if (j == 0 || j == i)
					C[i][j] = 1;

				// Calculate value using previously stored values
				else
					C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
			}
		}

		return C[n][k];
	}

	int countZ(int[] a, int k) {
		int count = 0;
		int comparewith = a[k - 1];
		for (int i = 0; i < a.length; i++) {
			if (a[i] == comparewith)
				count++;
		}
		return count;

	}

	int countY(int[] a, int k) {
		int count = 0;
		int comparewith = a[k - 1];
		for (int i = 0; i < k; i++) {
			if (a[i] == comparewith)
				count++;
		}
		return count;

	}

	static int MaxIncreasingSub(int arr[], int n, int k) {
		// In the implementation dp[n][k] represents
		// maximum sum subsequence of length k and the
		// subsequence is ending at index n.
		int dp[][] = new int[n][k + 1], ans = -1;

		// Initializing whole multidimensional
		// dp array with value -1
		for (int i = 0; i < n; i++)
			for (int j = 0; j < k + 1; j++)
				dp[i][j] = -1;

		// For each ith position increasing subsequence
		// of length 1 is equal to that array ith value
		// so initializing dp[i][1] with that array value
		for (int i = 0; i < n; i++) {
			dp[i][1] = arr[i];
		}

		// Starting from 1st index as we have calculated
		// for 0th index. Computing optimized dp values
		// in bottom-up manner
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				for (int l = 1; l <= k - 1; l++) {

					// Proceed if value is pre calculated
					if (dp[j][l] != -1) {

						// Check for all the subsequences
						// ending at any j<i and try including
						// element at index i in them for
						// some length l. Update the maximum
						// value for every length.
						dp[i][l + 1] = Math.min(dp[i][l + 1], dp[j][l] + arr[i]);
					}
				}
			}
		}

		int count = 0;

		// The final result would be the maximum
		// value of dp[i][k] for all different i.
		for (int i = 0; i < n; i++) {
			if (dp[i][k] != -1) {
				if (ans == -1) {
					ans = dp[i][k];
					count++;
				} else if (dp[i][k] < ans) {
					count = 0;
					ans = dp[i][k];
					count++;
				} else if (ans == dp[i][k]) {
					count++;
				}
			}
		}

		// When no subsequence of length k is
		// possible sum would be considered zero
		// return (ans == -1) ? 0 : ans;
		return count;
	}

	// quicksort
	int[] sort(int[] a, int low, int high) {
		objQS o;
		if (low < high) {
			o = partition(a, low, high);
			sort(o.a, low, o.pivotI - 1);
			sort(o.a, o.pivotI + 1, high);
		}
		return a;
	}

	objQS partition(int[] a, int low, int high) {
		int pivot = a[high];
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (a[j] < pivot) {
				i++;
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
			}
		}
		int temp = a[i + 1];
		a[i + 1] = a[high];
		a[high] = temp;
		return new objQS(a, i + 1);
	}

	class objQS {
		int[] a;
		int pivotI;

		public objQS(int[] a, int pivotI) {
			super();
			this.a = a;
			this.pivotI = pivotI;
		}
	}
}
