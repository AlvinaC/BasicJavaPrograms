package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NOKIA {
	public static void main(String[] args) {
		try {
			NOKIA nokia = new NOKIA();
			List<Integer> list = new ArrayList<Integer>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				String[] line = reader.readLine().trim().split(" ");
				Integer n = Integer.parseInt(line[0]);
				Integer m = Integer.parseInt(line[1]);
				int[] minA = new int[n + 1];
				int[] maxA = new int[n + 1];
				minA[0] = 0;
				maxA[0] = 0;
				int min = nokia.calculateMinUsedLength(n, m, minA);
				int max = nokia.calculateMaxUsedLength(n, m, maxA);
				 if (m > max)
					list.add(m - max);
				else if (m < min)
					list.add(-1);
				else
					list.add(0);
			}
			for (int i = 0; i < tc; i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private int calculateMinUsedLength(Integer n, Integer m, int[] minA) {
		if (n == 0)
			return minA[0];
		minA[n] = (n + 1) + calculateMinUsedLength(n / 2, m, minA) + calculateMinUsedLength(n - (n / 2) - 1, m, minA);
		return minA[n];
	}

	private int calculateMaxUsedLength(Integer n, Integer m, int[] maxA) {
		if (n == 0)
			return maxA[0];
		maxA[n] = (n + 1) + calculateMaxUsedLength(n - 1, m, maxA);
		return maxA[n];
	}

}
