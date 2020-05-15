package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CHEFSUM {
	public static void main(String[] args) {
		try {
			List<Integer> list = new ArrayList<Integer>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				Integer n = Integer.parseInt(reader.readLine().trim());
				int[] no = new int[n];
				BigInteger sum = BigInteger.valueOf(0l);
				String[] str = reader.readLine().trim().split(" ");
				for (int j = 0; j < n; j++) {
					no[j] = Integer.parseInt(str[j]);
					sum = sum.add(BigInteger.valueOf(no[j]));
				}
				int res = findIndex(no, sum);
				list.add(res);

			}
			for (int i = 0; i < tc; i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {

		}
	}

	private static int findIndex(int[] no, BigInteger sum) {
		BigInteger firstSum = BigInteger.valueOf(no[0]);
		BigInteger min = firstSum.add(sum);
		int minIndex = 1;
		for (int j = 1; j < no.length; j++) {
			firstSum = firstSum.add(BigInteger.valueOf(no[j]));
			sum = sum.subtract(BigInteger.valueOf(no[j - 1]));
			BigInteger ongSum = firstSum.add(sum);
			if (min.compareTo(ongSum) == 1) {
				min = ongSum;
				minIndex = j + 1;
			}
		}
		return minIndex;
	}

}
