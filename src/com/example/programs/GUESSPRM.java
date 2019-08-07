package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

public class GUESSPRM {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(reader.readLine().trim());
			l1: for (int i = 0; i < tc; i++) {
				HashSet<Long> factors = new HashSet<Long>();
				long x = 100000;
				System.out.println("1 " + x);
				long ans = Long.parseLong(reader.readLine().trim());
				if (ans == -1)
					System.exit(0);
				long val = (x * x) - ans;
				factors = primeFactors(val, ans);
				Iterator<Long> itr = factors.iterator();
				long largestFactor = -1;
				if (factors.size() == 1)
					System.out.println("2 " + itr.next());
				else {
					largestFactor = largest(factors);
					System.out.println("1 " + largestFactor);
					ans = Long.parseLong(reader.readLine().trim());
					val = (largestFactor * largestFactor) - ans;
					HashSet<Long> factors2 = primeFactors(val, ans);
					HashSet<Long> common = findCommon(factors, factors2);
					itr = common.iterator();
					if (common.size() == 1)
						System.out.println("2 " + itr.next());
					else {
						largestFactor = largest(common);
						System.out.println("2 " + largestFactor);
					}
				}
				String result = reader.readLine().trim();
				if (result == "Yes")
					continue l1;
				else if (result == "No")
					System.exit(0);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static HashSet<Long> findCommon(HashSet<Long> a, HashSet<Long> b) {
		if (a.size() > b.size()) {
			return findCommon(b, a);
		}
		HashSet<Long> results = new HashSet<Long>();
		for (Long element : a) {
			if (b.contains(element)) {
				results.add(element);
			}
		}
		return results;
	}

	public static HashSet<Long> primeFactors(long n, long r) {
		HashSet<Long> set = new HashSet<>();
		while (n % 2 == 0) {
			set.add(2l);
			n /= 2;
		}
		for (long i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				set.add(i);
				n /= i;
			}
		}
		if (n > 2)
			if (n > r)
				set.add(n);
		return set;
	}

	public static long largest(HashSet<Long> set) {
		Iterator<Long> itr = set.iterator();
		long max = 0;
		while (itr.hasNext()) {
			long val = itr.next();
			if (val > max)
				max = val;
		}
		return max;
	}
}
