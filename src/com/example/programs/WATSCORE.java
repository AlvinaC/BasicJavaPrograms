package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WATSCORE {

	public static void main(String[] args) {
		try {
			WATSCORE t = new WATSCORE();
			List<Integer> list = new ArrayList<Integer>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				Integer n = Integer.parseInt(reader.readLine().trim());
				Integer[] s = new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
				for (int j = 0; j < n; j++) {
					String[] pisi = reader.readLine().trim().split(" ");
					Integer pi = Integer.parseInt(pisi[0]);
					Integer si = Integer.parseInt(pisi[1]);
					if (si > s[pi - 1])
						s[pi - 1] = si;
				}
				Integer sum = 0;
				for (int j = 0; j < s.length - 3; j++)
					sum = sum + s[j];
				list.add(sum);
			}
			for (int i = 0; i < tc; i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
