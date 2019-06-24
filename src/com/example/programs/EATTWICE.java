package com.example.programs;

import java.util.ArrayList;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

//https://www.codechef.com/problems/EATTWICE

public class EATTWICE {
	public static void main(String[] args) throws Exception {
		try {
			Scanner s = new Scanner(System.in);
			ArrayList<Integer> alist = new ArrayList<>();
			EATTWICE c = new EATTWICE();
			int tc = s.nextInt();
			for (int i = 0; i < tc; i++) {
				int n = s.nextInt();
				int m = s.nextInt();
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				for (int k = 0; k < n; k++) {
					int day = s.nextInt();
					int taste = s.nextInt();
					if (map.containsKey(day)) {
						if (map.get(day) < taste)
							map.put(day, taste);
					} else
						map.put(day, taste);
				}

				int score = 0;
				int[] a = new int[map.size()];
				int k = 0;
				for (Integer value : map.values()) {
					a[k] = value.intValue();
					k++;
				}
				map.clear();
				int[] sorted = c.sort(a, 0, a.length - 1);
				score = score + a[a.length - 1];
				score = score + a[a.length - 2];
				alist.add(score);
				
			}
			for (int i = 0; i < tc; i++) {
				System.out.println(alist.get(i));
			}
		} catch (Exception e) {

		}
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

	static class obj {
		int day;
		int taste;

		public obj(int day, int taste) {
			this.day = day;
			this.taste = taste;
		}

		public boolean equals(Object o) {
			if (o instanceof obj) {
				obj toCompare = (obj) o;
				return this.day == toCompare.day;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return day;
		}
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
