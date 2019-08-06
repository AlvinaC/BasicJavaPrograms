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
				BigInteger n = new BigInteger(integersInString[0].trim());
				BigInteger k = new BigInteger(integersInString[1].trim());
				if (k.equals(BigInteger.ONE))
					list.add("NO");
				else {
					BigInteger q = n.divide(k);
					if (q.compareTo(BigInteger.ZERO) == 1) {
						BigInteger l = q.divide(k);
						if (l.compareTo(BigInteger.ZERO) == 1) {
							BigInteger m = q.divide(l);

							if (m.equals(k))
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
			//e.printStackTrace();
		}
	}

}
