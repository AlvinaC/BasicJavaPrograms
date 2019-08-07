package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MMAX {

	public static void main(String[] args) throws Exception {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(reader.readLine().trim());
			ArrayList<Long> list = new ArrayList<Long>();
			for (int i = 0; i < tc; i++) {
				int n = Integer.parseInt(reader.readLine().trim());
				long[] a = new long[n];
				long[] aCopyA = new long[n];
				long[] aCopyB = new long[n];
				String k = reader.readLine().trim();
				int now = 0;
				for (int j = 0; j < k.length(); j++) {
					now = (now * 10) % n;
					now = (now + k.charAt(j) - '0') % n;
				}
				// long k = Long.parseLong(reader.readLine().trim());
				// long rem = now % n;
				long rem = now;
				int j = n - 1;
				while (rem > 0) {
					a[j] = 1;
					rem--;
					j--;
				}
				int x = 0, y = n - 1, z = 0;
				while (x < y) {
					aCopyA[z] = a[x];
					aCopyB[z] = a[y];
					z++;
					aCopyA[z] = a[y];
					aCopyB[z] = a[x];
					z++;
					x++;
					y--;
				}
				if (x == y) {
					aCopyA[z] = a[x];
					aCopyB[z] = a[x];
				}
				x = 0;
				long sumA = 0;
				long sumB = 0;
				while (x < n && x + 1 < n) {
					sumA = sumA + (Math.abs(aCopyA[x + 1] - aCopyA[x]));
					sumB = sumB + (Math.abs(aCopyB[x + 1] - aCopyB[x]));
					x++;
				}
				if (sumA > sumB)
					list.add(new Long(sumA));
				else
					list.add(new Long(sumB));
			}
			for (int i = 0; i < tc; i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
