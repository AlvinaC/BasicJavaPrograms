package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SNUG_FIT {
	public static void main(String[] args) {
		try {
			List<BigInteger> list = new ArrayList<BigInteger>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				Integer n = Integer.parseInt(reader.readLine().trim());
				int[] a = new int[n];
				int[] b = new int[n];
				String[] str1 = reader.readLine().trim().split(" ");
				String[] str2 = reader.readLine().trim().split(" ");
				for (int j = 0; j < str1.length; j++) {
					a[j] = Integer.parseInt(str1[j]);
				}
				for (int j = 0; j < str1.length; j++) {
					b[j] = Integer.parseInt(str2[j]);
				}
				Arrays.sort(a);
				Arrays.sort(b);
				BigInteger sum = BigInteger.valueOf(0);
				for (int j = 0; j < a.length; j++) {
					if (a[j] < b[j])
						sum = sum.add(BigInteger.valueOf(a[j]));
					else
						sum = sum.add(BigInteger.valueOf(b[j]));
				}
				list.add(sum);
			}
			for (int i = 0; i < tc; i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
