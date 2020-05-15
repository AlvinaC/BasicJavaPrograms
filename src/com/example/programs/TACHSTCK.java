package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TACHSTCK {

	public static void main(String[] args) {
		try {
			TACHSTCK t = new TACHSTCK();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String[] strAry = reader.readLine().trim().split(" ");
			int n = Integer.parseInt(strAry[0]);
			int d = Integer.parseInt(strAry[1]);
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(reader.readLine().trim());
			}
			// int[] a = t.quciksort(inp, 0, n - 1);
			Arrays.sort(a);
			int i = 0;
			int count = 0;
			while (i < n && i + 1 < n) {
				if (a[i + 1] - a[i] <= d) {
					count++;
					i = i + 2;
				} else
					i++;
			}
			System.out.println(count);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private int[] quciksort(int[] a, int low, int high) {
		obj o;
		if (low < high) {
			o = partition(a, low, high);
			quciksort(o.a, 0, o.pivot - 1);
			quciksort(o.a, o.pivot + 1, high);
		}
		return a;
	}

	private obj partition(int[] a, int low, int high) {
		int i = low - 1;
		int pivot = a[high];
		for (int j = low; j <= high - 1; j++) {
			if (a[j] < pivot) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		int temp = a[i + 1];
		a[i + 1] = a[high];
		a[high] = temp;
		return new obj(a, i + 1);
	}

	class obj {
		int[] a;
		int pivot;

		obj(int[] a, int pivot) {
			this.a = a;
			this.pivot = pivot;
		}
	}
}
