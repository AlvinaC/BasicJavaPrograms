package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MSNSADM1 {

	public static void main(String[] args) throws Exception {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			ArrayList<Long> list = new ArrayList<>();
			int tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				int n = Integer.parseInt(reader.readLine().trim());
				String[] integersInString = reader.readLine().split(" ");
				long[] a = new long[n];
				for (int j = 0; j < integersInString.length; j++) {
					a[j] = Long.parseLong(integersInString[j]);
				}
				integersInString = reader.readLine().split(" ");
				long[] b = new long[n];
				for (int j = 0; j < integersInString.length; j++) {
					b[j] = Long.parseLong(integersInString[j]);
				}
				Long max = 0l;
				for (int j = 0; j < n; j++) {
					long score = a[j] * 20 - b[j] * 10;
					if (score > 0 && score > max)
						max = score;
				}
				list.add(max);
			}
			for (int i = 0; i < tc; i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
