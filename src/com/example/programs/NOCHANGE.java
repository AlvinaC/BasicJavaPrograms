package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NOCHANGE {

	public static void main(String[] args) {
		try {
			NOCHANGE t = new NOCHANGE();
			List<Integer> list = new ArrayList<Integer>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				String[] str = reader.readLine().trim().split(" ");
				Integer n = Integer.parseInt(str[0]);
				Integer p = Integer.parseInt(str[1]);
				str = reader.readLine().trim().split(" ");
				int[] a = new int[n];
				for (int j = 0; j < n; j++) {
					a[j] = Integer.parseInt(str[j]);
				}
				List<List<Integer>> possibleWays = new ArrayList<>();
				List<Integer> countOfCoins = new ArrayList<>();
				t.makeChange(a, p, 0, countOfCoins, possibleWays);

			}
		} catch (Exception e) {

		}
	}

	private static int makeChange(int[] coinSet, int amount, int startCoinIdx, List<Integer> coinsSoFar,
			List<List<Integer>> possibleWays) {
		if (startCoinIdx == coinSet.length) {
			if (amount == 0) {
				possibleWays.add(coinsSoFar);
				System.out.println(coinsSoFar);
			}

			return 0;
		}
		for (int count = 0; (count * coinSet[startCoinIdx]) <= amount; count++) {
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < coinsSoFar.size(); i++)
				temp.add(coinsSoFar.get(i));
			for (int i = 0; i < count; i++)
				temp.add(coinSet[startCoinIdx]);
			makeChange(coinSet, amount - (count * coinSet[startCoinIdx]), startCoinIdx + 1, temp, possibleWays);
			temp.clear();
		}
		return 0;
	}

}
