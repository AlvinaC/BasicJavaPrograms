package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class CHFM {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(reader.readLine().trim());
			CHFM c = new CHFM();
			ArrayList<Long> list = new ArrayList<Long>();
			for (int i = 0; i < tc; i++) {
				int n = Integer.parseInt(reader.readLine().trim());
				double sum = 0;
				String[] integersInString = reader.readLine().split(" ");
				long[] a = new long[n];
				for (int j = 0; j < integersInString.length; j++) {
					a[j] = Long.parseLong(integersInString[j]);
					sum = sum + a[j];
				}
				double mean = sum / n;
				int h = 0;
				ArrayList<Long> mylist = new ArrayList<>();
				while (h < n) {
					double newMean = (mean * n - a[h]) / (n - 1);
					if (newMean == mean)
						mylist.add(new Long(h + 1));
					h++;
				}
				if (mylist.size() > 0)
					list.add(mylist.get(0));
				else
					list.add(-1l);
			}
			for (int i = 0; i < tc; i++) {
				if (list.get(i) != -1)
					System.out.println(list.get(i));
				else
					System.out.println("Impossible");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

