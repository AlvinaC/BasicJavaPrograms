package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BINADD {
	public static void main(String[] args) {
		try {
			BINADD t = new BINADD();
			List<Long> list = new ArrayList<Long>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				String a = reader.readLine().trim();
				String b = reader.readLine().trim();
				list.add(t.findLong(a, b));
			}
			for (int i = 0; i < tc; i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private Long find(String a, String b) {
		BigInteger one = new BigInteger(a, 2);
		BigInteger two = new BigInteger(b, 2);
		Long count = 0l;
		while (two.compareTo(BigInteger.valueOf(0)) == 1) {
			BigInteger u = one.xor(two);
			BigInteger v = one.and(two);
			one = u;
			two = v.shiftLeft(1);
			count++;
		}
		return count;
	}

	private Long findLong(String a, String b) {
		Long one = Long.parseLong(a, 2);
		Long two = Long.parseLong(b, 2);
		Long count = 0l;
		while (two > 0) {
			Long u = one ^ two;
			Long v = one & two;
			one = u;
			two = v << 1;
			count++;
		}
		return count;
	}
}
