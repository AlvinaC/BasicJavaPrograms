package com.example.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RPD {
	public static void main(String[] args) throws Exception {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(reader.readLine().trim());
			ArrayList<Long> list = new ArrayList<Long>();
			for (int i = 0; i < tc; i++) {
				int n = Integer.parseInt(reader.readLine().trim());
				String[] integersInString = reader.readLine().split(" ");
				long[] a = new long[n];
				for (int j = 0; j < integersInString.length; j++) {
					a[j] = Long.parseLong(integersInString[j]);
				}
				long mSum = 0;
				long data[] = new long[2];
				mSum = combinationUtil(a, n, 2, 0, data, 0, mSum);

				list.add(mSum);
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	static long combinationUtil(long arr[], int n, int r, int index, long data[], int i, long mSum) {
// Current combination is ready to be printed,  
// print it 
		if (index == r) {
			long sum = 0;
			long prod = data[0] * data[1];
			while (prod > 0) {
				sum += (prod % 10);
				prod /= 10;
			}
			if (sum > mSum)
				mSum = sum;
			return mSum;
		}

// When no more elements are there to put in data[] 
		if (i >= n)
			return mSum;

// current is included, put next at next 
// location 
		data[index] = arr[i];
		mSum = combinationUtil(arr, n, r, index + 1, data, i + 1, mSum);

// current is excluded, replace it with 
// next (Note that i+1 is passed, but 
// index is not changed) 
		mSum = combinationUtil(arr, n, r, index, data, i + 1, mSum);

		return mSum;
	}
}
