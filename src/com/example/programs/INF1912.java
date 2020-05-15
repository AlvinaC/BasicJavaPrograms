package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class INF1912 {
	public static void main(String[] args) {
		try {
			List<String> list = new ArrayList<String>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				String[] str = reader.readLine().trim().split(" ");
				Integer n = Integer.parseInt(str[0]);
				Integer k = Integer.parseInt(str[1]);
				HashSet<Integer> r = new HashSet<Integer>();
				HashSet<Integer> c = new HashSet<Integer>();
				for (int j = 0; j < k; j++) {
					str = reader.readLine().trim().split(" ");
					r.add(Integer.parseInt(str[0]));
					c.add(Integer.parseInt(str[1]));
				}
				int tot = n * n;
				int count = (tot) - (r.size() * n) - ((n - r.size()) * c.size());
				if (count > 0) {
					int gcd = findGcd(count, tot);

					if (gcd == 1) {
						String res = count + " " + tot;
						list.add(res);
					} else {
					
						String res = count/gcd + " " + tot/gcd;
						list.add(res);
					}

				} else
					list.add("Impossible");

			}
			for (int i = 0; i < tc; i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static int findGcd(int a, int b) {
		int remainder = 0;
		while ((a % b) != 0) {
			remainder = a % b;
			a = b;
			b = remainder;
		}
		return remainder;
	}
}
