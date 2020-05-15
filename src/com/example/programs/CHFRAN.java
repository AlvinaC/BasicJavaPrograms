package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CHFRAN {
	public static void main(String[] args) {
		try {
			CHFRAN t = new CHFRAN();
			List<Integer> list = new ArrayList<Integer>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				Integer n = Integer.parseInt(reader.readLine().trim());
				int[] l = new int[n];
				int[] r = new int[n];

				for (int j = 0; j < n; j++) {
					String[] s = reader.readLine().trim().split(" ");
					l[j] = Integer.parseInt(s[0]);
					r[j] = Integer.parseInt(s[1]);
				}

				t.sort(r, l, 0, n - 1);
				int count = t.select(l, r, n);
				list.add(count);
			}
			for (int i = 0; i < tc; i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// Function for Activity Selection
	public int select(int start[], int finish[], int n) {
		int j = 0;
		int listIndicator = 0;
		int count1 = 0;
		int count2 = 0;
		int dec1 = 0;
		int dec2 = 0;
		count1++;
		listIndicator = 1;
		for (int i = 1; i < n; i++) {
			if (start[i] > finish[j]) {
				if (listIndicator == 1) {

					count2++;
					listIndicator = 2;
				} else {
					count1++;
					listIndicator = 1;
				}
				j = i;
			} else if (start[i] == finish[j]) {

				if (listIndicator == 1) {
					count1++;
				} else {
					count2++;
				}
				j = i;
			}
		}
		if (count1 > 0 && count2 > 0) {
			return n - (count1 + count2);
		} else {
			return -1;
		}
	}

	// quicksort
	int[] sort(int[] a, int[] b, int low, int high) {
		objQS o;
		if (low < high) {
			o = partition(a, b, low, high);
			sort(o.a, o.b, low, o.pivotI - 1);
			sort(o.a, o.b, o.pivotI + 1, high);
		}
		return a;
	}

	objQS partition(int[] a, int[] b, int low, int high) {
		int pivot = a[high];
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (a[j] < pivot) {
				i++;
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				temp = b[j];
				b[j] = b[i];
				b[i] = temp;
			}
		}
		int temp = a[i + 1];
		a[i + 1] = a[high];
		a[high] = temp;
		temp = b[i + 1];
		b[i + 1] = b[high];
		b[high] = temp;
		return new objQS(a, b, i + 1);
	}

	class objQS {
		int[] a;
		int[] b;
		int pivotI;

		public objQS(int[] a, int[] b, int pivotI) {
			super();
			this.a = a;
			this.b = b;
			this.pivotI = pivotI;
		}
	}

}
