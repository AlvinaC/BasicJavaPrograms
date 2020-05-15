package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FICE {

	public static void main(String[] args) {
		try {
			FICE fice = new FICE();
			List<Integer> list = new ArrayList<Integer>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				String[] strAry = reader.readLine().trim().split(" ");
				int n = Integer.parseInt(strAry[0]);
				int m = Integer.parseInt(strAry[1]);
				int[] memo = new int[n + 1];
				memo[0] = 0;
				memo[1] = 1;
				int ways = fice.findways(n, m, memo);
				int ans = (ways + ways) % m;
				list.add(ans);
			}
			for (int i = 0; i < tc; i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private int findways(int n, int m, int[] memo) {
		if (n == 0)
			return memo[0];
		if (n == 1)
			return memo[1];
		memo[n] = findways(n - 1, m, memo) + findways(n - 2, m, memo);
		return memo[n];
	}
}
