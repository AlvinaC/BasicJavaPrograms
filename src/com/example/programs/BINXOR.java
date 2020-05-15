package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BINXOR {
	public static void main(String[] args) {
		try {
			BINXOR t = new BINXOR();
			List<Integer> list = new ArrayList<Integer>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				String a = reader.readLine().trim();
				String b = reader.readLine().trim();
				Map<Character, Long> aC = t.findFrequency(a);
				Map<Character, Long> bC = t.findFrequency(b);
				Long orders1 = t.findFactorial(aC);
				Long orders2 = t.findFactorial(bC);
				

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private Long findFactorial(Map<Character, Long> aC) {
		Long mod = 1000000007l;
		Long denom = 1l;
		Long nume = 0l;
		Long result = 0l;
		for (Long count : aC.values()) {
			denom = (denom * findFactorial(count));
			nume = nume + count;
		}
		nume = findFactorial(nume);
		result = nume / denom;
		return result;
	}

	private Long findFactorial(Long no) {
		Long mod = 1000000007l;
		Long f = 1l;
		for (int i = 1; i <= no; i++)
			f = (f * i) % mod;
		return f;
	}

	private HashMap<Character, Long> findFrequency(String a) {
		HashMap<Character, Long> map = new HashMap<Character, Long>();
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1l);
		}
		return map;
	}
}
