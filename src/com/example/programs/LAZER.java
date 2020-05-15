package com.example.programs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LAZER {
	InputStream is;
	PrintWriter out;
	String INPUT = "";

	public static void main(String[] args) throws Exception {
		new LAZER().run();
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
			long n = nl();
			long q = nl();
			long[] x = new long[(int) n];
			Arrays.setAll(x, i -> i + 1);
			long[] y = nl((int) n);
			for (int i = 1; i <= q; i++) {
				long x1 = nl();
				long x2 = nl();
				long _y = nl();
				Point p1 = new Point(x1, _y);
				Point q1 = new Point(x2, _y);
				int[] indexes = IntStream.range(0, y.length).filter(j -> y[j] >= p1.y && x[j] <= q1.x && x[j] >= p1.x)
						.toArray();
				long count = 0;
				HashMap<Long, Long> seg = new HashMap<Long, Long>();
				for (int j = 0; j < indexes.length; j++) {
					Point a = new Point(x[indexes[j]], y[indexes[j]]);
					Point b = null, c = null;
					if (indexes[j] - 1 >= 0 && indexes[j] - 1 < n) {
						b = new Point(x[indexes[j] - 1], y[indexes[j] - 1]);
					}
					if (indexes[j] + 1 >= 0 && indexes[j] + 1 < n) {
						c = new Point(x[indexes[j] + 1], y[indexes[j] + 1]);
					}
					if (b != null) {
						if (!seg.containsKey(x[indexes[j] - 1])) {
							seg.put(x[indexes[j] - 1], x[indexes[j]]);
							boolean val = doIntersect(p1, q1, b, a);
							if (val) {
								if ((p1.x != a.x || p1.y != a.y) && (q1.x != b.x || q1.y != b.y))
									count++;
							}
//							out.println(p1.x + " " + p1.y + "," + q1.x + " " + q1.y + "," + b.x + " " + b.y + "," + a.x
//									+ " " + a.y + val);
						}
					}
					if (c != null) {
						if (!seg.containsKey(x[indexes[j]])) {
							seg.put(x[indexes[j]], x[indexes[j] + 1]);
							boolean val = doIntersect(p1, q1, a, c);
							if (val) {
								if ((p1.x != c.x || p1.y != c.y) && (q1.x != a.x || q1.y != a.y))
									count++;
							}
//							out.println(p1.x + " " + p1.y + "," + q1.x + " " + q1.y + "," + a.x + " " + a.y + "," + c.x
//									+ " " + c.y + val);
						}
					}
				}
				out.println(count);
			}
		}
	}

	// Given three colinear points p, q, r, the function checks if
	// point q lies on line segment 'pr'
	static boolean onSegment(Point p, Point q, Point r) {
		if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) && q.y <= Math.max(p.y, r.y)
				&& q.y >= Math.min(p.y, r.y))
			return true;

		return false;
	}

	// To find orientation of ordered triplet (p, q, r).
	// The function returns following values
	// 0 --> p, q and r are colinear
	// 1 --> Clockwise
	// 2 --> Counterclockwise
	static int orientation(Point p, Point q, Point r) {
		// See https://www.geeksforgeeks.org/orientation-3-ordered-points/
		// for details of below formula.
		long val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

		if (val == 0)
			return 0; // colinear

		return (val > 0) ? 1 : 2; // clock or counterclock wise
	}

	// The main function that returns true if line segment 'p1q1'
	// and 'p2q2' intersect.
	static boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
		// Find the four orientations needed for general and
		// special cases
		int o1 = orientation(p1, q1, p2);
		int o2 = orientation(p1, q1, q2);
		int o3 = orientation(p2, q2, p1);
		int o4 = orientation(p2, q2, q1);

		// General case
		if (o1 != o2 && o3 != o4)
			return true;

		// Special Cases
		// p1, q1 and p2 are colinear and p2 lies on segment p1q1
		if (o1 == 0 && onSegment(p1, p2, q1))
			return true;

		// p1, q1 and q2 are colinear and q2 lies on segment p1q1
		if (o2 == 0 && onSegment(p1, q2, q1))
			return true;

		// p2, q2 and p1 are colinear and p1 lies on segment p2q2
		if (o3 == 0 && onSegment(p2, p1, q2))
			return true;

		// p2, q2 and q1 are colinear and q1 lies on segment p2q2
		if (o4 == 0 && onSegment(p2, q1, q2))
			return true;

		return false; // Doesn't fall in any of the above cases
	}

	class Point {
		long x;
		long y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
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
