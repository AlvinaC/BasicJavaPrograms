package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

//https://www.codechef.com/JULY19B/problems/CHFM

public class CHFM {

	public static void main(String[] args) throws Exception {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(reader.readLine().trim());
			CHFM c = new CHFM();
			ArrayList<Long> list = new ArrayList<Long>();
			for (int i = 0; i < tc; i++) {
				int n = Integer.parseInt(reader.readLine().trim());
				double sum = 0;
				String[] integersInString = reader.readLine().split(" ");
				long[] a = new long[n];
				for (int j = 0; j < integersInString.length; j++) {
					a[j] = Long.parseLong(integersInString[j]);
					sum = sum + a[j];
				}
				double mean = sum / n;
				double remainder = sum % n;
				if (remainder != 0.0) {
					list.add(-1L);
					continue;
				}
				long[] sorted = c.sort(a, 0, a.length - 1);
				Long index = findFirstOccurrence(sorted, (long) mean);
				list.add(index);
			}
			for (int i = 0; i < tc; i++) {
				if (list.get(i) != -1)
					System.out.println(list.get(i));
				else
					System.out.println("Impossible");
			}
		} catch (Exception e) {
			// TODO: handle exception
			// e.printStackTrace();
		}
	}

	public static Long findFirstOccurrence(long[] A, long x) {
		// search space is A[left..right]
		int left = 0;
		int right = A.length - 1;

		// initialize the result by -1
		int result = -1;
		int count = 0;

		// iterate till search space contains at-least one element
		while (left <= right) {
			// find the mid value in the search space and
			// compares it with key value
			int mid = (left + right) / 2;

			// if key is found, update the result and
			// go on searching towards left (lefter indices)
			if (x == A[mid]) {
				result = mid;
				count++;
				right = mid - 1;
			}

			// if key is less than the mid element, discard right half
			else if (x < A[mid]) {
				right = mid - 1;
			}

			// if key is more than the mid element, discard left half
			else {
				left = mid + 1;
			}
		}

		// return the leftmost index or -1 if the element is not found
		if (count > 1)
			return new Long(result + 1);
		else
			return new Long(A[result]);
	}

	// quicksort
	long[] sort(long[] a, int low, int high) {
		objQS o;
		if (low < high) {
			o = partition(a, low, high);
			sort(o.a, low, o.pivotI - 1);
			sort(o.a, o.pivotI + 1, high);
		}
		return a;
	}

	objQS partition(long[] a, int low, int high) {
		long pivot = a[high];
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (a[j] < pivot) {
				i++;
				long temp = a[j];
				a[j] = a[i];
				a[i] = temp;
			}
		}
		long temp = a[i + 1];
		a[i + 1] = a[high];
		a[high] = temp;
		return new objQS(a, i + 1);
	}

	class objQS {
		long[] a;
		int pivotI;

		public objQS(long[] a, int pivotI) {
			super();
			this.a = a;
			this.pivotI = pivotI;
		}
	}

}
