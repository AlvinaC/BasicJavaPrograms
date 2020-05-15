package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CHPINTU {
	public static void main(String[] args) {
		try {
			CHPINTU t = new CHPINTU();
			List<Integer> list = new ArrayList<Integer>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				String[] s = reader.readLine().trim().split(" ");
				int n = Integer.parseInt(s[0]);
				int m = Integer.parseInt(s[1]);
				int[] a = new int[n];
				s = reader.readLine().trim().split(" ");
				for (int j = 0; j < n; j++) {
					a[j] = Integer.parseInt(s[j]);
				}
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				s = reader.readLine().trim().split(" ");
				for (int j = 0; j < n; j++) {
					int value = Integer.parseInt(s[j]);
					if (map.containsKey(a[j]))
						map.put(a[j], map.get(a[j]) + value);
					else
						map.put(a[j], value);
				}
				Map<Integer, Integer> sortedMap = map.entrySet().stream().sorted(Entry.comparingByValue())
						.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
				list.add(sortedMap.entrySet().stream().findFirst().get().getValue());
			}
			for (int i = 0; i < tc; i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
