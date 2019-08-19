package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.example.programs.Cops.obj;

public class COKE {
	public static void main(String[] args) throws Exception {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			ArrayList<Long> list = new ArrayList<>();
			COKE c = new COKE();
			int tc = Integer.parseInt(reader.readLine().trim());
			for (int i = 0; i < tc; i++) {
				String[] integersInString = reader.readLine().split(" ");
				long n = Long.parseLong(integersInString[0].trim());
				long m = Long.parseLong(integersInString[1].trim());
				long k = Long.parseLong(integersInString[2].trim());
				long l = Long.parseLong(integersInString[3].trim());
				long r = Long.parseLong(integersInString[4].trim());
				long[] a = new long[(int) n];
				long[] price = new long[(int) n];
				for (int j = 0; j < n; j++) {
					String[] integersString = reader.readLine().split(" ");
					a[j] = Long.parseLong(integersString[0].trim());
					price[j] = Long.parseLong(integersString[1].trim());
				}
				pair p = c.sort(a, price, 0, a.length - 1);
				long[] as = p.a;
				long[] ps = p.price;
				int index = -1;
				l1: for (int j = 0; j < n; j++) {
					if (as[j] > k + 1) {
						long value = m * (as[j] - 1);
						if (value <= r && value >= l) {
							if (j > index)
								index = j;
							break l1;
						}
					} else if (as[j] < k - 1) {
						long value = m * (as[j] + 1);
						if (value <= r && value >= l) {
							if (j > index)
								index = j;
							break l1;
						}
					} else if (as[j] <= k + 1 && as[j] >= k + 1) {
						long value = m * k;
						if (value <= r && value >= l) {
							if (j > index)
								index = j;
							break l1;
						}
					}
				}
				if (index != -1)
					list.add(price[index]);
				else
					list.add(-1l);

			}
			for (int i = 0; i < tc; i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// quicksort
	pair sort(long[] a, long[] price, int low, int high) {
		obj o;
		pair p;
		if (low < high) {
			o = partition(a, price, low, high);
			sort(o.a, o.price, low, o.pivotI - 1);
			sort(o.a, o.price, o.pivotI + 1, high);
		}
		return new pair(a, price);
	}

	obj partition(long[] a, long[] price, int low, int high) {
		long pivot = a[high];
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (a[j] < pivot) {
				i++;
				long temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				long p = price[j];
				price[j] = price[i];
				price[i] = p;
			}
		}
		long temp = a[i + 1];
		a[i + 1] = a[high];
		a[high] = temp;
		long p = price[i + 1];
		price[i + 1] = price[high];
		price[high] = p;
		return new obj(a, price, i + 1);
	}

	class obj {
		long[] a;
		long[] price;
		int pivotI;

		public obj(long[] a2, long[] price2, int pivotI) {
			super();
			this.a = a2;
			this.price = price2;
			this.pivotI = pivotI;
		}
	}

	class pair {
		long[] a;
		long[] price;

		public pair(long[] a2, long[] price2) {
			super();
			this.a = a2;
			this.price = price2;

		}
	}

}
