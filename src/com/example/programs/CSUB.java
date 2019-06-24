package com.example.programs;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class CSUB {
	public static void main(String[] args) throws Exception {
		try {
			Scanner s = new Scanner(System.in);
			ArrayList<BigInteger> list = new ArrayList<BigInteger>();
			int tc = s.nextInt();
			for (int i = 0; i < tc; i++) {
				int n = s.nextInt();
				String st = s.next();
				BigInteger count = BigInteger.ZERO;
				for (int j = 0; j < n; j++)
					if (st.charAt(j) == '1')
						count = count.add(BigInteger.ONE);
				BigInteger val = count.multiply((count.add(BigInteger.ONE))).divide(BigInteger.valueOf(2));
				list.add(val);
			}

			for (int i = 0; i < tc; i++) {
				System.out.println(list.get(i));

			}
		} catch (Exception e) {

		}
	}

}
