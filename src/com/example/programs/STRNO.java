package com.example.programs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class STRNO {
	InputStream is;
	PrintWriter out;
	String INPUT = "";

	public static void main(String[] args) throws Exception {
		new STRNO().run();
	}

	void run() throws Exception {
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		if (!INPUT.isEmpty())
			tr(System.currentTimeMillis() - s + "ms");
	}

	void solve() {

		for (int T = ni(); T > 0; T--) {
			String x = ns();
			int k = ni();
			if (k == 1)
				out.println(1);
			else {
				ArrayList<BigInteger> list = getPrimeFactors(new BigInteger(x));
				if (k <= list.size()) {
					out.println(1);
				} else
					out.println(0);
			}
		}
	}

	ArrayList<BigInteger> primeFactors = new ArrayList<BigInteger>();
	final BigInteger TWO = BigInteger.valueOf(2);
	BigInteger randomNum = BigInteger.ONE;
	boolean fail;

	public void factorRho(BigInteger num) {
		if (num.compareTo(BigInteger.ONE) == 0)
			return;
		if (num.isProbablePrime(300)) {
			primeFactors.add(num);
			return;
		}
		BigInteger divisor = rho(num);
		if (fail)
			assignRandomNum();
		factorRho(divisor);
		factorRho(num.divide(divisor));
	}

	public ArrayList<BigInteger> getPrimeFactors(BigInteger num) {
		primeFactors.clear();
		factorRho(num);
		return primeFactors;
	}

	private BigInteger rho(BigInteger num) {
		BigInteger x1 = TWO, x2 = TWO, divisor = BigInteger.ONE;
		if (num.mod(TWO).compareTo(BigInteger.ZERO) == 0)
			return TWO;
		while (divisor.compareTo(BigInteger.ONE) == 0) {
			x1 = f(x1).mod(num);
			x2 = f(f(x2)).mod(num);
			divisor = x1.subtract(x2).gcd(num);
		}
		if (divisor.equals(num)) {
			fail = true;
		}
		return divisor;
	}

	private void assignRandomNum() {
		randomNum = BigInteger.valueOf((long) (100 * Math.random() - 50));
		fail = false;
	}

	private BigInteger f(BigInteger x) {
		return x.multiply(x).add(randomNum);
	}

	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;

	private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	private boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	private int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	private double nd() {
		return Double.parseDouble(ns());
	}

	private char nc() {
		return (char) skip();
	}

	private String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	private char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	private char[][] nm(int n, int m) {
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}

	private int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}

	private long[] nl(int n) {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nl();
		return a;
	}

	private int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	private long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	private void tr(Object... o) {
		if (INPUT.length() > 0)
			System.out.println(Arrays.deepToString(o));
	}

}
