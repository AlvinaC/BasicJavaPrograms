package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BFLSEQ {
	public static void main(String[] args) throws Exception {
		try {
			BFLSEQ f = new BFLSEQ();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(reader.readLine().trim());
			ArrayList<Long> list = new ArrayList<Long>();
			for (int i = 0; i < tc; i++) {
				String[] integersInString1 = reader.readLine().split(" ");
				int n = Integer.parseInt(integersInString1[0]);
				Long k = Long.parseLong(integersInString1[1]);
				Long p = Long.parseLong(integersInString1[2]);
				long[] a = new long[n];
				integersInString1 = reader.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					a[j] = Long.parseLong(integersInString1[j]);
				}
				a = f.sort(a, 0, a.length - 1);
				// boolean[] B = new boolean[a.length];
				// long count = f.subset(a, k, 0, 0, B, p, 0);
				long count = f.printsubset(a, n, k, 0, p);
				list.add(count);

			}
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// quicksort
	long[] sort(long[] a, int low, int high) {
		objQS o;
		if (low < high) {
			o = partition(a, low, high);
			sort(o.a, low, o.pivotI - 1);
			sort(o.a, o.pivotI + 1, high);
		}
		return a;
	}

	objQS partition(long[] a, int low, int high) {
		long pivot = a[high];
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (a[j] < pivot) {
				i++;
				long temp = a[j];
				a[j] = a[i];
				a[i] = temp;
			}
		}
		long temp = a[i + 1];
		a[i + 1] = a[high];
		a[high] = temp;
		return new objQS(a, i + 1);
	}

	class objQS {
		long[] a;
		int pivotI;

		public objQS(long[] a, int pivotI) {
			super();
			this.a = a;
			this.pivotI = pivotI;
		}
	}

	public long subset(long[] A, long k, int start, int currLen, boolean[] used, long p, long cnt) {

		if (currLen == k) {
			long[] temp = new long[(int) k];
			int f = 0;
			boolean flag = true;
			long prev = -1;
			for (int i = 0; i < A.length; i++) {
				if (used[i] == true) {
					if (prev != -1)
						if (!(A[i] - prev <= p)) {
							flag = false;
							break;
						}
					prev = A[i];
				}
			}
			if (flag)
				cnt = (cnt + 1) % (1000000000 + 7);
			return cnt;
		}
		if (start == A.length) {
			return cnt;
		}
		// For every index we have two options,
		// 1.. Either we select it, means put true in used[] and make currLen+1
		used[start] = true;
		long count = subset(A, k, start + 1, currLen + 1, used, p, cnt);
		// 2.. OR we dont select it, means put false in used[] and dont increase
		// currLen
		used[start] = false;
		count = subset(A, k, start + 1, currLen, used, p, count);
		return count;
	}

	long subset(long arr[], long data[], int start, int end, int index, long r, long cnt, long p) {
		int j, i;
		if (index == r) {
			boolean flag = true;
			long prev = -1;
			for (j = 0; j < r; j++) {
				if (prev != -1)
					if (!(data[j] - prev <= p)) {
						flag = false;
						break;
					}
				prev = data[j];
			}
			if (flag)
				cnt = (cnt + 1) % (1000000000 + 7);
			return cnt;
		}
		for (i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			cnt = subset(arr, data, i + 1, end, index + 1, r, cnt, p);
		}
		return cnt;
	}

	long printsubset(long arr[], int n, long r, long count, long p) {
		long[] data = new long[(int) r];
		return subset(arr, data, 0, n - 1, 0, r, count, p);
	}

}
