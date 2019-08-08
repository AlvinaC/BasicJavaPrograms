package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CHEFDIL {
	public static void main(String[] args) throws Exception {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			ArrayList<String> list = new ArrayList<>();
			int tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				String s = reader.readLine().trim();
				int[] a = new int[s.length()];
				for (int j = 0; j < s.length(); j++) {
					a[j] = Character.getNumericValue(s.charAt(j));
				}
				int j = 0;
				long count = 0;
				while (j < a.length) {
					if (a[j] == 1) {
						boolean inc = false;
						boolean dec = false;
						a[j] = -1;
						count++;
						if (j - 1 >= 0) {
							if (a[j - 1] == 1)
								a[j - 1] = 0;
							if (a[j - 1] == 0) {
								a[j - 1] = 1;
								dec = true;
							}
						}
						if (j + 1 < a.length) {
							if (a[j + 1] == 1)
								a[j + 1] = 0;
							if (a[j + 1] == 0) {
								a[j + 1] = 1;
								inc = true;
							}
						}
						if (dec)
							j--;
						else
							j++;
					} else if (a[j] == 0)
						j++;
					else {
						j++;
					}
				}
				if (count == a.length)
					list.add("WIN");
				else
					list.add("LOSE");
			}
			for (int i = 0; i < tc; i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
