package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class DSTAPLS {

	public static void main(String[] args) throws Exception {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			ArrayList<String> list = new ArrayList<>();
			int tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				String[] integersInString = reader.readLine().split(" ");
				Double n = Double.parseDouble(integersInString[0].trim());
				Double k = Double.parseDouble(integersInString[1].trim());
				if (k == 1.0)
					list.add("NO");
				else {
					Double q = n / k;
					Double l = q / k;
					Double m = q / l;
					if (m.equals(k))
						list.add("NO");
					else
						list.add("YES");
				}
			}
			for (int i = 0; i < tc; i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
			// e.printStackTrace();
		}
	}

}
