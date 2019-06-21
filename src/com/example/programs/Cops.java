package com.example.programs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Cops {

	int[] h;

	public static void main(String[] args) throws Exception {
		try {
			Scanner s = new Scanner(System.in);
			ArrayList<Integer> list = new ArrayList<>();
			Cops c = new Cops();
			int tc = s.nextInt();
			for (int i = 0; i < tc; i++) {
				int m = s.nextInt();
				int x = s.nextInt();
				int y = s.nextInt();
				int[] a = new int[m];
				for (int j = 0; j < m; j++) {
					a[j] = s.nextInt();
				}
				int sum = c.checkNow(x * y, a);
				list.add(sum);
			}
			for (int i = 0; i < tc; i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	int checkNow(int max, int[] a) {
		h = sort(a, 0, a.length - 1);
		for (int i = 1; i <= 2; i++) {
			int index = findNearestCop(h, i);
			System.out.println("" + index);
		}
		return 0;
	}

	private int findNearestCop(int[] a, int thief) {
		return search(a, 0, a.length, thief, -1);
	}

	int search(int[] a, int l, int h, int key, int prevMid) {
		int index = -1;
		int mid = (l + h) / 2;
		if (a[mid] == key)
			return mid;
		if (prevMid != -1)
			if (a[mid] < key && a[prevMid] > key)
				return prevMid;
		if (prevMid != -1)
			if (a[mid] > key && a[prevMid] < key)
				return prevMid;
		if (prevMid != -1) {
			if (a[mid] > key && a[prevMid] > key)
				index = search(a, l, mid - 1, key, mid);
		} else if (a[mid] > key)
			index = search(a, l, mid - 1, key, mid);
		if (prevMid != -1) {
			if (a[mid] < key && a[prevMid] < key)
				index = search(a, mid + 1, h, key, mid);
		} else if (a[mid] < key)
			index = search(a, mid + 1, h, key, mid);
		return index;
	}

	// quicksort
	int[] sort(int[] a, int low, int high) {
		obj o;
		if (low < high) {
			o = partition(a, low, high);
			sort(o.a, low, o.pivotI - 1);
			sort(o.a, o.pivotI + 1, high);
		}
		return a;
	}

	obj partition(int[] a, int low, int high) {
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
		return new obj(a, i + 1);
	}

	class obj {
		int[] a;
		int pivotI;

		public obj(int[] a, int pivotI) {
			super();
			this.a = a;
			this.pivotI = pivotI;
		}

	}

}
