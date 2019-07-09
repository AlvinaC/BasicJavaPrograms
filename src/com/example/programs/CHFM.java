package com.example.programs;

import java.util.ArrayList;
import java.util.Scanner;

//https://www.codechef.com/JULY19B/problems/CHFM

public class CHFM {

	public static void main(String[] args) throws Exception {
		try {
			Scanner s = new Scanner(System.in);
			int tc = s.nextInt();
			ArrayList<Long> list = new ArrayList<Long>();
			for (int i = 0; i < tc; i++) {
				int n = s.nextInt();
				ArrayList<Long> a = new ArrayList<Long>();
				double sum = 0;
				for (int j = 0; j < n; j++) {
					a.add(s.nextLong());
					sum = sum + a.get(j);
				}
				double mean = sum / n;
				double remainder = sum % n;
				if (remainder != 0) {
					list.add(-1L);
					continue;
				}
				

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
