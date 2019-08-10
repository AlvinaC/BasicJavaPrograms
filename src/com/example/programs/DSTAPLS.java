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
				long n = Long.parseLong(integersInString[0].trim());
				long k = Long.parseLong(integersInString[1].trim());
				if (k == 1.0)
					list.add("NO");
				else {
					long q = n / k;
					if (q % k == 0) {
						long l = q / k;
						if (q % l == 0) {
							long m = q / l;
							if (m == k)
								list.add("NO");
							else
								list.add("YES");
						} else
							list.add("YES");
					} else
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
