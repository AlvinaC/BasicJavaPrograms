package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CASH {
	public static void main(String[] args) {
		try {
			List<Integer> list = new ArrayList<Integer>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				String[] str = reader.readLine().trim().split(" ");
				Integer n = Integer.parseInt(str[0]);
				Integer k = Integer.parseInt(str[1]);
				int[] a = new int[n];
				str = reader.readLine().trim().split(" ");
				for (int j = 0; j < n; j++) {
					a[j] = Integer.parseInt(str[j]);
				}
				list.add(findR(a, k));
			}
			for (int i = 0; i < tc; i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {

		}
	}

	private static int findR(int[] a, Integer k) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i] % k;
		}
		Arrays.sort(b);
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (b[i] == 0)
				continue;
			else {
				int diff = Math.abs(k - b[i]);
				if (diff <= sum)
					sum = sum - diff;
				else
					sum = sum + b[i];

			}
		}
		return sum;
	}
}
