package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FIBEASY {

	static int Moc = 1000000007;

	public static void main(String[] args) throws Exception {
		try {
			FIBEASY f = new FIBEASY();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(reader.readLine().trim());
			ArrayList<Long> list = new ArrayList<Long>();
			for (int i = 0; i < tc; i++) {
				BigInteger n = new BigInteger(reader.readLine().trim());
				Long no = f.getNo(n);
				list.add(no);
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
			// e.printStackTrace();
		}
	}

	private Long getNo(BigInteger n) {

		// or this block
		BigInteger size = n;

		int logval = n.bitLength() - 1;

		// double logval = Math.floor(Math.log(n.doubleValue()) / Math.log(2.0));
		double val = Math.pow(2, logval);
		// return fib(Math.round(val) - 1);
		return fib(Math.round(val) - 1);
	}

	static Long fib(long n) {
		ArrayList<Long> list = new ArrayList<Long>();
		list.add(0l);
		list.add(1l);

		for (int i = 2;; i++) {
			list.add((list.get(i - 1) + (list.get(i - 2))) % 10);
			if (list.get(list.size() - 1) == list.get(1) && list.get(list.size() - 2) == list.get(0))
				break;
		}

		Long value = n % (list.size() - 2);
		return list.get(value.intValue());

	}

	static BigInteger fibLogn(int n) {
		BigInteger F[][] = new BigInteger[][] { { BigInteger.ONE, BigInteger.ONE },
				{ BigInteger.ONE, BigInteger.ZERO } };
		if (n == 0)
			return BigInteger.ZERO;
		power(F, n - 1);
		return F[0][0];
	}

	static void multiply(BigInteger F[][], BigInteger M[][]) {
		BigInteger x = (F[0][0].multiply(M[0][0]).add(F[0][1].multiply(M[1][0]))).mod(BigInteger.TEN);
		BigInteger y = (F[0][0].multiply(M[0][1]).add(F[0][1].multiply(M[1][1]))).mod(BigInteger.TEN);
		BigInteger z = (F[1][0].multiply(M[0][0]).add(F[1][1].multiply(M[1][0]))).mod(BigInteger.TEN);
		BigInteger w = (F[1][0].multiply(M[0][1]).add(F[1][1].multiply(M[1][1]))).mod(BigInteger.TEN);

		F[0][0] = x;
		F[0][1] = y;
		F[1][0] = z;
		F[1][1] = w;
	}

	static void power(BigInteger F[][], int n) {
		if (n == 0 || n == 1)
			return;
		BigInteger M[][] = new BigInteger[][] { { BigInteger.ONE, BigInteger.ONE },
				{ BigInteger.ONE, BigInteger.ZERO } };

		power(F, n / 2);
		multiply(F, F);

		if (n % 2 != 0)
			multiply(F, M);
	}

}
