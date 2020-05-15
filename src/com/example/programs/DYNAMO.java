package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DYNAMO {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Integer tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				/*
				 * The commented is the logic
				 */

				int n = Integer.parseInt(reader.readLine().trim());
				long a = Long.parseLong(reader.readLine().trim());
				long s = (long) ((2 * (Math.pow(10, n) - 1)) + a + 2);
				System.out.println(s);
				System.out.flush();
				long b = Long.parseLong(reader.readLine().trim());
				long c = (long) ((Math.pow(10, n) - 1) - b) + 1;
				System.out.println(c);
				System.out.flush();
				long d = Long.parseLong(reader.readLine().trim());
				long e = (long) ((Math.pow(10, n) - 1) - d) + 1;
				System.out.println(e);
				System.out.flush();
				int res = Integer.parseInt(reader.readLine().trim());

				/*
				 * The above logic using Bigintegers
				 */

//				int n = Integer.parseInt(reader.readLine().trim());
//				BigInteger a = new BigInteger(reader.readLine().trim());
//				BigInteger s = BigInteger.valueOf(2)
//						.multiply(BigInteger.valueOf(10l).pow(n).subtract(BigInteger.valueOf(1l))).add(a)
//						.add(BigInteger.valueOf(2l));
//				System.out.println(s);
//				System.out.flush();
//				BigInteger b = new BigInteger(reader.readLine().trim());
//				BigInteger c = BigInteger.valueOf(10l).pow(n).subtract(BigInteger.valueOf(1l)).subtract(b)
//						.add(BigInteger.valueOf(1l));
//				System.out.println(c);
//				System.out.flush();
//				BigInteger d = new BigInteger(reader.readLine().trim());
//				BigInteger e = BigInteger.valueOf(10l).pow(n).subtract(BigInteger.valueOf(1l)).subtract(d)
//						.add(BigInteger.valueOf(1l));
//				System.out.println(e);
//				System.out.flush();
//				int res = Integer.parseInt(reader.readLine().trim());
//				if (res == -1)
//					return;
			}
			System.out.flush();
			System.out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static long randLong(long leftLimit, long rightLimit) {
		long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
		return generatedLong;
	}
}
