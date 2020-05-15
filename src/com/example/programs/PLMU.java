package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PLMU {
	public static void main(String[] args) {
		try {
			PLMU t = new PLMU();
			List<Long> list = new ArrayList<Long>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				Integer n = Integer.parseInt(reader.readLine().trim());
				Long c0 = 0l;
				Long c2 = 0l;
				String[] s = reader.readLine().trim().split(" ");
				Long ans = 0l;
				for (int j = 0; j < n; j++) {
					if (Long.parseLong(s[j]) == 0)
						c0++;
					else if (Long.parseLong(s[j]) == 2)
						c2++;
				}

				if (c0 != 0 && c2 != 0) {
					c0 = c0 - 1;
					c2 = c2 - 1;
					ans = ((c0 * (c0 + 1) / 2) + (c2 * (c2 + 1) / 2));
				} else if (c0 != 0) {
					c0 = c0 - 1;
					ans = (c0 * (c0 + 1) / 2);
				} else if (c2 != 0) {
					c2 = c2 - 1;
					ans = (c2 * (c2 + 1) / 2);
				}
				list.add(ans);
			}
			for (int i = 0; i < tc; i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
