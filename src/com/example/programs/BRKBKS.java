package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BRKBKS {

	public static void main(String[] args) {
		try {
			BRKBKS t = new BRKBKS();
			List<Integer> list = new ArrayList<Integer>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				String[] str = reader.readLine().trim().split(" ");
				int s = Integer.parseInt(str[0]);
				int w1 = Integer.parseInt(str[1]);
				int w2 = Integer.parseInt(str[2]);
				int w3 = Integer.parseInt(str[3]);
				int wholeSum = w1 + w2 + w3;
				if (s >= 1 && s <= 8 && w1 >= 1 && w1 <= 2 && w2 >= 1 && w2 <= 2 && w3 >= 1 && w3 <= 2
						&& wholeSum <= 6) {
					int[] a1 = new int[] { w1, w2, w3 };
					int[] a2 = new int[] { w3, w2, w1 };

					int sum = s;
					int count = 0;
					if (w1 + w2 + w3 <= s)
						list.add(1);
					else {
						for (int j = 0; j < 3; j++) {
							if (sum - a1[j] == 0) {
								count = count + 1;
								sum = s;
							} else if (sum - a1[j] > 0) {
								sum = sum - a1[j];
							} else {
								count = count + 1;
								sum = s ;
								j--;
							}
						}
						if (sum > 0 && sum != s)
							count = count + 1;
						list.add(count);
					}
				}
			}
			for (int i = 0; i < tc; i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
