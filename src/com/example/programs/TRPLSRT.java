package com.example.programs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.stream.IntStream;

public class TRPLSRT {
	InputStream is;
	PrintWriter out;
	String INPUT = "";

	public static void main(String[] args) throws Exception {
		new TRPLSRT().run();
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
			Integer n = ni();
			Integer k = ni();
			int[] a = na(n);
			int[] b = new int[n];
			System.arraycopy(a, 0, b, 0, a.length);
			Arrays.sort(b);
			int i = 0, j = 0, l = 0;
			int ops = 0;
			ArrayList<Integer> indices = new ArrayList<Integer>();
			l1: while (i < n) {
				if (a[i] == b[i]) {
					i++;
					continue;
				} else {
					while (true) {
						j = i + 1;
						j = findJ(j, a, b);
						if (j != -1)
							l = j + 1;
						else {
							ops = -1;
							break l1;
						}
						l = findL(l, i, a, b);
						if (l != -1) {
							// found i,j,k
							int min = a[l];
							while (a[i] != min) {
								indices.add(i);
								indices.add(j);
								indices.add(l);
								indices.add(-1);
								int temp = a[i];
								a[i] = a[l];
								a[l] = a[j];
								a[j] = temp;
								ops++;

							}
							break;
						} else
							continue;
					}
				}
			}
			if (ops == -1)
				out.println(-1);
			else {
				if (ops == 0)
					out.println(0);
				else {
					out.println(ops);
					for (int m = 0; m < indices.size(); m++) {
						if (indices.get(m) == -1)
							out.println();
						else
							out.print(indices.get(m) + 1 + " ");
					}
				}
			}

		}
	}

	int findJ(int j, int[] a, int[] b) {
		int n = a.length;
		while (j < n - 1 && a[j] == b[j]) {
			j++;
		}
		if (!(j < n - 1))
			return -1;
		return j;
	}

	int findL(int l, int i, int[] a, int[] b) {
		int n = a.length;
		while (l < n && a[l] == b[l] && a[l] < a[i] && a[l] < a[i]) {
			l++;
		}
		if (!(l < n))
			return -1;
		return l;
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
